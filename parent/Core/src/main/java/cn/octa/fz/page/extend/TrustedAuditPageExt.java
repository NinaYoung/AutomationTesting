package cn.octa.fz.page.extend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basicTool.SelectList;
import cn.octa.fz.page.TrustedAuditPage;

public class TrustedAuditPageExt extends TrustedAuditPage {
	
	//图表显示 第二个下拉菜单
	SelectList graphTab2SelectList;
	//列表显示 第二个下拉菜单
	SelectList listTab2SelectList;
	//列表显示 第三个下拉菜单
	SelectList listTab3SelectList;
	//ML显示 下拉菜单
	SelectList mlTabSelectList;
	//列表显示页面 - 页面跳转
//	Container listTabPageJumpContainer;
	
	public TrustedAuditPageExt(WebDriver driver) {
		super(driver);
		graphTab2SelectList = new SelectList(driver, getGraph2SelectList(), getGraph2MenuItem(), getGraph2DropdownArrow());
		listTab2SelectList = new SelectList(driver, getList2SelectList(), getList2MenuItem(), getList2DropdownArrow());
		listTab3SelectList = new SelectList(driver, getList3SelectList(), getList3MenuItem(), getList3DropdownArrow());
		mlTabSelectList = new SelectList(driver, getMlSelectList(), getMlMenuItem(), getMlDropdownArrow());
//		listTabPageJumpContainer = new Container(getListPageJumpContainer());
	}

	public SelectList getGraphTab2SelectList() {
		return graphTab2SelectList;
	}

	public SelectList getListTab2SelectList() {
		return listTab2SelectList;
	}

	public SelectList getListTab3SelectList() {
		return listTab3SelectList;
	}

	public SelectList getMlTabSelectList() {
		return mlTabSelectList;
	}
	
	/**
	 * click search button on graph page
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt clickGraphSeachButton() throws Exception{
		return click(getGraphSearchButton(), TrustedAuditPageExt.class);
	}
	
	/**
	 * click list show link
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt clickListShowTab() throws Exception{
		return click(getListShowLink(), TrustedAuditPageExt.class);
	}

	/**
	 * click list show link
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt clickMLShowTab() throws Exception{
		return click(getMlShowLink(), TrustedAuditPageExt.class);
	}
	
	/**
	 * click search button on list page
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt clickListSearchButton() throws Exception {
		return click(getListSearchButton(), TrustedAuditPageExt.class);
	}
	
	/**
	 * click list page page jump button
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt clickListPageJumpButton() throws Exception{
		return click(getListPageJumpButton(), TrustedAuditPageExt.class);
	}
	
	/**
	 * click ML page page jump button
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt clickMLPageJumpButton() throws Exception{
		return click(getMlPageJumpButton(), TrustedAuditPageExt.class);
	}
	
    /**
    * click msg ok button 
    */
	public TrustedAuditPageExt clickMessageOkButton() throws Exception{
		return click(getMessageOkButton(), TrustedAuditPageExt.class);
	}
	
	/**
	 * fill num to list page jump text field
	 * @param num
	 *         - the num you want to jump
	 */
	public void fillListPageJumpNum(String num){
		getListPageJumpTextField().sendKeys(num);
	}
	
	/**
	 * fill num to ML page jump text field
	 * @param num
	 *         - the num you want to jump
	 */
	public void fillMLPageJumpNum(String num){
		getMlPageJumpTextField().sendKeys(num);
	}
	
	/**
	 * click "<" to move to previous page
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt jumpToPreviousPage() throws Exception{
		return click(getListPageJumpContainer().get(0), TrustedAuditPageExt.class);
	}
	
	/**
	 * click ">" to move to next page
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt jumpToNextPage() throws Exception{
		return click(getListPageJumpContainer().get(getListPageJumpContainer().size()-1), TrustedAuditPageExt.class);
	}
	
	/**
	 * click "<" to move to previous page
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt mlJumpToPreviousPage() throws Exception{
		return click(getMlPageJumpContainer().get(0), TrustedAuditPageExt.class);
	}
	
	/**
	 * click ">" to move to next page
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt mlJumpToNextPage() throws Exception{
		return click(getMlPageJumpContainer().get(getMlPageJumpContainer().size()-1), TrustedAuditPageExt.class);
	}
	
	/**
	 * click the num to jump to this page
	 * @param num
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt jumpToNumPage(WebElement num) throws Exception{
		return click(num, TrustedAuditPageExt.class);
	}
	
	/**
	 * fill key word for searching
	 * @param keyWord
	 * @return
	 */
	public TrustedAuditPageExt fillMLKeyWordTextField(String keyWord){
		getMlKeyWordTextFiled().clear();
		getMlKeyWordTextFiled().sendKeys(keyWord);
		return this;
	}
	
	public TrustedAuditPageExt clickMLSearchButton() throws Exception{
		return click(getMlSearchButton(), TrustedAuditPageExt.class);
	}
}
