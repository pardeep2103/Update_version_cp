package stepdef;

import Pages.signup_page;
import Utlities.base;
import io.cucumber.java.en.*;

public class signup_steps extends base {

    signup_page signup;

    @When("^the user is on the homepage$")
    public void the_user_is_on_the_homepage() {
        signup = new signup_page(driver);
    }

    @And("the user clicks on the signup link")
    public void the_user_clicks_on_the_signup_link() {
        signup.clickSignupLink();
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        signup.enterUsername(username);
        signup.enterPassword(password);
    }

    @When("the user clicks on the signup button")
    public void the_user_clicks_on_the_signup_button() {
        signup.clickSignupButton();
    }

    @Then("a signup confirmation alert should appear")
    public void a_signup_confirmation_alert_should_appear() {
        handleAlertIfPresent(); // Accepts alert if present
    }
}