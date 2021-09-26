package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.ContactUsPage;

public class ContactFormSteps {

	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");	
	ContactUsPage contactUsPage;

	@Given("user on contact form")
	public void user_on_contact_form() {
		
		initDriver(driver);
		contactUsPage = new ContactUsPage(driver);
		
		try {
			contactUsPage.navigateToContactUsPage();
			contactUsPage.openContactUsForm();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user fullfill all required fields")
	public void user_fullfill_all_required_fields() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@And("clicks on Submit button")
	public void clicks_on_submit_button() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Then("Messege sent succesfully")
	public void messege_sent_succesfully() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public WebDriver initDriver(WebDriver diver) {
		System .setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}

}
