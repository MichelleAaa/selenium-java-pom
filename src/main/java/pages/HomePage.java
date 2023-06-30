package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

//	We are defining the elements for the page at the very beginning: (In other setup methods we may use an OR.properties file to store these selectors, but not in POM) -- The Below is Page Factory, aka the annotations:

	@FindBy(id="email")
	public WebElement usrname; 
	
	@FindBy(id="pass")
	public WebElement pass;
	
	@FindBy(id="loginbutton")
	public WebElement login;

	
	
	
//	OPTION 2: ANOTHER OPTION IS TO GET THE DRIVER FROM THE TESTCASE ITSELF:
//	Note that we aren't using static anymore. In the past we were executing different test cases in the same sequence. Such as after login, we go to the next step, then next, etc., then close the browser. But with an end to end approach -- if you have 500 test cases, all 500 test cases should be independent of each other. So if you have a login test, and you just want to test that one functionality -- the browser should launch, login is tested, then the browser closes. Then you have a second test case, such as composing an email. We need to login as part of the compose email test. So the steps would be open browser, login, compose email, then close. -- These tests are independent of each other in end to end testing.
//	your driver should become null after each execution. If you keep it static, it will keep the driver reference from session to session instead of setting it back to null when a new test runs.

//	public WebDriver driver;

//	Now in the test cases, whenever we initiate the HomePage class, we have to pass in the current driver for that session/test case.
//	public HomePage(WebDriver driver) {
//		this.driver = driver; 
		//When this function is called, that test case is going to pass in the driver. Then we are updating the driver reference above, which is global, so other methods in the HomePage class will work with this driver we just passed in.
//	} 
	
//	OPTION 3:
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);// Note that because we are in Homepage, we aren't writing HomePage.class, instead, we are using this as the second parameter.
	}
	
	
	
//	Each method is to test a functionality on the page:
	
	public void doLogin(String username, String password) {
		
//		usrname.sendKeys(username);
//		pass.sendKeys(password);
//		login.click();
		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
		
	}
	
	public void createAccount(String firstName, String surName) {
		
	}
	
	public void validateLinks() {
		
	}
}
