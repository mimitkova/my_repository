package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;
import base.TestBase;
import myPackageSelenium.HomePage;

public class WelcomePage extends PageBase {
	
	@FindBy(css="a.newUser.green")
	public WebElement registerButton;
	
	public WelcomePage(WebDriver driver) throws Exception {
		super(driver);
		registerButton.isDisplayed();
	}
		
	public SignUpErrorPage clickRegisterButton() throws Exception {
		registerButton.click();
		return new SignUpErrorPage(driver);
	}
	
	
	
}
