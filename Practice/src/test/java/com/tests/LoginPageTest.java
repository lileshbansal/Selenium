package com.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;
import com.utils.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage login;
	String sheetName = "Sheet1";

	public LoginPageTest() {
		super();
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	
	@Test(dataProvider = "getCRMTestData")
	public void LoginPageTitle(String Username, String Password)  {
		login = new LoginPage(driver);
		login.login(Username, "123456");
		//login.titleCheck();
	}

	
}