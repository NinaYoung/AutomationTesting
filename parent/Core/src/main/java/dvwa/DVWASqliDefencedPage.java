package dvwa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.AbstractPage;
import basicTool.WaitTool;

public class DVWASqliDefencedPage extends AbstractPage{

	public DVWASqliDefencedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, forbiddenLabel);
	}

	@FindBy(css = "h1")
	public WebElement forbiddenLabel;

	public WebElement getForbiddenLabel() {
		return forbiddenLabel;
	}
	
}
