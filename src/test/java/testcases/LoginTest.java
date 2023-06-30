package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;


//Right click - run as - TestNG Test

public class LoginTest {

	@Test
	public void loginTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		
//		OPTION 1:
//		HomePage home = new HomePage(driver);//here we are passing in the specific driver created for this test case. -- This is used when you are using the HomePage method where you pass in driver in the HomePage class.
		
//		OPTIOn 2:
//		When working with Page Factory, we have to do it like this so the elements on that page are initialized:
//		HomePage home = PageFactory.initElements(driver,  HomePage.class); (You would then have to ensure that the HomePage function was active -- currently commented out and replaced for option 3 below:
		
//		Option 3:
		HomePage home = new HomePage();
		
		
		home.doLogin("trainer@test.com", "test");
		
		
	}
}
