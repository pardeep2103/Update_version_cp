package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utlities.base;

public class signup_page extends base {
    WebDriver driver;

    public signup_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "signin2")
    WebElement signupLink;

    @FindBy(xpath ="//input[@id='sign-username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='sign-password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signupButton;


    // Actions with waits and logs
    public void clickSignupLink() {
        explicitWait("//a[@id='signin2']", "clickable");
        signupLink.click();
        log.info("Clicked Signup link");
    }

    public void enterUsername(String username) {
        explicitWait("//input[@id='sign-username']", "visibility");
        usernameField.sendKeys(username);
        log.info("Entered signup username: " + username);
    }

    public void enterPassword(String password) {
        explicitWait("//input[@id='sign-password']", "visibility");
        passwordField.sendKeys(password);
        log.info("Entered signup password");
    }

    public void clickSignupButton() {
        fluentWait("//button[text()='Sign up']");
        log.info("Clicked Signup button");
    }
}