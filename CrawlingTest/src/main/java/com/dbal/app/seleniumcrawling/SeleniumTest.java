package com.dbal.app.seleniumcrawling;

import java.io.IOException;
import java.util.concurrent.TimeUnit;import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	//WebDriver
	private static WebDriver driver;
	private WebElement element;
		
	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/selenium/chromedriver_win32/chromedriver.exe"; //학원 컴의 저장 위치로 변경
	
	public static void main(String[] args) {
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		
		try {
			driver.get("https://www.10000recipe.com/recipe/list.html?q=%EC%B1%84%EC%8B%9D");
			Thread.sleep(2000);
			WebElement urlElement = driver.findElement(By.xpath("#contents_area_full > ul > ul > li:nth-child(1) > div.common_sp_thumb > a"));
//			System.out.println(driver.getPageSource());			
			System.out.println(urlElement);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
	
	
}
