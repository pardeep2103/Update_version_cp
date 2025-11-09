package stepdef;

import Pages.home_page;
import Pages.login_page;
import Pages.product_page;
import Utlities.base;
import io.cucumber.java.en.*;

public class home_steps extends base {

	home_page hp;
	product_page pp;
    login_page lp;

	public home_steps() {
        lp = new login_page(driver);

		hp = new home_page(driver); // initializes home page
		pp = new product_page(driver); // initializes product page
	}

	/*
	 * @When("^the user clicks Phones category$") public void clickPhonesCategory()
	 * { hp = new home_page(driver); hp.clickPhones();
	 * System.out.println("Clicked Phones category"); }
	 */

 	@When("the user clicks first product")
 	public void the_user_clicks_first_product() {
 		hp = new home_page(driver);
 		hp.clickFirstProduct();
 	}
 	@When("the user clicks second product")
 	public void the_user_clicks_second_product() {
 		hp.clickSecondProduct();
 	}
 	@When("the user clicks third product")
 	public void the_user_clicks_third_product() {
 		hp.clickThirdProduct();
 	}
 	@When("the user clicks foruth product")
 	public void the_user_clicks_foruth_product() {
 		hp.clickFourthProduct();
 	}
}
