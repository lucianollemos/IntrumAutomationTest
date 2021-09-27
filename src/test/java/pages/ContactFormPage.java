package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactFormPage {

	protected WebDriver driver;
	private WebDriverWait wait;
	
	public ContactFormPage (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	private By txt_input_name = By.id("71a2bb97-3a3f-434b-e36d-344d0907e7b9");
	private By txt_input_personal_code = By.id("0348625f-721d-430f-f61b-3ea1a44df7b6");
	private By txt_input_case_number = By.id("a6c1035f-7675-445b-ab1f-186d4481692f");
	private By txt_input_phone = By.id("ffc40b29-dfa8-42d8-d33a-1602ef5a4622");
	private By txt_input_email = By.id("c9247843-f302-4fa6-a1b4-2a75b06a95ee");
	private By txt_input_address = By.id("6bbc463e-6ce2-4f52-de13-4777aef7dce7");
	private By txt_input_objection = By.id("bdd7ddc6-ca27-4f20-9fbe-f0264f3c2f3a");
	private By select_answer_type = By.id("e9a9505d-196d-4bac-8d8f-f8a3f406934d");
	private By btn_submit = By.cssSelector("input[type='submit']");
	private By label_input_name_error = By.id("71a2bb97-3a3f-434b-e36d-344d0907e7b9-error");
	private By label_input_personal_code_error = By.id("0348625f-721d-430f-f61b-3ea1a44df7b6-error");
	private By label_input_case_number_error = By.id("a6c1035f-7675-445b-ab1f-186d4481692f-error");
	private By label_input_phone_error = By.id("ffc40b29-dfa8-42d8-d33a-1602ef5a4622-error");
	private By label_input_email_error = By.id("c9247843-f302-4fa6-a1b4-2a75b06a95ee-error");
	private By label_input_address_error = By.id("6bbc463e-6ce2-4f52-de13-4777aef7dce7-error");
	private By label_input_objection_error = By.id("bdd7ddc6-ca27-4f20-9fbe-f0264f3c2f3a-error");
	private By label_input_answer_type_error = By.id("e9a9505d-196d-4bac-8d8f-f8a3f406934d-error");
	
	public void WaitElementVisibility(By by){
		WebElement webElement = driver.findElement(by);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void enterName(String name) {
		WaitElementVisibility(txt_input_name);
		driver.findElement(txt_input_name).sendKeys(name);
	}
	
	public void enterPersonalCode(String personalCode) {
		WaitElementVisibility(txt_input_personal_code);
		driver.findElement(txt_input_personal_code).sendKeys(personalCode);
	}
	
	public void enterCaseNumber(String caseNumber) {
		WaitElementVisibility(txt_input_case_number);
		driver.findElement(txt_input_case_number).sendKeys(caseNumber.toString());
	}
	
	public void enterPhone(String phone) {
		WaitElementVisibility(txt_input_phone);
		driver.findElement(txt_input_phone).sendKeys(phone);
	}
	
	public void enterEmail(String email) {
		WaitElementVisibility(txt_input_email);
		driver.findElement(txt_input_email).sendKeys(email);
	}
	
	public void enterAddress(String address) {
		WaitElementVisibility(txt_input_address);
		driver.findElement(txt_input_address).sendKeys(address);
	}
	
	public void enterObjection(String objection) {
		WaitElementVisibility(txt_input_objection);
		driver.findElement(txt_input_objection).sendKeys(objection);
	}
	
	public void clickSubmitButton () {
		WaitElementVisibility(btn_submit);
		driver.findElement(btn_submit).click();
	}
	
	public String getLabelInputNameErrorText(){
		WaitElementVisibility(label_input_name_error);
		return driver.findElement(label_input_name_error).getText();
	}
	
	public String getLabelInputPersonalCodeErrorText(){
		WaitElementVisibility(label_input_personal_code_error);
		return driver.findElement(label_input_personal_code_error).getText();
	}
	
	public String getLabelInputCaseNumberErrorText(){
		WaitElementVisibility(label_input_case_number_error);
		return driver.findElement(label_input_case_number_error).getText();
	}
	
	public String getLabelInputPersonalPhoneText(){
		WaitElementVisibility(label_input_phone_error);
		return driver.findElement(label_input_phone_error).getText();
	}
	
	public String getLabelInputEmailErrorText(){
		WaitElementVisibility(label_input_email_error);
		return driver.findElement(label_input_email_error).getText();
	}
	
	public String getLabelInputAddressErrorText(){
		WaitElementVisibility(label_input_address_error);
		return driver.findElement(label_input_address_error).getText();
	}

	public String getLabelInputObjectionErrorText(){
		WaitElementVisibility(label_input_objection_error);
		return driver.findElement(label_input_objection_error).getText();
	}
	
	public void selectDropboxItemByText(String answerTypeText) {
		WaitElementVisibility(select_answer_type);
		Select selectAnswerType = new Select(driver.findElement(select_answer_type));
		selectAnswerType.selectByVisibleText(answerTypeText);
	}
	
	public void waitPageLoad(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getLabelInputAnswerTyoeErrorText(){
		WaitElementVisibility(label_input_answer_type_error);
		return driver.findElement(label_input_answer_type_error).getText();
	}

}
