package tek.capstone.dragons.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.dragons.pages.POMFactory;
import tek.capstone.dragons.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility {
	POMFactory factory = new POMFactory();
	
//Creating new user account

@When("User click on Create New Account button")
public void userClickOnCreateNewAccountButton() {
	click(factory.accountPage().newAccountBttn);

}
@When("User fill the signUp information with below data")
public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
	List<Map<String, String>> signUpInfo = dataTable.asMaps(String.class, String.class);
	sendText(factory.accountPage().nameInputField, signUpInfo.get(0).get("name"));
	sendText(factory.accountPage().emailInputField, signUpInfo.get(0).get("email"));
	sendText(factory.accountPage().passwordInputField, signUpInfo.get(0).get("password"));
	sendText(factory.accountPage().confirmPasswordInputField, signUpInfo.get(0).get("confirmPassword"));
	logger.info(signUpInfo + "was entered successfully");

}
@When("User click on SignUp button")
public void userClickOnSignUpButton() {
	click(factory.accountPage().signupBttn);
	logger.info("user clicked on signUp button successfully");

}
@Then("User should be logged into account page")
public void userShouldBeLoggedIntoAccountPage() {
	logger.info("user logged into account page successfully");

}

	
//Updating user account 
@When("User click on Account option")
public void userClickOnAccountOption() {
	click(factory.homePage().accountOption);
	logger.info("user clicked on Account option");
   
}
@When("User update Name {string} and Phone {string}")
public void userUpdateNameAndPhone(String nameValue, String phoneValue) {
	clearTextUsingSendKeys(factory.accountPage().nameInput);
	sendText(factory.accountPage().nameInput, nameValue);
	clearTextUsingSendKeys(factory.accountPage().PhoneInput);
	sendText(factory.accountPage().PhoneInput, phoneValue);
	logger.info("user updated the name and phone value");
	
    
}
@When("User click on Update button")
public void userClickOnUpdateButton() {
	click(factory.accountPage().personalUpdateBtn);
	logger.info("user clicked on update button");
 
}
@Then("user profile information should be updated")
public void userProfileInformationShouldBeUpdated() {
	waitTillPresence(factory.accountPage().personalInfoUpdatedSuccessMessage);
	Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdatedSuccessMessage));
	logger.info("user profile information updated");
   
}
//add payment method
@When("User click on Add a payment method link")
public void userClickOnAddAPaymentMethodLink() {
	click(factory.accountPage().addPaymentMethodLink);
	logger.info("User succeessfully click on add payment method link");

}
@When("User fill Debit or credit card information")
public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
	List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
	sendText(factory.accountPage().cardNumberInputField, paymentInfo.get(0).get("cardNumber"));
	sendText(factory.accountPage().nameOfTheCardInputField, paymentInfo.get(0).get("nameOnCard"));
	selectByVisibleText(factory.accountPage().expirationMonthInputField, paymentInfo.get(0).get("expirationMonth"));
	selectByVisibleText(factory.accountPage().expirationYearInputField, paymentInfo.get(0).get("expirationYear"));
	sendText(factory.accountPage().addPaymentMethodLink, paymentInfo.get(0).get("securityCode"));
	logger.info("User entred card information successfully");
}
@When("User click on Add your card button")
public void userClickOnAddYourCardButton() {
	click(factory.accountPage().addYourCardBttn);
	logger.info("Add your card button was clicked successfully");
	
}
@Then("a message should be displayed {string}")
public void aMessageShouldBeDisplayed(String expectedMssg) {
	if(expectedMssg.contains("Payment")) {
		waitTillPresence(factory.accountPage().paymentMethodAddedSucessMessage);
		//This line should validate the message
		Assert.assertEquals(expectedMssg, factory.accountPage().paymentMethodAddedSucessMessage.getText());
		logger.info(expectedMssg + "is displayed");
		
	}else if(expectedMssg.contains("Address")) {
		waitTillPresence(factory.accountPage().addressAddedSuccessfullyMssg);
		Assert.assertEquals(expectedMssg, factory.accountPage().addressAddedSuccessfullyMssg.getText());
		logger.info(expectedMssg + "is displayed");
	}else if(expectedMssg.contains("Payment Method updated")) {
		waitTillPresence(factory.accountPage().paymentMethodUpdatedSuccessMssg);
		Assert.assertEquals(expectedMssg, factory.accountPage().paymentMethodAddedSucessMessage.getText());
		logger.info("Paymen Method Updated Mssg was Verifyed Successfully");
	}else if(expectedMssg.contains("Order Placed")) {
		waitTillPresence(factory.orderPage().OrderPlacedSuccessfullyMssg);
		Assert.assertEquals(expectedMssg, factory.orderPage().OrderPlacedSuccessfullyMssg.getText());
		logger.info(expectedMssg + "message was verified successfully");
	}
}
	
