package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;

public class LoginPage extends TestBase{
		
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement btnlogin;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username1 , String pass)  {
	
		try {
			Thread.sleep(5000);
			username.sendKeys(username1);
			password.sendKeys(pass);
			
			
			
				 WebElement loginBtn = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
					 JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", loginBtn);
					 Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void titleCheck() {
		String title = driver.getTitle();
		Assert.assertEquals("CRMPRO", title);
	}
}
