package cn.octa.fz.waf;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basicClass.AbstractTest;
import basicClasses.AbstractData;
import basicTool.WaitTool;
import cn.octa.fz.data.WafAttackData;
import cn.octa.fz.page.GlobalPage;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;
import cn.octa.fz.page.extend.WAFPageExt;
import commonMethod.AttackUtils;
import dataTool.DataFactory;
import dvwa.DVWABasePageExt;

public class WafDefenceTest extends AbstractTest {

	@DataProvider(name = "defence", parallel = true)
	public Object[][] provider(){
		return DataFactory.getData(WafAttackData.class, "waf/defence");
	}

	@Test(dataProvider = "defence", groups = {"waf"})
	public void test(WafAttackData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		
		// Go to Waf page
		WAFPageExt wafPageExt = homePageExt.gotoWafPage();
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, wafPageExt.getRadarLabel());
		
		// Record data in radar graph
		wafPageExt.getRadarLabel().click();
		String attackDetails = wafPageExt.getRadarAttackDetailsLabel().getText();
		int	origialCount = AttackUtils.getAttackCount(attackDetails);
		
        // Change status to defence
		wafPageExt.clickSetDefenceButton();
		wafPageExt.changeDefenceStatus(data.getHostname(), data.getStatus());
		if(wafPageExt.getMsgConfirmButton().isDisplayed() && wafPageExt.getAttackChangeMsgLabel().equals(data.getAttackChangeMsg())){
		       wafPageExt.confirmMsg();
		}
		
		// DVWA 		
		DVWABasePageExt.sqlDefenceAttack(driver);
		
		
		// Back to fz again 
		driver.get(AbstractData.getUrl());

		// Go to Waf page
		wafPageExt = homePageExt.gotoWafPage();
		Thread.sleep(50000);
		driver.navigate().refresh();
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, wafPageExt.getRadarLabel());
		wafPageExt.getRadarLabel().click();
		String attackDetails2 = wafPageExt.getRadarAttackDetailsLabel().getText();
		int wafCount = AttackUtils.getAttackCount(attackDetails2);
		
		// Assert attack details changed
		assertTrue(wafCount > origialCount);
		
		// Check log
		assertTrue(wafPageExt.checkLog());
		
		// Go to home page and open global page
		homePageExt = wafPageExt.gotoHomePage();
		GlobalPage globalPage = homePageExt.gotoGlobalpage();
		Thread.sleep(20000);
		takeScreenshot(driver.getTitle());
		
	}
}
