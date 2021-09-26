package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactFormPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public ContactFormPage (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	By txt_input_name = By.id("71a2bb97-3a3f-434b-e36d-344d0907e7b9");
	By txt_input_personal_code = By.id("0348625f-721d-430f-f61b-3ea1a44df7b6");
	By txt_input_case_number = By.id("a6c1035f-7675-445b-ab1f-186d4481692f");
	By txt_input_phone = By.id("ffc40b29-dfa8-42d8-d33a-1602ef5a4622");
	By txt_input_email = By.id("c9247843-f302-4fa6-a1b4-2a75b06a95ee");
	By txt_input_address = By.id("6bbc463e-6ce2-4f52-de13-4777aef7dce7");
	By txt_input_objection = By.id("bdd7ddc6-ca27-4f20-9fbe-f0264f3c2f3a");
	By btn_submit = By.xpath("imput[@type='submit']");
	
	public void WaitElementVisibility(WebElement webElement){
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void enterName(String name) {
		driver.findElement(txt_input_name).sendKeys(name);
	}
	
	public void enterPersonalCode(String personalCode) {
		driver.findElement(txt_input_personal_code).sendKeys(personalCode);
	}
	
	public void enterCaseNumber(String caseNumber) {
		driver.findElement(txt_input_case_number).sendKeys(caseNumber);
	}
	
	public void enterPhone(String phone) {
		driver.findElement(txt_input_phone).sendKeys(phone);
	}
	
	public void enterEmail(String email) {
		driver.findElement(txt_input_email).sendKeys(email);
	}
	
	public void enterAddress(String address) {
		driver.findElement(txt_input_address).sendKeys(address);
	}
	
	public void enterObjection(String objection) {
		driver.findElement(txt_input_objection).sendKeys(objection);
	}
	
	public void clickSubmitButton () {
		driver.findElement(btn_submit).click();
	}
}
