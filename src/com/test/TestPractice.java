package com.test;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Repo.RepoClass;
import com.Repo.SeleniumUtilClass;

public class TestPractice extends SeleniumUtilClass {
	RepoClass repoClass;
	
	@BeforeClass
	public void preCondition() {
		repoClass = new RepoClass();	
	}

	@Test
	public void MainTest() {
		repoClass.login();
		
	}
	
	
	@AfterClass
	public void postCondition() {
		
		//closeWebApplication();
		
		//test

	}
	
	@BeforeClass
	public void preCondition() {
		repoClass = new RepoClass();	
	}

	@Test
	public void MainTest() {
		repoClass.login();
		
	}
	
	
	@AfterClass
	public void postCondition() {
		
		//closeWebApplication();
		
		//test

	}
}
}
