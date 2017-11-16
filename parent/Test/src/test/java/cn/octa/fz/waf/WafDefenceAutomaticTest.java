package cn.octa.fz.waf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basicClass.AbstractTest;
import basicClasses.AbstractData;
import basicTool.WaitTool;
import cn.octa.fz.data.WafAttackData;
import cn.octa.fz.page.extend.DataBasePageExt;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;
import cn.octa.fz.page.extend.WAFPageExt;
import commonMethod.AttackUtils;
import dataTool.DataFactory;
import dvwa.DVWABasePageExt;

public class WafDefenceAutomaticTest extends AbstractTest {
	
	@DataProvider(name = "defenceAutomatic", parallel = true)
	public Object[][] provider(){
		return DataFactory.getData(WafAttackData.class, "waf/defenceAutomatic");
	}

	@Test(dataProvider = "defenceAutomatic", groups = {"waf"})
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
		
        // Change status to alarm
		wafPageExt.clickSetDefenceButton();
		wafPageExt.changeDefenceStatus(data.getHostname(), data.getStatus());
		if(wafPageExt.getMsgConfirmButton().isDisplayed() && wafPageExt.getAttackChangeMsgLabel().equals(data.getAttackChangeMsg())){
		       wafPageExt.confirmMsg();
		}
		
		// DVWA 
		DVWABasePageExt.sqlAlarmAttack(driver);
		
		
		// Back to fz again 
		driver.get(AbstractData.getUrl());
		
		// Go to databasepage to check topology
		DataBasePageExt dataBasePageExt = homePageExt.gotoDataBasePage();
		Thread.sleep(20000);
		driver.navigate().refresh();
		takeScreenshot(driver.getTitle());

		// DVWA attack again, should get 403
		DVWABasePageExt.sqlDefenceSecondAttack(driver);
		
	}

}
