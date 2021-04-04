package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.Properties;
import base.TestBase;
import pages.SignUpErrorPage;
import pages.WelcomePage;

public class Test_SignUpErrorPage extends TestBase {

	protected Test_SignUpErrorPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static SignUpErrorPage signUpPage;
	String EXPECTED_ERR = "This field is required";	
	
	@BeforeTest
	public void beforeTest() throws Exception {
		WelcomePage welcomePage = new WelcomePage(driver);
		signUpPage = welcomePage.clickRegisterButton();
	}
	
	@Test
	public void dobErrorMessage() throws Exception {
		signUpPage.setUserDetails();
		String actual_msg = signUpPage.getErrorMessage();
		  // Verify error message
		Assert.assertEquals(actual_msg, EXPECTED_ERR);
	}	
	
	@AfterTest
	public void afterTest() {
		quitDriver();
	}	
}
