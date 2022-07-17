package com.Repo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	private static BaseClass baseClass;
	
	private BaseClass(){
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\RequiredFile\\" + "chromedriver.exe");
	  
        ConfigFileReader configFileReader = new ConfigFileReader();
        driver = new ChromeDriver();
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImpliciteWait(), TimeUnit.SECONDS);        
	}
	
	public static BaseClass instantialBrowser() {
		if(baseClass == null) {
			baseClass = new BaseClass();
		}
		return baseClass;
	}

}