package tek.capstone.dragons.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.dragons.base.BaseSetup;

public class RetailHomePage extends BaseSetup{
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	

	
	/*
	 * instead of findElement() or findElements() 
	 * we use @FindBy annotation to find element or elements
	 * @FindBy is a Selenium annontation, it is used as alternative way to findElement or findElements
	 */
	@FindBy(xpath = "//a[text()='TEKSCHOOL']")
	public WebElement retailLogo;
	
	@FindBy(id = "signinLink")
	public WebElement signInOption;
	
	@FindBy(linkText = "Account")
	public WebElement accountOption;
	
	@FindBy(linkText = "Orders")
	public WebElement orderOption;
	
	@FindBy(id = "logoutBtn")
	public WebElement logOutOption;
	
	@FindBy(xpath = "//span[text()='All']")
	public WebElement allDepartmentsBttn;
	
	@FindBy(xpath = "//div[@class='sidebar_content-item']")
	public List<WebElement> allDepartments;
	
	
	
	

	

}
