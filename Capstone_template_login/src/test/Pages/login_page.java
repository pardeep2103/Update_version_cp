package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utlities.base;

public class login_page extends base {
    WebDriver driver;

    public login_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='login2']")
    WebElement loginLink;

    @FindBy(xpath = "//input[@id='loginusername']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='loginpassword']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    WebElement loginButton;

    public void clickLoginLink() {
        loginLink.click();
    }

    public void enterUsername(String username) {
        explicitWait("//input[@id='loginusername']", "visibility");

        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        explicitWait("//input[@id='loginpassword']", "visibility");

        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}