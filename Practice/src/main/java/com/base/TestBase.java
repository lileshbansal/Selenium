package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.utils.TestUtil;

public class TestBase {

	public  WebDriver driver;
	public  Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\lilbansa1\\eclipse-workspace\\Practice\\src\\main\\java\\com\\config\\config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	@Parameters("browserName")
	public void initialization(String browserName) {
		
		////////String browserName = prop.getProperty("browser");
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lilbansa1\\Desktop\\ProtractorPractice\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\lilbansa1\\Desktop\\ProtractorPractice\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lilbansa1\\Desktop\\ProtractorPractice\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("baseUrl"));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_timeout, TimeUnit.SECONDS);
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
