package tek.capstone.dragons.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.capstone.dragons.utilities.CommonUtility;

public class BaseUITest extends CommonUtility {

	/*
	 * @Before hook
	 * 
	 * @Before is a cucumber hook and we can setup this block of code under this
	 * cucumber annotation under any class' but for the purpose of our test
	 * automation framework, we will setup the @Before hook in our baseUI class.
	 * 
	 * @After is a cucumber hook and we can setup the block of code under this
	 * cucumber annotation under any class, but for the purpose of our test
	 * automation framework, we will setup the @After hook in our baseUI class.
	 */
	/*
	 * Using Scenario class from cucumber, we can pass this in our @After hook
	 * method parameter, so that just in case the test step fails and scenario
	 * fails, we can take screenshot for the failed test step.
	 * 
	 */

	@Before
	public void setuptTest() {
		super.setupBrowser();
	}

	@After
	public void closeTests(Scenario scenario) {
		// we need to write our code to check and see if scenario is failed, it should
		// take a screenshot
		// and attache it to out test report.
		if (scenario.isFailed()) {
			byte[] screenshot = takeScreenShotAsBytes();
			scenario.attach(screenshot, "image/png", scenario.getName() + "scenario failed");
			
		}
		super.quitBrowser();
	}

}
