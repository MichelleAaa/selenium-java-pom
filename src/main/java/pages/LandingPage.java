package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LandingPage extends BasePage {
//	After you add the extends BasePage, it will give an error that you need a constructor for this method too:
	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//*[@id=\"navItem_100010051393565\"]/a/div")
	public WebElement profile;
	
//	public LandingPage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
//	We moved the above option 3 into the BasePage file so we don't have to duplicate the code in all of the --Page files.
	
	
	public LandingPage gotoProfile() {
		profile.click();
		
		return this; //Here we are passing on the LandingPage instance, which in this case is this.
	}
	
	public void updateStatus() {
		
	}
	
	public void gotoPages() {
		
	}
	

}
