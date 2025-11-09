package Utlities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

    public static WebDriver driver;
    public static Logger log = Logger.getLogger(base.class);
    public static Properties prop;

    // Constructor to initialize Log4j and load config
    public base() {
        PropertyConfigurator.configure("src/test/resource/log4j.properties");
        log.info("Log4j initialized successfully");
        loadConfig();
    }

    // Load config.properties
    public void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resource/config.properties");
            prop.load(fis);
            log.info("Config file loaded successfully");
        } catch (IOException e) {
            log.error("Failed to load config file", e);
        }
    }

    // Launch Chrome
    public void launch_chrome() {
        log.info("Launching Chrome browser");
        System.setProperty("webdriver.chrome.driver", "chromedriver_v141.exe");
        driver = new ChromeDriver();
        String url = prop.getProperty("url");
        driver.get(url);
       
        driver.manage().window().maximize();
        log.info("Chrome launched ");
    }

    // Launch Edge
    public void launch_edge() {
        log.info("Launching Edge browser");
        System.setProperty("webdriver.edge.driver", "msedgedriver_v141.exe");
        driver = new EdgeDriver();
        String url = prop.getProperty("url");
        driver.get(url);
       
        driver.manage().window().maximize();
        log.info("Edge launched");
    }

    // Close Browser
    public void closeBrowser() {
        driver.quit();
        log.info("Browser closed");
    }

    // JavaScript  
    public void javaScriptClick(WebElement element) {
        log.info("JavaScript Executor started");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        log.info("JavaScript Executor completed");
    }

 // Handle Alert with explicit wait and print text
    public void handleAlertIfPresent() {
        try {
            log.info("Waiting for alert to be present...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            
            String alertText = alert.getText();
            log.info("Alert appeared: " + alertText);
            System.out.println("Alert Text: " + alertText); // print alert text to console

            alert.accept();
            log.info("Alert accepted successfully");
            System.out.println("Alert accepted");
        } catch (Exception e) {
            log.info("No alert appeared or alert handling failed: " + e.getMessage());
        }
    }

    //  Explicit Wait
    public void explicitWait(String xp, String conditionType) {
        log.info("Explicit wait started for XPath: " + xp + " with condition: " + conditionType);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        switch (conditionType.toLowerCase()) {
            case "presence":
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
                break;
            case "visibility":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp)));
                break;
            case "clickable":
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xp)));
                break;
            default:
                log.warn("Invalid condition type provided: " + conditionType);
        }

        log.info("Explicit wait completed for condition: " + conditionType);
    }

    // Fluent Wait
    public void fluentWait(String xp) {
        log.info("Fluent wait started for XPath: " + xp);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xp)));
        element.click();
        log.info("Fluent wait completed and element clicked: " + xp);
    }
}