package cn.octa.fz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.AbstractPage;
import basicTool.WaitTool;

public class LoginPage extends AbstractPage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, userNameTextField);
	}
	
	@FindBy(css = "#login-box #username")
	private WebElement userNameTextField;
	
	@FindBy(css = "#login-box #password")
	private WebElement passwordTextField;
	
	@FindBy(css = ".code-write.inp")
	private WebElement confirmCodeTextField;
	
	@FindBy(css = ".imgCode span:nth-child(1)")
	private WebElement code1Label;
	
	@FindBy(css = ".imgCode span:nth-child(2)")
	private WebElement code2Label;
	
	@FindBy(css = ".imgCode span:nth-child(3)")
	private WebElement code3Label;
	
	@FindBy(css = ".imgCode span:nth-child(4)")
	private WebElement code4Label;
	
	@FindBy(css = ".first-login-btn")
	private WebElement loginButton;
	
	@FindBy(css = ".first-register-btn.common-login-style")
	private WebElement signupFirstButton;
	
	@FindBy(css = ".http-warning span")
	private WebElement warningLabel;

	@FindBy(css = ".checkusers")
	private WebElement checkUserLabel;
	
	@FindBy(css = "#login-box div.checkpasses")
	private WebElement checkPasswordLoginLabel;

	public WebElement getCheckUserLabel() {
		return checkUserLabel;
	}
	public WebElement getCheckPasswordLoginLabel() {
		return checkPasswordLoginLabel;
	}
	public WebElement getWarningLabel() {
		return warningLabel;
	}
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getSignupFirstButton() {
		return signupFirstButton;
	}
	public WebElement getConfirmCodeTextField() {
		return confirmCodeTextField;
	}
	public WebElement getCode1Label() {
		return code1Label;
	}
	public WebElement getCode2Label() {
		return code2Label;
	}
	public WebElement getCode3Label() {
		return code3Label;
	}
	public WebElement getCode4Label() {
		return code4Label;
	}
	
}
