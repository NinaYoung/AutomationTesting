package basicClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cn.octa.fz.page.DataBaseAuditPage;
import cn.octa.fz.page.extend.BasePageExt;
import cn.octa.fz.page.extend.DataBasePageExt;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;
import cn.octa.fz.page.extend.TrustedAuditPageExt;
import cn.octa.fz.page.extend.WAFPageExt;
import cn.octa.fz.page.extend.WhiteListPageExt;

/**
 * this page is to define elements on the menu
 * @author YN
 *
 */
public class BasePage extends AbstractPage{

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	//首页
	@FindBy(css = "a[href*='home']")
	private WebElement homeLink;
	
	//数据库
	@FindBy(css = "a[href*='dataBase']")
	private WebElement dataBaseLink;
	
	//可信审计
	@FindBy(css = "a[href*='environment']")
	private WebElement environmentLink;
	
	//白名单
	@FindBy(css = "a[href*='whitelist']")
	private WebElement whitelistLink;
	
	//插件
	@FindBy(css = "a[href*='plugin']")
	private WebElement pluginLink;
	
	//系统审计
	@FindBy(css = "a[href*='systemCheck']")
	private WebElement systemCheckLink;
	
	//WAF防火墙
	@FindBy(css = "a[href*='wafWall']")
	private WebElement wafWallLink;
	
	//数据库审计
	@FindBy(css = "a[href*='databaseAudit']")
	private WebElement databaseAuditLink;
	
	//全球感知
	@FindBy(css = "a[href*='MapAttack']")
	private WebElement mapAttackLink;
	
	//区块链
	@FindBy(css = "a[href*='BoxLine']")
	private WebElement boxLineLink;
	
	//大数据分析
	@FindBy(css = "a[href*='BigData']")
	private WebElement bigDataLink;
	
    public final String TITLE = "欢迎您";
	
	@FindBy(css = "#basic-nav-dropdown")
	private WebElement welcomeButton;

	@FindBy(css = "ul.dropdown-menu > li:first-child a")
	private WebElement changePasswordButton;

	@FindBy(css = "ul.dropdown-menu > li:last-child a")
	private WebElement logoutButton;

	@FindBy(css = "#Password:last-child")
	private WebElement currentPwdTextField;

	@FindBy(css = "input#newPassword:last-child")
	private WebElement newPasswordTextField;
	
	@FindBy(css = "input#confirmPassword:last-child")
	private WebElement confirmPwdTextField;
	
	//修改密码取消按钮
	@FindBy(css = ".modalCancelBtn")
	private WebElement cancelButton;
	
	//修改密码提交按钮
	@FindBy(css = ".modalSubmitBtn")
	private WebElement submitButton;
	
	public WebElement getPopUpMsgLabel() {
		return popUpMsgLabel;
	}

	public WebElement getChangePwdMsgLabel() {
		return changePwdMsgLabel;
	}

	//修改密码弹框里的关闭按钮
	@FindBy(css = ".close")
	private WebElement xButton;
	
	//修改完密码之后的确认按钮
	@FindBy(css = ".btnOkMsgBox.btnMsgBox")
	private WebElement msgOkButton;
	
	@FindBy(css = "noscript+div > div.messageBox > div.msgContent")
	private WebElement popUpMsgLabel;
	
	@FindBy(css = "#result")
	private WebElement changePwdMsgLabel;
	
	public WebElement getMsgOkButton() {
		return msgOkButton;
	}
	
	public WebElement getBigDataLink() {
		return bigDataLink;
	}

	public String getTITLE() {
		return TITLE;
	}

	public WebElement getWelcomeButton() {
		return welcomeButton;
	}

