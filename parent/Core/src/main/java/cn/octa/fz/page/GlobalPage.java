package cn.octa.fz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.BasePage;
import basicTool.WaitTool;

public class GlobalPage extends BasePage{

	public GlobalPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, httpDefenselink);
	}
	
	@FindBy(css = ".http-defense")
	public WebElement httpDefenselink;

	public WebElement getHttpDefenselink() {
		return httpDefenselink;
	}
}
