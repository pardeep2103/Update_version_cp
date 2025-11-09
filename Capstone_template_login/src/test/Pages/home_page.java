package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utlities.base;

public class home_page extends base {

    WebDriver driver;

    public home_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("Home Page initialized");
    }

    // --- Page Elements ---
    @FindBy(xpath = "//a[@id='nameofuser']")
    WebElement displayUsername;

    @FindBy(xpath = "//a[@id='logout2']")
    WebElement logoutButton;

    @FindBy(xpath = "//div[@class='list-group']//a[2]")
    WebElement phonesLink;

    @FindBy(xpath = "//div[@id='tbodyid']/div[1]/div/div/h4/a")
    WebElement firstProduct;

    @FindBy(xpath = "//div[@id='tbodyid']/div[2]/div/div/h4/a")
    WebElement secondProduct;

    @FindBy(xpath = "//div[@id='tbodyid']/div[3]/div/div/h4/a")
    WebElement thirdProduct;

    @FindBy(xpath = "//div[@id='tbodyid']/div[4]/div/div/h4/a")
    WebElement fourthProduct;

    // --- Actions ---

    public String getDisplayedUsername() {
        log.info("Getting displayed username");
        explicitWait("//a[@id='nameofuser']", "visibility");
        String username = displayUsername.getText();
        log.info("Username displayed: " + username);
        return username;
    }

    public void clickLogoutButton() {
        log.info("Clicking Logout button");
        explicitWait("//a[@id='logout2']", "clickable");
        logoutButton.click();
        log.info("Clicked Logout button");
    }

    public void clickPhones() {
        log.info("Clicking Phones category");
        explicitWait("//div[@class='list-group']//a[2]", "visibility");
        phonesLink.click();
        log.info("Clicked Phones category");
    }

    public void clickFirstProduct() {
        log.info("Clicking FIRST product");
        explicitWait("//div[@id='tbodyid']/div[1]/div/div/h4/a", "visibility");
        firstProduct.click();
        log.info("Clicked FIRST product");
    }

    public void clickSecondProduct() {
        log.info("Clicking SECOND product");
        explicitWait("//div[@id='tbodyid']/div[2]/div/div/h4/a", "visibility");
        secondProduct.click();
        log.info("Clicked SECOND product");
    }

    public void clickThirdProduct() {
        log.info("Clicking THIRD product");
        explicitWait("//div[@id='tbodyid']/div[3]/div/div/h4/a", "visibility");
        thirdProduct.click();
        log.info("Clicked THIRD product");
    }

    public void clickFourthProduct() {
        log.info("Clicking FOURTH product");
        explicitWait("//div[@id='tbodyid']/div[4]/div/div/h4/a", "visibility");
        fourthProduct.click();
        log.info("Clicked FOURTH product");
    }
}
