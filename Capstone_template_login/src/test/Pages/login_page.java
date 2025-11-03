
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

    // Locators
    @FindBy(xpath = "//a[@id='login2']")
    WebElement loginLink;

    @FindBy(xpath = "//input[@id='loginusername']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='loginpassword']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    WebElement loginButton;

    @FindBy(xpath = "//li[@class='nav-item']//a[@id='nameofuser']")
    WebElement displayUsername;

    @FindBy(xpath = "//a[@id='logout2']")
    WebElement logoutbutton;

    // Actions
    public void clickLoginLink() {
    	waitForElement(loginLink);
        loginLink.click();
        waitForElement(usernameField); // Wait for modal to appear
    }

    public void enterUsername(String username) {
    	waitForElement(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
    	waitForElement(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getDisplayedUsername() {
        fluentWait(displayUsername); // Wait until element is displayed
        return displayUsername.getText(); // Should return "Welcome dEEP@2809"
    }

    public void clicklogoutbutton() {
    	waitForElement(logoutbutton);
        logoutbutton.click();
    }
}
