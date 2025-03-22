// SearchPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.Reports;

import java.time.Duration;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.xpath("(//input[@value='Search'])[1]");
    private By advancedSearchCheckbox = By.id("As");
    private By categoryDropdown = By.id("Cid");
    private By priceFrom = By.id("Pf");
    private By priceTo = By.id("Pt");
    private By searchResultButton = By.xpath("(//input[@class='button-1 search-button'])[1]");

    public SearchPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.test = test;
    }

    public void enterSearchTerm(String searchTerm) {
        try {
            driver.findElement(searchBox).sendKeys(searchTerm);
            Reports.generateReport(driver, test, Status.PASS, "Entered search term: " + searchTerm);
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter search term: " + e.getMessage());
            throw e;
        }
    }

    public void clickSearchButton() {
        try {
            driver.findElement(searchButton).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked search button");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click search button: " + e.getMessage());
            throw e;
        }
    }

    public void clickAdvancedSearchCheckbox() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(advancedSearchCheckbox));
            driver.findElement(advancedSearchCheckbox).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked advanced search checkbox");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click advanced search checkbox: " + e.getMessage());
            throw e;
        }
    }

    public void selectCategory(String category) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(categoryDropdown));
            Select dropdown = new Select(driver.findElement(categoryDropdown));
            dropdown.selectByVisibleText(category);
            Reports.generateReport(driver, test, Status.PASS, "Selected category: " + category);
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to select category: " + e.getMessage());
            throw e;
        }
    }

    public void enterPriceRange(String from, String to) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(priceFrom));
            driver.findElement(priceFrom).sendKeys(from);
            driver.findElement(priceTo).sendKeys(to);
            Reports.generateReport(driver, test, Status.PASS, "Entered price range: " + from + " to " + to);
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter price range: " + e.getMessage());
            throw e;
        }
    }

    public void clickSearchResultButton() {
        try {
            driver.findElement(searchResultButton).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked search result button");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click search result button: " + e.getMessage());
            throw e;
        }
    }

    public boolean isSearchResultDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-title']"))).isDisplayed();
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Search results not displayed: " + e.getMessage());
            throw e;
        }
    }
}
