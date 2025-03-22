// InvalidLoginCredentialsPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.Reports; // Import the Reports utility class

import java.time.Duration;

public class InvalidLoginCredentialsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    private By loginLink = By.xpath("//a[normalize-space()='Log in']");
    private By emailInput = By.id("Email");
    private By passwordInput = By.id("Password");
    private By loginButton = By.xpath("//input[@value='Log in']");
    private By errorMessage = By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]");

    public InvalidLoginCredentialsPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.test = test;
    }

    public void clickLoginLink() {
        try {
            driver.findElement(loginLink).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked on login link");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click on login link: " + e.getMessage());
            throw e;
        }
    }

    public void enterEmail(String email) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
            Reports.generateReport(driver, test, Status.PASS, "Entered email: " + email);
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter email: " + e.getMessage());
            throw e;
        }
    }

    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
            Reports.generateReport(driver, test, Status.PASS, "Entered password");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter password: " + e.getMessage());
            throw e;
        }
    }

    public void clickLoginButton() {
        try {
            driver.findElement(loginButton).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked on login button");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click on login button: " + e.getMessage());
            throw e;
        }
    }

    public void verifyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message not displayed.");
            Reports.generateReport(driver, test, Status.PASS, "Error message displayed");
            Reports.captureScreenshot(driver, "log in failed");
        } catch (AssertionError e) {
            Reports.generateReport(driver, test, Status.FAIL, "Error message not displayed: " + e.getMessage());
            throw e;
        }
    }
}