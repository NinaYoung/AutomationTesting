package cn.octa.fz.page.extend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basicTool.Container;
import cn.octa.fz.page.WAFPage;
import commonMethod.AttackUtils;

public class WAFPageExt extends WAFPage {
	
	private Container defenceHostsContainer;
	private Container wafLogsContainer;
	
	public WAFPageExt(WebDriver driver) {
		super(driver);
		defenceHostsContainer = new Container(getDefenceHostContainer());
		wafLogsContainer = new Container(getWafLogContainer());
		// TODO Auto-generated constructor stub
	}

	public Container getDefenceHostsContainer() {
		return defenceHostsContainer;
	}

	public Container getWafLogsContainer() {
		return wafLogsContainer;
	}
	/**
	 * 点击 防护设置 按钮
	 * @return
	 * @throws Exception
	 */
	public WAFPageExt clickSetDefenceButton() throws Exception{
		return click(getSetDefenseButton(), WAFPageExt.class);
	}
	
	/**
	 * get index of this host
	 * @param by
	 * @param host
	 * @return
	 */
	public int getHostIndex(By by, String host){
		return defenceHostsContainer.getElementIndexByText(by, host);
	}
	
	/**
	 * change http defence status
	 * @param host
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public WAFPageExt changeDefenceStatus(String host, String status) throws Exception{
		int index = defenceHostsContainer.getElementIndexByText(getHost(), host);
		WebElement element = defenceHostsContainer.getElement(index, getHttpDefence());
		boolean elementStatus= element.getAttribute("class").contains("selectBtnSet0");
		switch(status){
		case "alarm":
			if(elementStatus == true)
				return click(element, WAFPageExt.class);
	     break;
		case "defence":
			if(elementStatus == false)
				return click(element,WAFPageExt.class);
	     break;
	     default:
	    	 return this;		
		}
		return this;
	}
	
	/**
	 * after changing http status, confirm message
	 * @return
	 * @throws Exception
	 */
	public WAFPageExt confirmMsg() throws Exception{
		return click(getMsgConfirmButton(), WAFPageExt.class);
	}

	/**
	 * change to different log oage
	 * @return
	 * @throws Exception
	 */
	public WAFPageExt dosLogPage() throws Exception{
		return click(getDosAttackLogLink(), WAFPageExt.class);
	}
	public WAFPageExt webLogPage() throws Exception{
		return click(getWebAttackLogLink(), WAFPageExt.class);
	}
	public WAFPageExt sensitiveLogPage() throws Exception{
		return click(getSensitiveDataLogLink(), WAFPageExt.class);
	}
	public WAFPageExt identificationLogPage() throws Exception{
		return click(getIdentificationErrorLogLink(), WAFPageExt.class);
	}

	public boolean checkLog() throws Exception{
		// http防御
		String http_date = getWafLogsContainer().getElement(0, getLOG_DATA()).getText();
		boolean http = AttackUtils.checkLogDate(http_date);
		// Dos攻击防御
		dosLogPage();
		String dos_date = getWafLogsContainer().getElement(0, getLOG_DATA()).getText();
		boolean dos = AttackUtils.checkLogDate(dos_date);
		// Web攻击程序
		webLogPage();
		String web_date = getWafLogsContainer().getElement(0, getLOG_DATA()).getText();
		boolean web = AttackUtils.checkLogDate(web_date);
		// 敏感数据追踪
		sensitiveLogPage();
		String sensitive_date = getWafLogsContainer().getElement(0, getLOG_DATA()).getText();
		boolean sensitive = AttackUtils.checkLogDate(sensitive_date);
		// 应用程序鉴定和检测
		identificationLogPage();
		String identification_date = getWafLogsContainer().getElement(0, getLOG_DATA()).getText();
		boolean identification = AttackUtils.checkLogDate(identification_date);
		
		return (http | dos | web | sensitive | identification);
	}
	
	
}
