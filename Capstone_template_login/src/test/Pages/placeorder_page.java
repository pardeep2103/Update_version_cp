package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utlities.base;

public class placeorder_page extends base {

    WebDriver driver;

    public placeorder_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("PlaceOrder Page ");
    }

    @FindBy(xpath = "//*[@id='orderModalLabel']")
    WebElement placeOrderPopupLabel;


    @FindBy(xpath = "//*[@id='name']")
    WebElement nameField;

    @FindBy(xpath = "//*[@id='country']")
    WebElement countryField;

    @FindBy(xpath = "//*[@id='city']")
    WebElement cityField;

    @FindBy(xpath = "//*[@id='card']")
    WebElement creditCardField;

    @FindBy(xpath = "//*[@id='month']")
    WebElement monthField;

    @FindBy(xpath = "//*[@id='year']")
    WebElement yearField;

    @FindBy(xpath = "//*[@id='orderModal']/div/div/div[3]/button[2]")
    WebElement purchaseButton;

    @FindBy(xpath = "/html/body/div[10]/h2")
    WebElement confirmationTitle;

    @FindBy(xpath = "/html/body/div[10]/p")
    WebElement confirmationDetails;

    @FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
    WebElement confirmationOkButton;

    // VERIFY PLACE ORDER POPUP
    public void verifyPlaceOrderPopup() {
        log.info("Verifying Place Order popup");
        explicitWait("//*[@id='orderModalLabel']", "visibility");
        log.info("Place Order popup label: " + placeOrderPopupLabel.getText());
    }
    // ENTER USER DETAILS
    public void enterName(String name) {
        log.info("Entering Name: " + name);
        explicitWait("//*[@id='name']", "visible");
        nameField.sendKeys(name);
        log.info("Name entered successfully");
    }

    public void enterCountry(String country) {
        log.info("Entering Country: " + country);
        countryField.sendKeys(country);
        log.info("Country entered successfully");
    }

    public void enterCity(String city) {
        log.info("Entering City: " + city);
        cityField.sendKeys(city);
        log.info("City entered successfully");
    }

    public void enterCreditCard(String card) {
        log.info("Entering Credit Card: " + card);
        creditCardField.sendKeys(card);
        log.info("Credit Card entered successfully");
    }

    public void enterMonth(String month) {
        log.info("Entering Month: " + month);
        monthField.sendKeys(month);
        log.info("Month entered successfully");
    }

    public void enterYear(String year) {
        log.info("Entering Year: " + year);
        yearField.sendKeys(year);
        log.info("Year entered successfully");
    }

    // CLICK PURCHASE
    public void clickPurchase() {
        log.info("Clicking Purchase button");
        explicitWait("//*[@id='orderModal']/div/div/div[3]/button[2]", "clickable");
        purchaseButton.click();
        log.info("Purchase button clicked");
    }

 // HANDLE CONFIRMATION POPUP
    public void readConfirmationDetails() {
        log.info("Reading confirmation popup details");
        explicitWait("/html/body/div[10]/h2", "visible");
        
        String title = confirmationTitle.getText();
        String details = confirmationDetails.getText();

        // Log in log4j
        log.info("Confirmation Title: " + title);
        log.info("Confirmation Details: " + details);

        // Print to console
        System.out.println("Confirmation Title: " + title);
        System.out.println("Confirmation Details: " + details);
    }

    public void clickConfirmationOk() {
        log.info("Clicking OK button on confirmation popup");
        explicitWait("/html/body/div[10]/div[7]/div/button", "clickable");
        confirmationOkButton.click();
        log.info("Clicked OK on Confirmation popup, returned to Home Page");
    }
}
