package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

	protected WebDriver driver;
	WebDriverWait wait;

	public ContactUsPage (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	//private By label_contact_us = By.xpath("//div[@class='header-container']/h1/font/font");
	private By btn_in_shape = By.xpath("//a[@data-popup-template='popup_ArticlePage']"); //id seems to be dynamic for this object
	private By btn_reject_all_cookie = By.id("onetrust-reject-all-handler");

	public void navigateToContactUsPage() {
		WebElement rejectCookieBtn;
		driver.navigate().to("https://www.intrum.lv/saistibu-parvaldisana/sazinieties-ar-mums/");
		
		try {
			Thread.sleep(5000);
			rejectCookieBtn = driver.findElement(btn_reject_all_cookie);
			if (rejectCookieBtn.isDisplayed() && rejectCookieBtn.isEnabled())
				rejectAllCookies(rejectCookieBtn);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openContactUsForm(){
		if (verifyIfComponentIsReady(driver.findElement(btn_in_shape))) {
			driver.findElement(btn_in_shape).click();			
		}else {
			System.out.println("Element not found");
		}
	}

	public void rejectAllCookies(WebElement webElement){
		webElement.click();
	}

	public boolean verifyIfComponentIsReady(WebElement webElement){
		wait.until(ExpectedConditions.visibilityOf(webElement));
		if(webElement.isDisplayed() && webElement.isEnabled()) {
			return true;
		}
		return false;
	}
}
