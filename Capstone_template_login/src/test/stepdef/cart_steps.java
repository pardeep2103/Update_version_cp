package stepdef;

import io.cucumber.java.en.Then;
import Pages.cart_page;
import Pages.home_page;
import Pages.login_page;
import Pages.placeorder_page;
import Pages.product_page;
import Utlities.base;

public class cart_steps extends base {

    cart_page cp;
    home_page hp;
    product_page pp;
    login_page lp;
    placeorder_page pop;


    public cart_steps() {

        // Initialize all page objects with same driver
        lp = new login_page(driver);
        hp = new home_page(driver);
        pp = new product_page(driver);
        cp = new cart_page(driver);
        pop = new placeorder_page(driver);

    }

    // STEP 1: OPEN CART PAGE
    @Then("user is on Cart page")
    public void user_is_on_cart_page() {
        explicitWait("//a[@id='cartur']", "clickable");
        driver.findElement(org.openqa.selenium.By.xpath("//a[@id='cartur']")).click();
        handleAlertIfPresent();  // In case an alert appears while navigating
    }

    // STEP 2: VERIFY CART PAGE LOADED
    @Then("user verifies the cart page is loaded")
    public void user_verifies_the_cart_page_is_loaded() {
        cp.verifyCartPageLoaded();
    }

    // STEP 3: READ PRODUCT 1
    @Then("user reads product 1 details")
    public void user_reads_product_1_details() {
        cp.readProduct1();
    }

    // STEP 4: READ PRODUCT 2
    @Then("user reads product 2 details")
    public void user_reads_product_2_details() {
        cp.readProduct2();
    }

    // STEP 5: READ PRODUCT 3 BEFORE DELETE
    @Then("user reads product 3 details")
    public void user_reads_product_3_details() {
        cp.readProduct3();
    }

    // STEP 6: DELETE THIRD PRODUCT
    @Then("user deletes the 3rd product")
    public void user_deletes_the_3rd_product() {
        cp.deleteThirdProduct();
    }

    // STEP 7: READ UPDATED PRODUCT 3 (now new product moved to position 3)
    @Then("user reads updated product 3 details")
    public void user_reads_updated_product_3_details() {
        cp.readProduct3Updated();
    }

    // STEP 8: READ TOTAL PRICE
    @Then("user reads total price")
    public void user_reads_total_price() {
        cp.readTotalPrice();
    }

    // STEP 9: CLICK PLACE ORDER
    @Then("user clicks place order")
    public void user_clicks_place_order() {
        cp.clickPlaceOrder();
    }

    // STEP 10: VERIFY POPUP
    @Then("user verifies place order popup is displayed")
    public void user_verifies_place_order_popup_is_displayed() {
        pop.verifyPlaceOrderPopup();
    }

}
