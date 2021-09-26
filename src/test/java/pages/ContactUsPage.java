package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

	WebDriver driver;
	WebDriverWait wait;

	public ContactUsPage (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	By label_contact_us = By.xpath("//div[@class='header-container']/h1/font/font");
	By btn_in_shape = By.xpath("//a[@data-popup-template='popup_ArticlePage']"); //id seems to be dynamic for this object
	By btn_reject_all_cookie = By.id("onetrust-reject-all-handler");

	public void navigateToContactUsPage() {
		driver.navigate().to("https://www.intrum.lv/saistibu-parvaldisana/sazinieties-ar-mums/");
		rejectAllCookies(driver.findElement(btn_reject_all_cookie));
	}

	public void openContactUsForm(){
		if (verifyIfComponentIsReady(driver.findElement(btn_in_shape))) {
			driver.findElement(btn_in_shape).click();			
		}else {
			System.out.println("Element not found");
		}
	}

	public void rejectAllCookies(WebElement webElement){
		try {
			Thread.sleep(5000);
			webElement.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean verifyIfComponentIsReady(WebElement webElement){
		wait.until(ExpectedConditions.visibilityOf(webElement));
		if(webElement.isDisplayed() && webElement.isEnabled()) {
			return true;
		}
		return false;
	}
}
