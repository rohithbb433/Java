package com.Repo;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtilClass {
	
	public static WebDriver browserUtil;
	public SeleniumUtilClass() {
		BaseClass.instantialBrowser();
		browserUtil = BaseClass.driver;
	}
	
	public void closeWebApplication() {
		browserUtil.close();
	}
	
	public void expliciteWait(long timeInMs) {
		try {
			Thread.sleep(timeInMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement locateByXpath(String Locator) {
		return browserUtil.findElement(By.xpath(Locator));
	}
	
	public Actions getActionObject() {
		return new Actions(browserUtil);
	}
	
	public void mouseHoverOnElememts(String Locator) {
		getActionObject().moveToElement(locateByXpath(Locator)).build().perform();
	}
	
	public void rightClickOnObject(String Locator) {
		getActionObject().contextClick(locateByXpath(Locator)).build().perform();
	}
	
	public void clickOnObject(String Locator) {
		locateByXpath(Locator).click();
	}
	
	public void sendKeyToTextBox(String Locator,String Value) {
		locateByXpath(Locator).clear();
		locateByXpath(Locator).sendKeys(Value);
	}
	
	public void moveToIframe(String Locator) {
		browserUtil = browserUtil.switchTo().frame(locateByXpath(Locator));
	}
	
	public void moveToParentFrame() {
		browserUtil = browserUtil.switchTo().defaultContent();
	}
	
	public String getPageTitle() {
	    return browserUtil.getTitle();
	}
	
	public void alertAccept() {
	   browserUtil.switchTo().alert().accept();
	}
	
	public void alertDismise() {
	   browserUtil.switchTo().alert().dismiss();
	}
	
	public void alertGetText() {
	   browserUtil.switchTo().alert().getText();
	}
	
	public String getAttribute(String Locator,String attribute) {
		return locateByXpath(Locator).getAttribute(attribute);
	}
	
	public void selectDropByValue(String Locator,String value) {
		Select select = new Select(locateByXpath(Locator));
		select.selectByValue(value);
	}
	
	public List<WebElement> getDropDownValue(String Locator,String value) {
		Select select = new Select(locateByXpath(Locator));
		return select.getOptions();
	}
	
	public void refreshBrowser() {
		   browserUtil.navigate().refresh();
	}
	
	public void forwardBrowser() {
		   browserUtil.navigate().forward();
	}
	
	public void getScreenShotForFailedTestCases() throws WebDriverException, IOException {
		Date date = new Date();
		TakesScreenshot takesScreenshot = (TakesScreenshot) browserUtil;
		FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE),new File(System.getProperty("user.dir") + "//screenshot" + "Failure" + date.getTime()  + "jpg"));
	}
	
	public void jsClickExecute(String Locator) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) browserUtil;	
		javascriptExecutor.executeScript("arguments[0].click();", locateByXpath(Locator));
	}
	
	public void scrollToSpecificWebElement(String Locator) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) browserUtil;	
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();", locateByXpath(Locator));
	}
	
	
}
