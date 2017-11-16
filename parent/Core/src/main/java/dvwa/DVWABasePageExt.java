package dvwa;

import org.openqa.selenium.WebDriver;

import basicClasses.AbstractData;
import basicClasses.SecurityLevel;

public class DVWABasePageExt extends DVWABasePage {

	public DVWABasePageExt(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	/**
//	 * go to security page
//	 * @return
//	 * @throws Exception
//	 */
//	public DVWASecurityPageExt gotoSecurityPage() throws Exception{
//		return click(getSecurityLink(), DVWASecurityPageExt.class);
//	}
//	
//	/**
//	 * go to sqli page
//	 * @return
//	 * @throws Exception
//	 */
//	public DVWASqliPageExt gotoSqliPage() throws Exception{
//		return click(getSqliLink(), DVWASqliPageExt.class);
//	}
	
	/**
	 * sql Injection for defence 
	 * @param driver
	 * @throws Exception
	 */
	public static void sqlDefenceAttack(WebDriver driver) throws Exception{
		driver.get(AbstractData.getDvwaUrl());
		driver.navigate().refresh();
		DVWALoginPageExt dvwaLoginPageExt = new DVWALoginPageExt(driver);
		DVWABasePageExt dvwaBasePageExt = dvwaLoginPageExt.login();
		DVWASecurityPageExt  dvwaSecurityPageExt = dvwaBasePageExt.gotoSecurityPage();
		dvwaSecurityPageExt.changeLevel(SecurityLevel.LOW.getLevel());
		DVWASqliPageExt dvwaSqliPageExt = dvwaSecurityPageExt.gotoSqliPage();
		dvwaSqliPageExt.sqlInjectionDefence();
	}
	
	/**
	 * sql Injection for defence automatically
	 * @param driver
	 * @throws Exception
	 */
	public static void sqlDefenceSecondAttack(WebDriver driver) throws Exception{
		driver.get(AbstractData.getDvwaUrl());
		driver.navigate().refresh();
		DVWABasePageExt dvwaBasePageExt = new DVWABasePageExt(driver);
		DVWASecurityPageExt  dvwaSecurityPageExt = dvwaBasePageExt.gotoSecurityPage();
		dvwaSecurityPageExt.changeLevel(SecurityLevel.LOW.getLevel());
		DVWASqliPageExt dvwaSqliPageExt = dvwaSecurityPageExt.gotoSqliPage();
		dvwaSqliPageExt.sqlInjectionDefence();
	}
	
	/**
	 * sql Injection for alarm 
	 * @param driver
	 * @throws Exception
	 */
	public static void sqlAlarmAttack(WebDriver driver) throws Exception{
		driver.get(AbstractData.getDvwaUrl());
		driver.navigate().refresh();
		DVWALoginPageExt dvwaLoginPageExt = new DVWALoginPageExt(driver);
		DVWABasePageExt dvwaBasePageExt = dvwaLoginPageExt.login();
		DVWASecurityPageExt  dvwaSecurityPageExt = dvwaBasePageExt.gotoSecurityPage();
		dvwaSecurityPageExt.changeLevel(SecurityLevel.LOW.getLevel());
		DVWASqliPageExt dvwaSqliPageExt = dvwaSecurityPageExt.gotoSqliPage();
		dvwaSqliPageExt.sqlInjectionAlarm();
	}
}
