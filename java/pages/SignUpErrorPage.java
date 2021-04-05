package pages;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.PageBase;
import base.TestBase;
import myPackageSelenium.HomePage;
import util.ReadXls;

public class SignUpErrorPage extends PageBase {
	
	public String error_msg = null;
	public static String[] excel_data = null;
	
	@FindBy(id = "title")
	private WebElement title;

	@FindBy(id = "forename")
	private WebElement firstname;

	@FindBy(name = "map(lastName)")
	private WebElement surname;
	
	@FindBy(css = "input.required.checkbox.terms")
	private WebElement terms;
	
	@FindBy(css = "input.promoReg.green")
	private WebElement join_now;
	
    @FindBy(css = "label.error[for = dob]")
    private WebElement error;
    
    //to be added remaining locators of the page

    
	public SignUpErrorPage(WebDriver driver) throws Exception {
		super(driver);
		this.firstname.isDisplayed();
	}
	
	
	//get data from Excel file
	public void getData() {
	    ReadXls cellData = new ReadXls();
	    excel_data = cellData.getCellData();
	}
	
	//set User Details. To be added code for the rest details 
	public void setUserDetails() {		
		getData();	
		int field_number=0;
        int x = 0; 
		
		while (excel_data[x]!=null) {
			field_number++;
			switch (field_number) {
				case 1: 
					title.click();
				    Select titles = new Select(title);
				    titles.selectByVisibleText(excel_data[x]);
				    x++;					
					break;
				case 2:
					this.firstname.clear();
					this.firstname.sendKeys(excel_data[x]);
					x++;				
					break;
				case 3:
					this.surname.clear();
					this.surname.sendKeys(excel_data[x]);
					x++;
					break;	
			}
		}
		setErrorMessage();
	}	
		
	//set the error message from page
	public String setErrorMessage() {
		this.terms.click();
		this.join_now.click();
		// This will capture the error message
		error_msg = error.getText();		
		return error_msg;
	}
	
	//get the error message
	public String getErrorMessage() {
		return error_msg;	
	}
}

