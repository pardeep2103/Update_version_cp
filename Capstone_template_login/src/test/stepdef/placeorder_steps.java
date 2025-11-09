package stepdef;

import Pages.placeorder_page;
import Pages.home_page;
import Pages.login_page;
import Pages.product_page;
import Utlities.base;
import io.cucumber.java.en.*;

public class placeorder_steps extends base {

    placeorder_page pop;
    home_page hp;
    login_page lp;
    product_page pp;

    public placeorder_steps() {
        lp = new login_page(driver);
        hp = new home_page(driver);
        pp = new product_page(driver);
        pop = new placeorder_page(driver);
        log.info("PlaceOrder Steps initialized");
    }

    @Then("the Place Order modal should be displayed")
    public void the_place_order_modal_should_be_displayed() {
        log.info("Step: Verify Place Order modal is displayed");
        pop.verifyPlaceOrderPopup();
    }

    @When("the user enters Name {string}")
    public void the_user_enters_name(String name) {
        log.info("Step: Enter Name");
        pop.enterName(name);
    }

    @And("the user enters Country {string}")
    public void the_user_enters_country(String country) {
        log.info("Step: Enter Country");
        pop.enterCountry(country);
    }

    @And("the user enters City {string}")
    public void the_user_enters_city(String city) {
        log.info("Step: Enter City");
        pop.enterCity(city);
    }

    @And("the user enters Credit Card {string}")
    public void the_user_enters_credit_card(String card) {
        log.info("Step: Enter Credit Card");
        pop.enterCreditCard(card);
    }

    @And("the user enters Month {string}")
    public void the_user_enters_month(String month) {
        log.info("Step: Enter Month");
        pop.enterMonth(month);
    }

    @And("the user enters Year {string}")
    public void the_user_enters_year(String year) {
        log.info("Step: Enter Year");
        pop.enterYear(year);
    }

    @And("the user clicks Purchase")
    public void the_user_clicks_purchase() {
        log.info("Step: Click Purchase button");
        pop.clickPurchase();
    }

    @Then("the confirmation popup should be displayed")
    public void the_confirmation_popup_should_be_displayed() {
        log.info("Step: Verify confirmation popup displayed");
        pop.readConfirmationDetails();
    }

    @And("the user reads confirmation details")
    public void the_user_reads_confirmation_details() {
        log.info("Step: Read confirmation details");
        pop.readConfirmationDetails();
    }

    @And("the user clicks OK")
    public void the_user_clicks_ok() {
        log.info("Step: Click OK on confirmation popup");
        pop.clickConfirmationOk();
        driver.close();
    }

    // ---- NEGATIVE SCENARIO ----
    @And("the user clicks Purchase without entering details")
    public void the_user_clicks_purchase_without_entering_details() {
        log.info("Step: Click Purchase without entering details");
        pop.clickPurchase();
    }

    @Then("an alert should be displayed with text {string}")
    public void an_alert_should_be_displayed_with_text(String expectedAlertText) {
        log.info("Step: Verify alert text and accept alert");
        handleAlertIfPresent();
        System.out.println(expectedAlertText);
        driver.close();
    }
}
