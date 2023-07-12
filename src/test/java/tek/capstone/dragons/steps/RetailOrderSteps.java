package tek.capstone.dragons.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;
import tek.capstone.dragons.pages.POMFactory;
import tek.capstone.dragons.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility{
	
	POMFactory factory = new POMFactory();
	
//Add  items to cart
@When("User change the category to {string}")
public void userChangeTheCategoryTo(String SmartHome) {
	selectByVisibleText(factory.orderPage().allDepartmentDropdown, SmartHome);
	logger.info(SmartHome + "option is selected successfully");
}
@When("User search for an item {string}")
public void userSearchForAnItem(String kasaOutdoorSmartPlug) {
	sendText(factory.orderPage().searchInputField, kasaOutdoorSmartPlug);
	logger.info(kasaOutdoorSmartPlug + "item name was entered successfully");
}
@When("User click on Search icon")
public void userClickOnSearchIcon() {
	click(factory.orderPage().searchBtn);
	logger.info("Serch button was clicked successfully");
}
@When("User click on item")
public void userClickOnItem() {
	click(factory.orderPage().kasaOutdoorSmortPlugItem);
	logger.info(" Item was clicked successfully");
}
@When("User select quantity {string}")
public void userSelectQuantity(String itemQty) {
	selectByVisibleText(factory.orderPage().productQtDropdown, itemQty);
	logger.info("Item quantity was selected successfully");
}
@When("User click add to Cart button")
public void userClickAddToCartButton() {
	click(factory.orderPage().addToCardBttn);
	logger.info("Add to card button was clicked successfully");
}
@Then("the cart icon quantity should change to {string}")
public void theCartIconQuantityShouldChangeTo(String itemQtyIntheCart) {
	Assert.assertEquals(itemQtyIntheCart, factory.orderPage().cardQtyField.getText());
	logger.info(itemQtyIntheCart + "quantity was displayed in the cart");
}

//Add Item and proceed to Checkout

@When("User search for an item Apex Legends {string}")
public void userSearchForAnItemApexLegends(String apexLegends) {
	sendText(factory.orderPage().searchInputField, apexLegends);
	logger.info(apexLegends + "entered successfully");
}
@And("User click on item Apex Legends")
public void userClickOnItemApexLegends() {
	click(factory.orderPage().apexLegendsItem);
	logger.info("Item was clicked successfully");
}
@When("User select Apex Legends quantity {string}")
public void userSelectApexLegendsQuantity(String itemQty) {
	selectByVisibleText(factory.orderPage().productQtDropdown, itemQty);
	logger.info(itemQty + "quantity was slected successfully");
}
@Then("the cart icon quantity Apex Legends should change to {string}")
public void theCartIconQuantityApexLegendsShouldChangeTo(String expectecQty) {
	Assert.assertEquals(expectecQty, factory.orderPage().cardQtyField.getText());
	logger.info(expectecQty + "quantity was validated successfully");
}
@Then("User click on Cart option")
public void userClickOnCartOption() {
	click(factory.orderPage().cartBttn);
	logger.info("cart button was clicked successfully");
}
@Then("User click on Proceed to Checkout button")
public void userClickOnProceedToCheckoutButton() {
	click(factory.orderPage().proceedToCheckoutBttn);
	logger.info("Procced to checkout button was clicked successfully");
}
@Then("User click on Place Your Order")
public void userClickOnPlaceYourOrder() {
	click(factory.orderPage().placeOrderBttn);
	logger.info("Plece your order button was clicked successfully");
}

// User review on order

@When("User click on Review button")
public void userClickOnReviewButton() {
	click(factory.orderPage().reviewBttn);
	logger.info("User clicked on review buttn successfully");
}
@When("User write Review headline {string}")
public void userWriteReviewHeadline(String myOrderPlacedThanks) {
	sendText(factory.orderPage().headlineInputField,  myOrderPlacedThanks);
	logger.info(myOrderPlacedThanks + "entered successfully");
}
@When("User write Review body'review text'")
public void userWriteReviewBodyReviewText() {
	sendText(factory.orderPage().reviewBody, "My orer placed, it was fast");
}
@When("User click Add your Review button")
public void userClickAddYourReviewButton() {
	click(factory.orderPage().reviewSubmitBttn);
	logger.info("Review button clicked successfully");
}
@Then("a review message should be displayed {string}")
public void aReviewMessageShouldBeDisplayed(String yourReviewWasAddedSuccessfully) {
	Assert.assertEquals(yourReviewWasAddedSuccessfully, factory.orderPage().reviewSubmitionSuccessMssg);
	logger.info(yourReviewWasAddedSuccessfully + "was displayed");
}

//User Return the order

@When("User click on Return Items button")
public void userClickOnReturnItemsButton() {
	click(factory.orderPage().returnBttn);
	logger.info("user clicked on ReturnButton");
}
@When("User select the Return Reason {string}")
public void userSelectTheReturnReason(String reasonInputField) {
	selectByVisibleText(factory.orderPage().reasonInputField, reasonInputField);
	logger.info(reasonInputField + "was selected successfully");
}
@When("User select the drop off service {string}")
public void userSelectTheDropOffService(String dropOffInputField) {
	selectByVisibleText(factory.orderPage().dropOffInputField, dropOffInputField);
	logger.info(dropOffInputField + "was selected successfully");
}
@When("User click on Return Order button")
public void userClickOnReturnOrderButton() {
	click(factory.orderPage().returnOrderSubmitBttn);
	logger.info("user clicked on return order submission button successfully");
}

@Then("a return message should be displayed {string}")
public void aReturnMessageShouldBeDisplayed(String returnWasSuccessful) {
 Assert.assertEquals(returnWasSuccessful, factory.orderPage().returnConfMssg);
 logger.info(returnWasSuccessful + "was displyed");
}


//Cancel the order
@When("User click on Orders section")
public void userClickOnOrdersSection() {
click(factory.orderPage().orderLinkField);
logger.info("Order link clicked successfully");
}
@When("User click on first order in list")
public void userClickOnFirstOrderInList() {
	//We can do some Validation so can store everything that we get from ui in a list of web element
	List<WebElement> listOfOrders = factory.orderPage().ListOfOrder;
	//then we can add a validation, we can loop through this list
	for(int i = 0; i < listOfOrders.size(); i++) {
		//once we go through everyone of them
		if(factory.orderPage().orderDetailsDisply.getText().equals("Hide Details")) {
			if(factory.orderPage().cancelBttn.isDisplayed()) {
				break;
			}	
		}else if(factory.orderPage().orderDetailsDisply.getText().equals("Show Details")) {
			click(factory.orderPage().orderDetailsDisply);
			if(factory.orderPage().cancelBttn.isDisplayed()) {
				break;
			}	
		}				
	}
}

@When("User click on Cancel The Order button")
public void userClickOnCancelTheOrderButton() {
	click(factory.orderPage().cancelBttn);
	logger.info("cancel the order button was clicked successfully");
}
@When("User select the cancelation Reason {string}")
public void userSelectTheCancelationReason(String cancellationReason) {
	selectByVisibleText(factory.orderPage().cancellationReason, cancellationReason);
	logger.info(cancellationReason + "reason was selected successfully");
}
@When("User click on Cancel Order button")
public void userClickOnCancelOrderButton() {
	click(factory.orderPage().CancelSubmitBttn);
	logger.info("Cancel submit button was clicked successfully");
}
@Then("a cancelation message should be displayed {string}")
public void aCancelationMessageShouldBeDisplayed(String cancellationMssg) {
	Assert.assertEquals(cancellationMssg, factory.orderPage().yourOrderCancelledMssg);
	logger.info(cancellationMssg + "was verified successfully");
}



}
