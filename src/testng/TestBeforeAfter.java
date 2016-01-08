package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/*
 *  suite, 
 *  test, 
 *  group, 
 *  class, 
 *  method
 */
public class TestBeforeAfter {

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite(){
		System.out.println("before suite");
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite(){
		System.out.println("after suite");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("before test");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("after test");
	}
	
	@BeforeGroups
	public void beforeGroup(){
		System.out.println("before group");
	}
	
	@AfterGroups
	public void afterGroup(){
		System.out.println("before group");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("before class");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("after class");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("before method");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("after method");
	}
	
	@Test(description="this method is to test before and after methods.",groups= {"testMe"})
	public void testBeforeAfter(){
		System.out.println("IN before after test!!");
	}
}
