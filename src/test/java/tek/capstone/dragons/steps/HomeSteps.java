package tek.capstone.dragons.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import tek.capstone.dragons.pages.POMFactory;
import tek.capstone.dragons.utilities.CommonUtility;

public class HomeSteps extends CommonUtility {
	
	POMFactory factory = new POMFactory();
	
	@Given("User is on retail website home page")
	public void userIsOnRetailWebsiteHomePage() {
		
	}

@When("User click on All section")
public void userClickOnAllSection() {
	click(factory.homePage().allDepartmentsBttn);
	logger.info("All Departments button clicked successfully");

}
@When("User on <department>")
public void userOnDepartment() {
	List<WebElement> dept = factory.homePage().allDepartments;
	for(WebElement elements : dept) {
		elements.click();
		break;
	}

}
@Then("below options are present in department")
public void belowOptionsArePresentInDepartment(DataTable dataTable) {
	List<List<String>> options = dataTable.asLists(String.class);
	List<WebElement> depts = factory.homePage().allDepartments;
	for(int i = 0; i <options.get(0).size(); i++) {
		for(WebElement elements : depts) {
			if(elements.getText().equals(options.get(0).get(i))) {
				Assert.assertTrue(elements.isDisplayed());
				logger.info(elements.getText() + " is present");
			}
		}
	}
	

}
@Then("below options are present in Shop by Department sidebar")
public void belowOptionsArePresentInShopByDepartmentSidebar(io.cucumber.datatable.DataTable dataTable) {
	List<List<String>> options = dataTable.asLists(String.class);
	List<WebElement> depts = factory.homePage().allDepartments;
	for(int i = 0; i <options.get(0).size(); i++) {
		for(WebElement elements : depts) {
			if(elements.getText().equals(options.get(0).get(i))) {
				Assert.assertTrue(elements.isDisplayed());
				logger.info(elements.getText() + " is present");
			}
		}
	}

}





}
