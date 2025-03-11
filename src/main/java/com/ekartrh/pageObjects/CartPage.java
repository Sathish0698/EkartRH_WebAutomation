package com.ekartrh.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ekartrh.common.AbstractComponents;

public class CartPage extends AbstractComponents {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProds;

	@FindBy(css = ".totalRow button")
	WebElement checkoutBtn;

	public boolean getProdsInCartPage(String ProductName) {

		boolean anyMatch = cartProds.stream().anyMatch(cp -> cp.getText().equalsIgnoreCase(ProductName));
		return anyMatch;

	}

	public CheckoutPage clickCheckoutButton() {

		checkoutBtn.click();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		return checkoutpage;

	}

}