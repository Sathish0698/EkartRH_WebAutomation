package com.ekartrh.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	

	public WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement textshowninFinalpage;
	
	public boolean finalSuccessTextvalidation() {
		
		String actualtext = textshowninFinalpage.getText().trim();
		return actualtext.equalsIgnoreCase("Thankyou for the order.");

	}


}
