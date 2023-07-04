package testcases;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LandingPage;


//Right click - run as - TestNG Test

public class LoginTest {

	@Test
	public void loginTest() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		
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
		
//		Note that we added code into LandingPage and HomePage. The code returns the current instance. Such as LandingPage being returned from the methods. This is so we don't have to do the below, which is step by step creating the instances of the classes, HomePage and LandingPage. 
		
		
//		Option 3:
//		HomePage home = new HomePage(driver);
		
		
//		home.doLogin("trainer@test.com", "test");
		
//		LandingPage lp = new LandingPage(driver);
//		lp.gotoProfile();
		
//		new HomePage(driver).doLogin("trainer@test.com", "test").gotoProfile();//Here, instead of the above, we are using method chaining because HomePage is going to return Landingpage, so we don't have to create the instance in the test cases, but instead, just call the method inside of LandingPage, doLogin, and pass in the username/password. -- While you can do this and it will work, we still typically will use the following syntax instead. (The reason is that the entire thing will fail if you have it chained together.)
		
		HomePage home = new HomePage(driver);
		LandingPage lp = home.doLogin("trainer@test.com", "test");//Because doLogin is returning LandingPage, we are creating a new variable for it.
		lp.gotoProfile();
		
		
		
		
	}
}
