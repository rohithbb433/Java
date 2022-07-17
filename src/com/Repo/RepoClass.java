package com.Repo;

import org.apache.log4j.Logger;

public class RepoClass extends SeleniumUtilClass {
	
Logger logger = Logger.getLogger(getClass());
	
private String clickOnSignUPDP = "//di[@id='sign-in-icon-down']";
private String clickOnSignUP =  "//li[@id='signInLink']";
private String LoginFrame = "//iframe[@class='modalIframe']";
private String MobileNumber = "//input[@type='number']";


	public void login() {
		
		logger.info("Logging");
		clickOnObject(clickOnSignUPDP);
		jsClickExecute(clickOnSignUP);
		moveToIframe(LoginFrame);
		sendKeyToTextBox(MobileNumber, "89700");
		expliciteWait(1000);
	}
}
