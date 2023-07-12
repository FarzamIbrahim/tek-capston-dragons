package tek.capstone.dragons.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.dragons.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
		
		
	}
	
	//Creating new user account
	@FindBy(id = "newAccountBtn")
	public WebElement newAccountBttn;
	@FindBy(id = "nameInput")
	public WebElement nameInputField;
	@FindBy(id = "emailInput")
	public WebElement emailInputField;
	@FindBy(id = "passwordInput")
	public WebElement passwordInputField;
	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPasswordInputField;
	@FindBy(id = "signupBtn")
	public WebElement signupBttn;
	
	// Updating user account 	
	@FindBy(id = "profileImage")
	public WebElement profileImage;
	
	@FindBy(id = "nameInput")
	public WebElement nameInput;
	
	@FindBy(id = "personalPhoneInput")
	public WebElement PhoneInput;
	
	@FindBy(id = "personalUpdateBtn")
	public WebElement personalUpdateBtn;
	
	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdatedSuccessMessage;
	
	//add  payment method
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[3]/div/div[2]/div/div[1]/div/div[2]/div[2]/p")
	public WebElement addPaymentMethodLink;
	
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberInputField;
	
	@FindBy(id = "nameOnCardInput")
	public WebElement nameOfTheCardInputField;
	
	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthInputField;
	
	@FindBy(id = "expirationYearInput")
	public WebElement expirationYearInputField;
	
	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeInputField;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement addYourCardBttn;
	
	@FindBy(xpath = "//dive[text()='Payment Method added sucessfully']")
	public WebElement paymentMethodAddedSucessMessage;
	
	//Edit Payment method
	@FindBy(xpath = "//div[@class='account__payment']//button[text()='Edit']")
	public WebElement creditDebitCardEditbttn;
	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
	public WebElement paymentMethodUpdatedSuccessMssg;
	
	public void clearCreditDebitCardInfo() {
		cardNumberInputField.clear();
		nameOfTheCardInputField.clear();
		securityCodeInputField.clear();
	}
	
	//Remove payment method
	@FindBy(xpath = "//p[@class='account__payment__sub-text']")
	// if you want to validate more then one card at the same time in to our account we need to capture
	// all of them
	public List<WebElement> cardEndingNum;
	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removeCardBttn;
	
	//add address
	@FindBy(xpath = "//div[@class='account__address-new-wrapper']")
	public WebElement addressLink;
	@FindBy(id = "countryDropdown")
	public WebElement countryDropdown;
	@FindBy(id = "fullNameInput")
	public WebElement addressNameInputField;
	@FindBy(id = "phoneNumberInput")
	public WebElement addressPhoneInputField;
	@FindBy(id = "streetInput")
	public WebElement addressStreetInput;
	@FindBy(id = "apartmentInput")
	public WebElement addressAptInputField;
	@FindBy(id = "cityInput")
	public WebElement AddressCityInputField;
	@FindBy(name = "state")
	public WebElement addressStateInputField;
	@FindBy(id = "zipCodeInput")
	public WebElement addressZipCodeInputField;
	@FindBy(id = "addressBtn")
	public WebElement addressAddressBttn;
	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressAddedSuccessfullyMssg;
	
	//Edit address
//	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[2]/button[1]")
//	public WebElement editAddressAccountOpt;
	@FindBy(xpath = "//button[@class='account__address-btn']")
	public WebElement editAddressAccountOpt;
	//@FindBy(xpath = "//select[@class='account__address-new-dropdown']")
	//public WebElement editAddressCountryDropdownOpt;
	@FindBy(id = "countryDropdown")
	public WebElement editAddressCountryDropdown;
	@FindBy(id = "fullNameInput")
	public WebElement editAddressFullNameInputField;
	@FindBy(id = "phoneNumberInput")
	public WebElement editAddressPhoneInputField;
	@FindBy(id = "streetInput")
	public WebElement editAddressStreetInput;
	@FindBy(id = "apartmentInput")
	public WebElement editAddressAptInputField;
	@FindBy(id = "cityInput")
	public WebElement EditAddressCityInputField;
	@FindBy(name = "state")
	public WebElement EditAddressStateInputField;
	@FindBy(id = "zipCodeInput")
	public WebElement EditAddressZipCodeInputField;
	@FindBy(id = "addressBtn")
	public WebElement EditAddressBttn;
	@FindBy(id = "Address Updated Successfully")
	public WebElement editAddressSuccessMssg;
	
//Remove Address from account
	@FindBy(id = "accountLink")
	public WebElement accountLinkRemoveAdd;
	@FindBy(xpath = "//button[@class='account__address-btn']")
	public WebElement removeButtn;
	
	
	
	

}