//remove payment method
@When("User select the card ending with {string}")
public void userSelectTheCardEndingWith(String string) {
List<WebElement> cards = factory.accountPage().cardEndingNum;
for(WebElement card : cards) {
	if(card.getText().contains(string)) {
		System.out.println(card.getText());
		click(card);
		logger.info(string + " is selected");
		break;
	}
}
}
@When("User click on remove option of card section")
public void userClickOnRemoveOptionOfCardSection() {
click(factory.accountPage().removeCardBttn);
logger.info("Remove button clicked successfully");
}
@Then("payment details should be removed")
public void paymentDetailsShouldBeRemoved() {
	logger.info("Payment metho removed");
	

}
//add address
@When("User click on Add address option")
public void userClickOnAddAddressOption() {
click(factory.accountPage().addressLink);
logger.info("Add address link clicked successfully");
}
@When("user fill new address form with below information")
public void userFillNewAddressFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	Thread.sleep(5000);
List<Map<String, String>> userInfo = dataTable.asMaps(String.class, String.class);
selectByVisibleText(factory.accountPage().countryDropdown, userInfo.get(0).get("country"));
Thread.sleep(5000);
sendText(factory.accountPage().addressNameInputField, userInfo.get(0).get("fullName"));
clearTextUsingSendKeys(factory.accountPage().addressPhoneInputField);
sendText(factory.accountPage().addressPhoneInputField, userInfo.get(0).get("phoneNumber"));

sendText(factory.accountPage().addressStreetInput, userInfo.get(0).get("streetAddress"));
sendText(factory.accountPage().addressAptInputField, userInfo.get(0).get("apt"));
sendText(factory.accountPage().AddressCityInputField, userInfo.get(0).get("city"));
selectByVisibleText(factory.accountPage().addressStateInputField, userInfo.get(0).get("state"));
clearTextUsingSendKeys(factory.accountPage().addressZipCodeInputField);
sendText(factory.accountPage().addressZipCodeInputField, userInfo.get(0).get("zipCode"));
logger.info("User entred address details successfully");

}
@When("User click Add Your Address button")
public void userClickAddYourAddressButton() {
click(factory.accountPage().addressAddressBttn);
logger.info("Add address button was clicked successfully");

}
//Edit Address


@When("User click on edit address option")
public void userClickOnEditAddressOption() throws InterruptedException {
	Thread.sleep(1000);
	click(factory.accountPage().editAddressAccountOpt);
	Thread.sleep(1000);
	logger.info("user clicked on Edit Address button successfully");
    
}
@When("User click update Your Address button")
public void userClickUpdateYourAddressButton() throws InterruptedException {
	Thread.sleep(1000);
	click(factory.accountPage().EditAddressBttn);
   
}
//Remove Address from account


@When("User click on remove option of Address section")
public void userClickOnRemoveOptionOfAddressSection() {
	click(factory.accountPage().accountLinkRemoveAdd);
	logger.info("User clicked on Remove option successfully");

}
@Then("Address details should be removed")
public void addressDetailsShouldBeRemoved() {
	logger.info("Addreses was removed from account successfully");
	

}







// Edit payment info
@When("User click on Edit option of card section")
public void userClickOnEditOptionOfCardSection() {
click(factory.accountPage().creditDebitCardEditbttn);
}
@When("user edit information with below data")
public void userEditInformationWithBelowData(DataTable dataTable) {
List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
factory.accountPage().clearCreditDebitCardInfo();
sendText(factory.accountPage().cardNumberInputField, data.get(0).get("cardNumber"));
sendText(factory.accountPage().nameOfTheCardInputField, data.get(0).get("nameOnCard"));
selectByVisibleText(factory.accountPage().expirationMonthInputField, data.get(0).get("expirationMonth"));
selectByVisibleText(factory.accountPage().expirationYearInputField, data.get(0).get("expirationYear"));
sendText(factory.accountPage().securityCodeInputField,data.get(0).get("securityCode"));
logger.info("Credit card information has been updated");

}
@When("user click on Update Your Card button")
public void userClickOnUpdateYourCardButton() {
	click(factory.accountPage().addYourCardBttn);
	logger.info("Update button was clicked successfully");

}




}
