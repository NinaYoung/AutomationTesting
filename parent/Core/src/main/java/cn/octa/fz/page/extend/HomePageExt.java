package cn.octa.fz.page.extend;

import org.openqa.selenium.WebDriver;

import cn.octa.fz.page.GlobalPage;
import cn.octa.fz.page.HomePage;

public class HomePageExt extends HomePage {

	public HomePageExt(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public GlobalPage gotoGlobalpage() throws Exception{
		return click(getGlobalLabel(), GlobalPage.class);
	}
}
