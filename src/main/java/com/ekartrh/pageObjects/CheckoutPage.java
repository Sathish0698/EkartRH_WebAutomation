package com.ekartrh.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ekartrh.common.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement dropdown;

	@FindBy(css = ".ta-results button:last-of-type")
	WebElement dropdownValuel;
	
	@FindBy(css = ".action__submit")
	WebElement placeOrderBtn;

	By results = By.cssSelector(".ta-results");

	public void selectvalueInDropDown(String dropdownValue) {

		Actions as = new Actions(driver);
		as.sendKeys(dropdown, dropdownValue).build().perform();
		waitForVisibilityOfAllElementlocated(results);
		dropdownValuel.click();

	}
	
	public ConfirmationPage placeOrder() {
		
		placeOrderBtn.click();
		ConfirmationPage confpage = new ConfirmationPage(driver);
		return confpage;

	}

}
