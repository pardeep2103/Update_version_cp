package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utlities.base;

public class cart_page extends base {

    WebDriver driver;

    public cart_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("Cart Page initialized");
        System.out.println("Cart Page initialized");
    }

    // --- Page Elements ---
    @FindBy(xpath = "//*[@id='page-wrapper']/div/div[1]/h2")
    WebElement cartPageHeader;

    @FindBy(xpath = "//*[@id='tbodyid']/tr[1]/td[2]")
    WebElement product1Title;

    @FindBy(xpath = "//*[@id='tbodyid']/tr[1]/td[3]")
    WebElement product1Price;

    @FindBy(xpath = "//*[@id='tbodyid']/tr[2]/td[2]")
    WebElement product2Title;

    @FindBy(xpath = "//*[@id='tbodyid']/tr[2]/td[3]")
    WebElement product2Price;

    @FindBy(xpath = "//*[@id='tbodyid']/tr[3]/td[2]")
    WebElement product3Title;

    @FindBy(xpath = "//*[@id='tbodyid']/tr[3]/td[3]")
    WebElement product3Price;

    @FindBy(xpath = "//*[@id='tbodyid']/tr[3]/td[4]/a")
    WebElement product3DeleteButton;

    @FindBy(xpath = "//*[@id='totalp']")
    WebElement totalPrice;

    @FindBy(xpath = "//*[@id='page-wrapper']/div/div[2]/button")
    WebElement placeOrderButton;

    // --- Actions ---

    // VERIFY CART PAGE LOADED
    public void verifyCartPageLoaded() {
        log.info("Verifying Cart Page loaded");
        System.out.println("Verifying Cart Page loaded");
        explicitWait("//*[@id='page-wrapper']/div/div[1]/h2", "visibility");
        log.info("Cart Page Header: " + cartPageHeader.getText());
        System.out.println("Cart Page Header: " + cartPageHeader.getText());
    }

    // READ PRODUCT 1
    public void readProduct1() {
        log.info("Reading Product 1 details");
        System.out.println("Reading Product 1 details");
        explicitWait("//*[@id='tbodyid']/tr[1]/td[2]", "visibility");
        log.info("Product 1 Title: " + product1Title.getText());
        System.out.println("Product 1 Title: " + product1Title.getText());
        explicitWait("//*[@id='tbodyid']/tr[1]/td[3]", "visibility");
        log.info("Product 1 Price: " + product1Price.getText());
        System.out.println("Product 1 Price: " + product1Price.getText());
    }

    // READ PRODUCT 2
    public void readProduct2() {
        log.info("Reading Product 2 details");
        System.out.println("Reading Product 2 details");
        explicitWait("//*[@id='tbodyid']/tr[2]/td[2]", "visibility");
        log.info("Product 2 Title: " + product2Title.getText());
        System.out.println("Product 2 Title: " + product2Title.getText());
        explicitWait("//*[@id='tbodyid']/tr[2]/td[3]", "visibility");
        log.info("Product 2 Price: " + product2Price.getText());
        System.out.println("Product 2 Price: " + product2Price.getText());
    }

    // READ PRODUCT 3
    public void readProduct3() {
        log.info("Reading Product 3 details");
        System.out.println("Reading Product 3 details");
        explicitWait("//*[@id='tbodyid']/tr[3]/td[2]", "visibility");
        log.info("Product 3 Title: " + product3Title.getText());
        System.out.println("Product 3 Title: " + product3Title.getText());
        explicitWait("//*[@id='tbodyid']/tr[3]/td[3]", "visibility");
        log.info("Product 3 Price: " + product3Price.getText());
        System.out.println("Product 3 Price: " + product3Price.getText());
    }

    // DELETE 3RD PRODUCT
    public void deleteThirdProduct() {
        log.info("Deleting Product 3");
        System.out.println("Deleting Product 3");
        explicitWait("//*[@id='tbodyid']/tr[3]/td[4]/a", "clickable");
        log.info("Product to delete: " + product3Title.getText());
        System.out.println("Product to delete: " + product3Title.getText());
        product3DeleteButton.click();
        handleAlertIfPresent();
        log.info("Product 3 deleted successfully");
        System.out.println("Product 3 deleted successfully");
    }

    // READ UPDATED PRODUCT 3
    public void readProduct3Updated() {
        log.info("Reading updated Product 3 details");
        System.out.println("Reading updated Product 3 details");
        explicitWait("//*[@id='tbodyid']/tr[3]/td[2]", "visibility");
        log.info("Updated Product 3 Title: " + product3Title.getText());
        System.out.println("Updated Product 3 Title: " + product3Title.getText());
        explicitWait("//*[@id='tbodyid']/tr[3]/td[3]", "visibility");
        log.info("Updated Product 3 Price: " + product3Price.getText());
        System.out.println("Updated Product 3 Price: " + product3Price.getText());
    }

    // READ TOTAL PRICE
    public void readTotalPrice() {
        log.info("Reading Total Price");
        System.out.println("Reading Total Price");
        explicitWait("//*[@id='totalp']", "visibility");
        log.info("Total Price: " + totalPrice.getText());
        System.out.println("Total Price: " + totalPrice.getText());
    }

    // CLICK PLACE ORDER
    public void clickPlaceOrder() {
        log.info("Clicking Place Order button");
        System.out.println("Clicking Place Order button");
        explicitWait("//*[@id='page-wrapper']/div/div[2]/button", "clickable");
        placeOrderButton.click();
        log.info("Place Order button clicked");
        System.out.println("Place Order button clicked");
    }
}
