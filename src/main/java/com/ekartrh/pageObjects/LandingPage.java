package com.ekartrh.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ekartrh.common.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(id = "userEmail")
	WebElement email;
	
	@FindBy(id = "userPassword")
	WebElement password;
	
	@FindBy(id = "login")
	WebElement loginBtn;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement LoginerrorMessage;
	
	
	By invalidLoginerrorMessage = By.cssSelector("[class*='flyInOut']");
	
	public ProductsPage loginApplication(String mailId, String pwd) {
		email.sendKeys(mailId);
		password.sendKeys(pwd);
		loginBtn.click();
		ProductsPage productsPage = new ProductsPage(driver);
		return productsPage;
	}
	
	public String getErrorMessage() {
		
		waitForElementToBeVisible(invalidLoginerrorMessage);
		return LoginerrorMessage.getText();

	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}

}
