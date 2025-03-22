// ShoppingCartPage.java
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

public class ShoppingCartPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.xpath("//input[@value='Search']");
    private By productLink = By.cssSelector("h2[class='product-title'] a");
    private By addToCartButton = By.id("add-to-cart-button-43");
    private By shoppingCartLink = By.xpath("//span[normalize-space()='Shopping cart']");
    private By removeFromCartCheckbox = By.xpath("//input[@name='removefromcart']");
    private By updateCartButton = By.xpath("//input[@name='updatecart']");
    private By emptyCartMessage = By.xpath("//div[@class='order-summary-content']");

    public ShoppingCartPage(WebDriver driver, ExtentTest test) {
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

    public void clickAddToCart() {
        try {
            driver.findElement(addToCartButton).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked add to cart");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click add to cart: " + e.getMessage());
            throw e;
        }
    }

    public void clickShoppingCartLink() {
        try {
            driver.findElement(shoppingCartLink).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked shopping cart link");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click shopping cart link: " + e.getMessage());
            throw e;
        }
    }

    public void clickRemoveFromCartCheckbox() {
        try {
            driver.findElement(removeFromCartCheckbox).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked remove from cart checkbox");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click remove from cart checkbox: " + e.getMessage());
            throw e;
        }
    }

    public void clickUpdateCartButton() {
        try {
            driver.findElement(updateCartButton).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked update cart button");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click update cart button: " + e.getMessage());
            throw e;
        }
    }

    public void verifyEmptyCartMessage(String expectedMessage) {
        try {
            String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage)).getText();
            Assert.assertEquals(actualMessage, expectedMessage, "Empty cart message does not match.");
            Reports.generateReport(driver, test, Status.PASS, "Empty cart message matches: " + expectedMessage);
        } catch (AssertionError e) {
            Reports.generateReport(driver, test, Status.FAIL, "Empty cart message does not match: " + expectedMessage);
            throw e;
        }
    }
}