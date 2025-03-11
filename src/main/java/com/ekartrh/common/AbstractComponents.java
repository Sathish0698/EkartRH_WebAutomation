package com.ekartrh.common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ekartrh.pageObjects.CartPage;
import com.ekartrh.pageObjects.OrdersPage;

public class AbstractComponents {

	WebDriver driver;
	
	By clickCartBtn = By.xpath("//button[@routerlink='/dashboard/cart']");
	By clickOrdersBtn = By.xpath("//button[@routerlink='/dashboard/myorders']");


	public AbstractComponents(WebDriver driver2) {
		this.driver = driver2;
	}
	
	public CartPage goToCartPage() {
		
		WebElement CartBtn = driver.findElement(clickCartBtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", CartBtn);
		CartPage cp = new CartPage(driver);
		return cp;

	}
	
	public OrdersPage goToOrdersPage() {
		
		WebElement ordersBtn = driver.findElement(clickOrdersBtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ordersBtn);
		OrdersPage orders = new OrdersPage(driver);
		return orders;

	}

	public void waitForElementToBeVisible(By locater) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(""))));

	}

	public void waitForElementToBePresent(By locater1) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locater1));

	}
	
	public void waitForInvisibilityOfElementt(By locater2) throws InterruptedException {

		Thread.sleep(2000L);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locater2)));

	}
	
	public void waitForVisibilityOfAllElementlocated(By locater3) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locater3));

	}

}
