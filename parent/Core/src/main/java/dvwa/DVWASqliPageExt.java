package dvwa;

import org.openqa.selenium.WebDriver;

public class DVWASqliPageExt extends DVWASqliPage {

	public DVWASqliPageExt(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public DVWASqliPageExt sqlInjectionAlarm() throws Exception{
		getUserIdTextField().clear();
		getUserIdTextField().sendKeys("1' or '1'='1");
		return click(getSubmitButton(), DVWASqliPageExt.class);
	}
	
	public DVWASqliDefencedPage sqlInjectionDefence() throws Exception{
		getUserIdTextField().clear();
		getUserIdTextField().sendKeys("1' or '1'='1");
		return click(getSubmitButton(), DVWASqliDefencedPage.class);
	}
}
