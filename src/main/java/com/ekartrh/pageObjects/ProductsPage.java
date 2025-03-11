package com.ekartrh.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ekartrh.common.AbstractComponents;

public class ProductsPage extends AbstractComponents {

	public WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> productsInHomePage;

	@FindBy(css = ".w-10")
	WebElement addToCartBtn;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement CartBtn;

	By addtocartbutton = By.cssSelector(".w-10");
	By productsBy = By.cssSelector(".mb-3");
	By toastContainer = By.cssSelector("#toast-container");
	By animating = By.cssSelector(".ng-animating");

	public List<WebElement> getProductlist() {

		waitForElementToBeVisible(productsBy);
		return productsInHomePage;

	}

	public WebElement getProductsByName(String productName) {
		
		WebElement FinalProd = getProductlist().stream().filter(
				prods -> prods.findElement(By.cssSelector(".card-body b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return FinalProd;

	}
	
	public void addproductToCart(String productName) throws InterruptedException {
	
		WebElement productsByName = getProductsByName(productName);
		productsByName.findElement(addtocartbutton).click();
		waitForElementToBePresent(toastContainer);
		waitForInvisibilityOfElementt(animating);
	}

}
