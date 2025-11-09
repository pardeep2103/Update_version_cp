package stepdef;

import Pages.home_page;
import Pages.login_page;
import Pages.product_page;
import Utlities.base;
import io.cucumber.java.en.*;

public class product_steps extends base {

	home_page hp;
	product_page pp;
    login_page lp;


	public product_steps() {
        lp = new login_page(driver);

		hp = new home_page(driver); 
		pp = new product_page(driver); 
	}

	/*
	 * // USER CLICKS FIRST PRODUCT
	 * 
	 * @When("the user clicks first product") public void
	 * the_user_clicks_first_product() { hp = new home_page(driver);
	 * hp.clickFirstProduct(); }
	 * 
	 * @When("the user clicks first product") public void
	 * the_user_clicks_second_product() { hp.clickSecondProduct(); }
	 * 
	 * @When("the user clicks first product") public void
	 * the_user_clicks_third_product() { hp.clickThirdProduct(); }
	 */

	/*
	 * // READ PRODUCT DETAILS
	 * 
	 * @Then("^the user reads product details$") public void
	 * the_user_reads_product_details() { pp.getProductTitle();
	 * pp.getProductPrice();
	 * 
	 * 
	 * System.out.println("PRODUCT DETAILS:"); System.out.println("Title: " +
	 * title); System.out.println("Price: " + price);
	 * 
	 * }
	 */
	// ADD TO CART
	@And("the user adds product to cart")
	public void the_user_adds_product_to_cart() {
		pp.clickAddToCart();
		System.out.println("Clicked Add to Cart");
	}

	// ACCEPT ALERT
	@And("the user accepts the alert")
	public void the_user_accepts_the_alert() {
		handleAlertIfPresent();
		
	}

	// CLICK HOME BUTTON
	@And("the user clicks Home button")
	public void the_user_clicks_home_button() {
		pp.clickHomeButton();
		System.out.println("Returned to Home Page");
	}
	@And("the user clicks cart button")
	public void the_user_click_cart_button() {
		pp.clickCartButton();
		System.out.println("Cart Page");
	}
}
