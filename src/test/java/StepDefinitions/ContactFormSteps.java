package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
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

	@Given("^user provides valid value to fields (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
	public void user_provides_valid_value_to_fields(String name, String personalCode, String caseNumber, String phone, String email, String address, String objection, String AnswerType) {
		contactFormPage = new ContactFormPage(driver);
		
		contactFormPage.waitPageLoad(3000);
		
		contactFormPage.enterName(name);
		contactFormPage.enterPersonalCode(personalCode);
		contactFormPage.enterCaseNumber(caseNumber);
		contactFormPage.enterPhone(phone);
		contactFormPage.enterEmail(email);
		contactFormPage.enterAddress(address);
		contactFormPage.enterObjection(objection);
		contactFormPage.selectDropboxItemByText(AnswerType);
}
	
	@When("user clicks on submit button without provide value to required fields")
	public void user_clicks_on_submit_button_without_provide_value_to_required_fields() {
		contactFormPage = new ContactFormPage(driver);
		waitAndClicksubmitBtn(contactFormPage);
	}

	@When("clicks on submit button")
	public void clicks_on_submit_button() {
		contactFormPage = new ContactFormPage(driver);
		waitAndClicksubmitBtn(contactFormPage);
	}

	@Then("Messege sent succesfully")
	public void messege_sent_succesfully() {
		//Code to verify and validate a successful submission message
		afterTest(driver);
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
		
		afterTest(driver);
	}

	
	@And("^user inserts an invalid (.*) on email field$")
	public void user_inserts_an_invalid_invalidemail_com(String email) {
		contactFormPage = new ContactFormPage(driver);
		contactFormPage.waitPageLoad(3000);
		contactFormPage.enterEmail(email);
	}
	
	@And("^user inserts an invalid (.*) on case number field$")
	public void user_inserts_invalid_case_number(String caseNumber) {
		contactFormPage = new ContactFormPage(driver);
		contactFormPage.waitPageLoad(3000);
		contactFormPage.enterCaseNumber(caseNumber);
		
	}
	
	@Then("^Validation (.*) should be shown for email field$")
	public void validation_some_validation_message_should_be_shown_for_email_field(String message) {
		try {
			assertEquals(message, contactFormPage.getLabelInputEmailErrorText());
		} catch (NoSuchElementException e) {
			Assert.fail("No validation message shown");
		}finally {
			afterTest(driver);			
		}	
	}
	
	@Then("^Validation (.*) should be shown for case number field$")
	public void validation_some_validation_message_should_be_shown_for_case_number_field(String message) {
		try {
			assertEquals(message, contactFormPage.getLabelInputCaseNumberErrorText());
		} catch (NoSuchElementException e) {
			Assert.fail("No validation message shown");
		}finally {
			afterTest(driver);			
		}	
	}
	

	public WebDriver initDriver(WebDriver diver) {
		System .setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void afterTest(WebDriver driver) {
		driver.close();
		driver.quit();
	}
	
	public void waitAndClicksubmitBtn(ContactFormPage contactFormPage) {
		contactFormPage.waitPageLoad(3000);
		contactFormPage.clickSubmitButton();
	}
}
