package com.ekartrh.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ekartrh.common.AbstractComponents;

public class OrdersPage extends AbstractComponents {

	public WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> orderPageProds;

	public boolean getProdsInOrdersPage(String ProductName) {

		boolean anyMatch = orderPageProds.stream().anyMatch(op -> op.getText().equalsIgnoreCase(ProductName));
		return anyMatch;

	}

}