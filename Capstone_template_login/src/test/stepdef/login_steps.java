package stepdef;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pages.login_page;
import Utlities.base;

import io.cucumber.java.en.*;

public class login_steps extends base {
    login_page lp;
    WebDriverWait wait;

    @Given("the user is on the Login page")
    public void openLoginPage() {
        launch_chrome(); // Using base class method
        lp = new login_page(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        lp.clickLoginLink();

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
        // Wait for welcome message to appear
        String actualMessage = lp.getDisplayedUsername();
        System.out.println("Actual message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Login success message mismatch.");
        log.info("Valid login verified: " + actualMessage);
        lp.clicklogoutbutton();
        driver.quit();
    }

    @Then("the user should see alert message {string}")
    public void verifyInvalidLogin(String expectedAlert) {
        wait.until(ExpectedConditions.alertIsPresent());
        String actualAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert, expectedAlert, "Alert message mismatch.");
        driver.switchTo().alert().accept(); // Click OK on popup
        log.info("Invalid login verified: " + actualAlert);
        driver.quit();
    }
}
