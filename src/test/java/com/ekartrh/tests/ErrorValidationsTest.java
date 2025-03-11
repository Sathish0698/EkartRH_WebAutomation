package com.ekartrh.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ekartrh.pageObjects.CartPage;
import com.ekartrh.pageObjects.ProductsPage;
import com.ekartrh.testComponents.BaseTest;
import com.ekartrh.testComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	String ProductName = "ZARA COAT 3";

	@Test(groups = "ErrorHandling", retryAnalyzer = Retry.class)
	public void loginValidation() throws Exception {

		lp.loginApplication("maerereu123@gmail.com", "Mansdfsdju@123");
		String errorMessage = lp.getErrorMessage();
		assertEquals("Incorrect email or password.", errorMessage);
		System.out.println(errorMessage);

	}
	
	@Test
	public void producNametValidation() throws Exception {

		ProductsPage productsPage = lp.loginApplication("techiesathish@gmail.com", "Sathish@123");

		productsPage.addproductToCart(ProductName);
		CartPage cp = productsPage.goToCartPage();

		boolean anyMatch = cp.getProdsInCartPage("Zara oeuh 87");
		Assert.assertFalse(anyMatch);

	}
	
	

}
