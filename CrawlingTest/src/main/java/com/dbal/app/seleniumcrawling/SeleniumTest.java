package com.dbal.app.seleniumcrawling;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
	
	//WebDriver
	private static WebDriver driver;
	private WebElement element;
		
	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/selenium/chromedriver_win32/chromedriver.exe"; //학원 컴의 저장 위치로 변경
	
	public static void main(String[] args) {
		
		//WebDriver 경로 설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		//WebDriver 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); //전체 화면으로 실행
		options.addArguments("--disable-popup-blocking"); //팝업 무시
		options.addArguments("--disable-default-apps"); //기본앱 사용 안함
		
		//WebDriver 객체 생성
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.10000recipe.com/recipe/list.html?q=%EC%B1%84%EC%8B%9D");
		
		List<WebElement> urlElements = driver.findElements(By.cssSelector(".common_sp_thumb"));
		
		System.out.println(urlElements.size());
		
		for(int i = 1; i <= 40; i++) {
			ListIterator<WebElement> url = urlElements.listIterator();
			System.out.println(url);
			}
		
	}
	
	
}
