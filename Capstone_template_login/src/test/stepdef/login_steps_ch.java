package stepdef;

import Pages.home_page;
import Pages.login_page;
import Pages.product_page;
import Utlities.base;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class login_steps_ch extends base {
    login_page lp;
    home_page hp;
	product_page pp;

	
    @Given("the user opens the {string} browser")
    public void openBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            launch_chrome();
        } else if (browser.equalsIgnoreCase("edge")) {
            launch_edge();
        } else {
            throw new IllegalArgumentException("No Browser: " + browser);
        }
        log.info("Browser launched: " + browser);
    }

    @Given("the user is on the Login page")
    public void openLoginPage() {
        lp = new login_page(driver);
        lp.clickLoginLink();
        log.info("Opened Login modal");
    }

    @And("the user enters a login username {string}")
    public void enterUsername(String username) {
        lp.enterUsername(username);
        log.info("Entered username: " + username);
    }

    @And("the user enters a login password {string}")
    public void enterPassword(String password) {
        lp.enterPassword(password);
        log.info("Entered password");
    }

    @And("the user clicks the Login button")
    public void clickLoginButton() {
        lp.clickLoginButton();
        log.info("Clicked Login button");
    }

    @Then("the user should see the welcome message {string}")
    public void verifyValidLogin(String expectedMessage) {
        hp = new home_page(driver);
        String actualMessage = hp.getDisplayedUsername();
        Assert.assertEquals(actualMessage, expectedMessage, "Login success message mismatch.");
        log.info("Valid login verified: " + actualMessage);
    }

    @Then("the user should see alert message {string}")
    public void verifyInvalidLogin(String expectedAlert) {
        handleAlertIfPresent();
        log.info("Invalid login verified: " + expectedAlert);
        driver.quit();
    }
}