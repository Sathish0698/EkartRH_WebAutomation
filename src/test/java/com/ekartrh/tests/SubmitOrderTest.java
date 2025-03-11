package com.ekartrh.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ekartrh.pageObjects.CartPage;
import com.ekartrh.pageObjects.CheckoutPage;
import com.ekartrh.pageObjects.ConfirmationPage;
import com.ekartrh.pageObjects.OrdersPage;
import com.ekartrh.pageObjects.ProductsPage;
import com.ekartrh.testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	public ProductsPage productsPage;
	public CartPage cp;
	public CheckoutPage checkoutpage;
	public ConfirmationPage confpage;

	String ProductName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = "Purchase")
	public void submitOrder(HashMap<String, String> input) throws Exception {

		productsPage = lp.loginApplication(input.get("email"), input.get("pwd"));

		productsPage.addproductToCart(input.get("productName"));
		cp = productsPage.goToCartPage();

		boolean anyMatch = cp.getProdsInCartPage(input.get("productName"));
		assertTrue(anyMatch);
		checkoutpage = cp.clickCheckoutButton();

		checkoutpage.selectvalueInDropDown("india");
		confpage = checkoutpage.placeOrder();

		boolean finalSuccessTextvalidation = confpage.finalSuccessTextvalidation();
		assertTrue(finalSuccessTextvalidation);

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrdersHistoryTest() {

		productsPage = lp.loginApplication("manju123@gmail.com", "Manju@123");
		OrdersPage goToOrdersPage = productsPage.goToOrdersPage();
		boolean prodsInOrdersPage = goToOrdersPage.getProdsInOrdersPage(ProductName);
		Assert.assertTrue(prodsInOrdersPage);

	}

	@DataProvider
	public Object[][] getData() throws IOException {
	
		List<HashMap<String, String>> jsonDataToMap = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\com\\ekartrh\\data\\purchaseOrder.json");
		
		return new Object[][] { {jsonDataToMap.get(0)}, {jsonDataToMap.get(1)} };

	}
}
