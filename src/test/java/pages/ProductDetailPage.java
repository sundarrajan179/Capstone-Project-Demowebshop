// ProductDetailPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.Reports;

import java.time.Duration;

public class ProductDetailPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.xpath("//input[@value='Search']");
    private By productLink = By.cssSelector("h2[class='product-title'] a");
    private By productName = By.cssSelector("h1[itemprop='name']");
    private By productDescription = By.xpath("//div[@class='short-description']");
    private By productPrice = By.xpath("(//span[@class='price-value-43'])[1]");
    private By addToWishlistButton = By.id("add-to-wishlist-button-43");
    private By addToCartButton = By.id("add-to-cart-button-43");

    public ProductDetailPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.test = test;
    }

    public void searchProduct(String searchTerm) {
        try {
            driver.findElement(searchBox).sendKeys(searchTerm);
            driver.findElement(searchButton).click();
            Reports.generateReport(driver, test, Status.PASS, "Searched for: " + searchTerm);
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Search failed: " + e.getMessage());
            throw e;
        }
    }

    public void clickProductLink() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked product link");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click product link: " + e.getMessage());
            throw e;
        }
    }

    public void verifyProductNameContains(String expectedText) {
        try {
            String actualName = wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
            Assert.assertTrue(actualName.contains(expectedText), "Product name does not contain: " + expectedText);
            Reports.generateReport(driver, test, Status.PASS, "Product name contains: " + expectedText);
        } catch (AssertionError e) {
            Reports.generateReport(driver, test, Status.FAIL, "Product name does not contain: " + expectedText);
            throw e;
        }
    }

    public void verifyProductDescription(String expectedDescription) {
        try {
            String actualDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(productDescription)).getText();
            Assert.assertEquals(actualDescription, expectedDescription, "Product description does not match.");
            Reports.generateReport(driver, test, Status.PASS, "Product description matches: " + expectedDescription);
        } catch (AssertionError e) {
            Reports.generateReport(driver, test, Status.FAIL, "Product description does not match: " + expectedDescription);
            throw e;
        }
    }

    public void verifyProductPrice(String expectedPrice) {
        try {
            String actualPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();
            Assert.assertEquals(actualPrice, expectedPrice, "Product price does not match.");
            Reports.generateReport(driver, test, Status.PASS, "Product price matches: " + expectedPrice);
        } catch (AssertionError e) {
            Reports.generateReport(driver, test, Status.FAIL, "Product price does not match: " + expectedPrice);
            throw e;
        }
    }

    public void clickAddToWishlist() {
        try {
            driver.findElement(addToWishlistButton).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked add to wishlist");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click add to wishlist: " + e.getMessage());
            throw e;
        }
    }

    public void clickAddToCart() {
        try {
            driver.findElement(addToCartButton).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked add to cart");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click add to cart: " + e.getMessage());
            throw e;
        }
    }
}