	public WebElement getChangePasswordButton() {
		return changePasswordButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getCurrentPwdTextField() {
		return currentPwdTextField;
	}

	public WebElement getNewPasswordTextField() {
		return newPasswordTextField;
	}

	public WebElement getConfirmPwdTextField() {
		return confirmPwdTextField;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getxButton() {
		return xButton;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}
	
	public WebElement getDataBaseLink() {
		return dataBaseLink;
	}

	public WebElement getEnvironmentLink() {
		return environmentLink;
	}

	public WebElement getWhitelistLink() {
		return whitelistLink;
	}

	public WebElement getPluginLink() {
		return pluginLink;
	}

	public WebElement getSystemCheckLink() {
		return systemCheckLink;
	}

	public WebElement getWafWallLink() {
		return wafWallLink;
	}

	public WebElement getDatabaseAuditLink() {
		return databaseAuditLink;
	}

	public WebElement getMapAttackLink() {
		return mapAttackLink;
	}

	public WebElement getBoxLineLink() {
		return boxLineLink;
	}
	
	/**
	 * click welcome button
	 * @return
	 * @throws Exception
	 */
	public HomePageExt clickWelcomeButton() throws Exception{
		return click(getWelcomeButton(), HomePageExt.class);
	}
	
	/**
	 * Click change password button to change password
	 * @return
	 * @throws Exception
	 */
	public HomePageExt gotoChangePassword() throws Exception{
		return click(getChangePasswordButton(), HomePageExt.class);
	}
	
	/**
	 * click cancel button to cancel 
	 * @return
	 * @throws Exception
	 */
	public HomePageExt cancelChangePassword() throws Exception{
		return click(getCancelButton(), HomePageExt.class);
	}

	/**
	 * click X to cancel
	 * @return
	 * @throws Exception
	 */
	public HomePageExt xToCancelChangePassword() throws Exception{
		return click(getxButton(), HomePageExt.class);
	}
	
	/**
	 * fill change password form
	 * @param currentPassword
	 *            - current password
	 * @param newPassword
	 *            - the password you want to change
	 * @param confirmPwd
	 *            - confirm the new password
	 */
	protected void fill(String currentPassword, String newPassword, String confirmPwd){
		getCurrentPwdTextField().clear();
		getCurrentPwdTextField().sendKeys(currentPassword);
		getNewPasswordTextField().clear();
		getNewPasswordTextField().sendKeys(newPassword);
		getConfirmPwdTextField().clear();
        getConfirmPwdTextField().sendKeys(confirmPwd);
	}
	
	/**
	 *  change password
	 * @param currentPassword
	 *            - current password
	 * @param newPassword
	 *            - the password you want to change
	 * @param confirmPwd
	 *            - confirm the new password
	 * @return
	 *        confirm change password successfully button
	 * @throws Exception
	 */
	public BasePageExt changePassword(String currentPassword, String newPassword, String confirmPwd) throws Exception{
		
		fill(currentPassword, newPassword, confirmPwd);
		return click(getSubmitButton(), BasePageExt.class);
	}
	
	/**
	 * logout to LoginPageExt
	 * @return
	 * @throws Exception
	 */
	public LoginPageExt logout() throws Exception{
		click(getWelcomeButton(), HomePageExt.class);
		return click(getLogoutButton(), LoginPageExt.class);
	}
	/**
	 * go to home page
	 * @return
	 * @throws Exception
	 */
	public HomePageExt gotoHomePage() throws Exception{
		return click(getHomeLink(), HomePageExt.class);
	}
	
	/**
	 * go to database page
	 * @return
	 * @throws Exception
	 */
	public DataBasePageExt gotoDataBasePage() throws Exception{
		return click(getDataBaseLink(), DataBasePageExt.class);
	}
	
	/**
	 * go to trusted audit page
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt gotoTrustedAuditPage() throws Exception{
		return click(getEnvironmentLink(), TrustedAuditPageExt.class);
	}
	
	/**
	 * go to white list page
	 * @return
	 * @throws Exception
	 */
	public WhiteListPageExt gotoWhiteListPage() throws Exception{
		return click(getWhitelistLink(), WhiteListPageExt.class);
	}
	
	/**
	 * go to waf page
	 * @return
	 * @throws Exception
	 */
	public WAFPageExt gotoWafPage() throws Exception{
		return click(getWafWallLink(), WAFPageExt.class);
	}
	
	/**
	 * click message ok button to confirm changing password successfully
	 * @return
	 * @throws Exception
	 */
	public BasePageExt clickMsgOkButton() throws Exception{
		return click(getMsgOkButton(), BasePageExt.class);
	}
	
	/**
	 * go to database audit page
	 * @return
	 * @throws Exception
	 */
	public DataBaseAuditPage gotoDataBaseAuditPage() throws Exception{
		return click(getDatabaseAuditLink(), DataBaseAuditPage.class);
	}
}
