package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.ContactFormPage;
import pages.ContactUsPage;

public class ContactFormSteps {

	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");	
	ContactUsPage contactUsPage;
	ContactFormPage contactFormPage;

	@Given("user on contact form")
	public void user_on_contact_form() {
		initDriver(driver);
		contactUsPage = new ContactUsPage(driver);

		contactUsPage.navigateToContactUsPage();
		contactUsPage.openContactUsForm();

	}

	@When("user provides valid value to fields ")
	public void user_fields() {
		contactFormPage = new ContactFormPage(driver);
		
		contactFormPage.enterName("");
		contactFormPage.enterPersonalCode("");
		contactFormPage.enterCaseNumber("");
		contactFormPage.enterPhone("");
		contactFormPage.enterEmail("");
		contactFormPage.enterAddress("");
		contactFormPage.enterObjection("");
	}
	
	@When("user clicks on submit button without provide value to required fields")
	public void user_clicks_on_submit_button_without_provide_value_to_required_fields() {
		try {
			contactFormPage = new ContactFormPage(driver);
			Thread.sleep(3000);
			contactFormPage.clickSubmitButton();	
		} catch (Exception e) {
			e.printStackTrace();
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
		driver.close();
		driver.quit();
	}
	
	@Then("^Validation (.*) should be shown for every required field$")
	public void validation_masseges_should_be_shown_for_every_required_field(String message) {
		String errorMessage = message;
		contactFormPage = new ContactFormPage(driver);
		assertEquals(errorMessage, contactFormPage.getLabelInputNameErrorText());
		assertEquals(errorMessage, contactFormPage.getLabelInputPersonalCodeErrorText());
		assertEquals(errorMessage, contactFormPage.getLabelInputPersonalPhoneText());
		assertEquals(errorMessage, contactFormPage.getLabelInputEmailErrorText());
		assertEquals(errorMessage, contactFormPage.getLabelInputAddressErrorText());
		assertEquals(errorMessage, contactFormPage.getLabelInputObjectionErrorText());
		assertEquals(errorMessage, contactFormPage.getLabelInputAnswerTyoeErrorText());
		
		//driver.close();
		//driver.quit();
	}

	public WebDriver initDriver(WebDriver diver) {
		System .setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

}
