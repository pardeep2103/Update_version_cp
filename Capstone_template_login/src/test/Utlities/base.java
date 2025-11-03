package Utlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.apache.log4j.Logger;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.function.Function;


public class base {

    public static WebDriver driver;
   public static Logger log = Logger.getLogger(base.class);
   
   //error came because of the import logger import org.apache.log4j.Logger;
// that why not writing the text in the logger file

    // Constructor to initialize Log4j
    public base() {
        PropertyConfigurator.configure("src/test/resource/log4j.properties");
        log.info("Log4j initialized successfully");
    }

    public void launch_chrome() {
        System.setProperty("webdriver.chrome.driver", "chromedriver_v141.exe");
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        log.info("Chrome launched");
    }

    public void launch_edge() {
        System.setProperty("webdriver.edge.driver", "msedgedriver_v141.exe");
        driver = new EdgeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        log.info("Edge launched");
    }

    public void close_browser() {
        driver.quit();
        log.info("Browser closed");
    }

    // Explicit Wait
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Fluent Wait
    // Fluent Wait
    public WebElement fluentWait(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.visibilityOf(element));
        
            }
}
