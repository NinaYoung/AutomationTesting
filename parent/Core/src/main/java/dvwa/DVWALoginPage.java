package dvwa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.AbstractPage;
import basicTool.WaitTool;

public class DVWALoginPage extends AbstractPage{

	public DVWALoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, userNameTextField);
	}

	@FindBy(css = "input[name='username']")
	public WebElement userNameTextField;
	
	@FindBy(css = "input[name='password']")
	public WebElement passwordTextField;
	
	@FindBy(css = "input[name='Login']")
	public WebElement loginButton;

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
}
