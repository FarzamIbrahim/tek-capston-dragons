package tek.capstone.dragons.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.dragons.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(id = "search")
	public WebElement allDepartmentDropdown;
	@FindBy(id = "searchInput")
	public WebElement searchInputField;
	@FindBy(id = "searchBtn")
	public WebElement searchBtn;
	@FindBy(xpath = "//img[@alt='Kasa Outdoor Smart Plug']")
	public WebElement kasaOutdoorSmortPlugItem;
	@FindBy(xpath = "//select[@class='product__select']")
	public WebElement productQtDropdown;
	@FindBy(xpath = "//span[text()='Add to Cart']")
	public WebElement addToCardBttn;
	@FindBy(xpath = "//span[@id='cartQuantity']")
	public WebElement cardQtyField;
	
	@FindBy(id = "cartBtn")
	public WebElement cartBttn;
	@FindBy(id = "proceedBtn")
	public WebElement proceedToCheckoutBttn;
	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBttn;
	@FindBy(xpath = "//dive[text()='Order Placed Successfully']")
	public WebElement OrderPlacedSuccessfullyMssg;
	@FindBy(xpath = "//img[@alt='Apex Legends - 1,000 Apex Coins']")
	public WebElement apexLegendsItem;
	
	
//Review on the placed order
	
	@FindBy(id = "reviewBtn")
	public WebElement reviewBttn;
	@FindBy(id = "headlineInput")
	public WebElement headlineInputField;
	@FindBy(id = "descriptionInput")
	public WebElement reviewBody;
	@FindBy(id = "reviewSubmitBtn")
	public WebElement reviewSubmitBttn;
	@FindBy(xpath = "//dive[text()='Your review was added successfully']")
	public WebElement reviewSubmitionSuccessMssg;

//User Return the order
	@FindBy(id = "returnBtn")
	public WebElement returnBttn;
	@FindBy(id = "reasonInput")
	public WebElement reasonInputField;
	@FindBy(id = "dropOffInput")
	public WebElement dropOffInputField;
	@FindBy(id = "orderSubmitBtn")
	public WebElement returnOrderSubmitBttn;
	@FindBy(xpath = "//div[@calss='return__confirm-message']")
	public WebElement returnConfMssg;
	
	//Canceling the placed order
		@FindBy(id = "orderLink")
		public WebElement orderLinkField;
		@FindBy(xpath = "//div[@class='order__header']")
		public List<WebElement> ListOfOrder;
		@FindBy(xpath = "//p[@class='order__header-btn']")
		public WebElement orderDetailsDisply;
		@FindBy(id = "cancelBtn")
		public WebElement cancelBttn;
		@FindBy(id = "reasonInput")
		public WebElement cancellationReason;
		@FindBy(id = "orderSubmitBtn")
		public WebElement CancelSubmitBttn;
		@FindBy(xpath = "//p[text()='Your Order Has Been Cancelled']")
		public WebElement yourOrderCancelledMssg;
		
		
		


	
	

}
