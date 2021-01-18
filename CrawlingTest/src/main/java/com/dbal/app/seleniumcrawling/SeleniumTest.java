package com.dbal.app.seleniumcrawling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumTest {
	
	//WebDriver
	private WebDriver driver;
	private WebElement element;
	private String url;
		
	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/Users/KWAK/Desktop/selenium/chromedriver_win32/chromedriver.exe"; //학원 컴의 저장 위치로 변경
	public static String TEST_URL = "https://www.10000recipe.com/recipe/list.html?q=%EC%B1%84%EC%8B%9D";
		
	public static void main(String[] args) {
		SeleniumTest test = new SeleniumTest();
	}
	
	public SeleniumTest() {
		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		
	}
	
	
	
	
}
