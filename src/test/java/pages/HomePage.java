// HomePage.java
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.Reports;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    // Locators
    private By categoryLocator = By.xpath("(//div[@class='title'])[1]");
    private By searchBarLocator = By.xpath("//input[@id='small-searchterms']");

    // Constructor
    public HomePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.test = test;
    }

    // Check if a section does NOT exist
    public void checkSectionAbsence(String unexpectedText) {
        String actualText = driver.findElement(categoryLocator).getText();
        System.out.println("Actual Text from XPath: " + actualText);

        try {
            Assert.assertFalse(actualText.contains(unexpectedText),
                    "Page contains unexpected text: " + unexpectedText);
            Reports.generateReport(driver, test, Status.FAIL, "Page does not contain: " + unexpectedText);
        } catch (AssertionError e) {
            Reports.generateReport(driver, test, Status.FAIL, "Page contains unexpected text: " + unexpectedText);
            throw e;
        }
    }

    // Verify Search Bar Visibility
    public void verifySearchBarVisibility() {
        boolean isSearchBarPresent = driver.findElement(searchBarLocator).isDisplayed();
        try {
            Assert.assertTrue(isSearchBarPresent, "Search bar is not displayed on the home page.");
            Reports.generateReport(driver, test, Status.PASS, "Search bar is displayed");
        } catch (AssertionError e) {
            Reports.generateReport(driver, test, Status.FAIL, "Search bar is not displayed");
            throw e;
        }
    }
}