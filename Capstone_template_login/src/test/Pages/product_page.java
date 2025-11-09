package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utlities.base;

public class product_page extends base {

    WebDriver driver;

    public product_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Product Title
    @FindBy(xpath = "//div[@id='tbodyid']//h2")
    WebElement productTitle;

    // Product Price
    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement productPrice;

    // Add to Cart button
    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    WebElement addToCartButton;

    // Home button
    @FindBy(xpath = "//*[@id='navbarExample']/ul/li[1]/a")
    WebElement homeButton;

    // Cart button
    @FindBy(xpath = "//a[@id='cartur']")
    WebElement cartButton;


    // READ PRODUCT TITLE
    public String getProductTitle() {
        explicitWait("//div[@id='tbodyid']//h2", "visible");
        return productTitle.getText();
    }

    // READ PRODUCT PRICE
    public String getProductPrice() {
        explicitWait("//h3[@class='price-container']", "visible");
        return productPrice.getText();
    }

    // CLICK ADD TO CART
    public void clickAddToCart() {
        explicitWait("//a[@class='btn btn-success btn-lg']", "clickable");
        addToCartButton.click();
        System.out.println("Clicked Add to Cart button");
    }

    // CLICK HOME BUTTON
    public void clickHomeButton() {
        explicitWait("//*[@id='navbarExample']/ul/li[1]/a", "clickable");
        homeButton.click();
        System.out.println("Clicked Home button");
    }

    // CLICK CART BUTTON
    public void clickCartButton() {
        explicitWait("//a[@id='cartur']", "clickable");
        cartButton.click();
        System.out.println("Clicked Cart button");
    }
}
