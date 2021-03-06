package cn.octa.fz.database;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basicClass.AbstractTest;
import basicTool.StringHelper;
import cn.octa.fz.data.DataBaseData;
import cn.octa.fz.page.extend.DataBasePageExt;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;
import dataTool.DataFactory;
import junit.framework.Assert;

public class DatabaseAddPGHappyFlowTest extends AbstractTest {

	@DataProvider(name = "DatabaseAddPGHappyFlow")
	public Object[][] provider(){
		return DataFactory.getData(DataBaseData.class, "database/dataBaseAddPGHappyFlow");
	}
	
	@Test(dataProvider = "DatabaseAddPGHappyFlow", groups = {"dataBase"})
	public void test(DataBaseData data) throws Exception{
	
		String dbName = data.getDbName() + StringHelper.getRandomString(5);
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);
		
		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		
		driver.manage().window().maximize();
		// Go to dataBase page
		DataBasePageExt dataBasePageExt = homePageExt.gotoDataBasePage();
		
		// Add dataBase
		dataBasePageExt.clickAddDataBaseButton();
		dataBasePageExt.fillAddDBForm(dbName, data.getDbType(), data.getIp(), data.getDbPort(), data.getDbUser(), data.getDbPassword());
		dataBasePageExt.clickAddDBConfirmButton();
		
		// Go to host list to check if the dataBase added successfully
		dataBasePageExt.checkHostList();
		int index = dataBasePageExt.getHostIndex(dataBasePageExt.getHOST_IP(), data.getIp());
		dataBasePageExt.showDataBaseList(index);
		// index 对应的所有的database
		WebElement element = dataBasePageExt.getDataBaseContainer().get(index);
		List<WebElement> databaseList =  element.findElements(dataBasePageExt.getDB_TAG());
		Assert.assertTrue(databaseList.get(databaseList.size()-1).getText().contains(dbName));
		
		// Go to database audit page
		dataBasePageExt.gotoDataBaseAuditPage();
		//....查看审计日志
	}
}
