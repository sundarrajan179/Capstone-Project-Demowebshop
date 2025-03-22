// UserRegistrationAndLoginPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.Reports;

import java.time.Duration;

public class UserRegistrationAndLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    private By registerLink = By.xpath("//a[normalize-space()='Register']");
    private By genderMaleRadioButton = By.id("gender-male");
    private By firstNameInput = By.id("FirstName");
    private By lastNameInput = By.id("LastName");
    private By emailInput = By.id("Email");
    private By passwordInput = By.id("Password");
    private By confirmPasswordInput = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By logoutLink = By.xpath("//a[normalize-space()='Log out']");
    private By myCoursesLink = By.xpath("//a[normalize-space()='My account']"); // Assuming my account is my course page.

    public UserRegistrationAndLoginPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.test = test;
    }

    public void clickRegisterLink() {
        try{
            driver.findElement(registerLink).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked register link");
        } catch (Exception e){
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click register link: " + e.getMessage());
            throw e;
        }
    }

    public void selectGenderMale() {
        try{
            driver.findElement(genderMaleRadioButton).click();
            Reports.generateReport(driver, test, Status.PASS, "Selected male gender");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to select male gender: " + e.getMessage());
            throw e;
        }

    }

    public void enterFirstName(String firstName) {
        try{
            driver.findElement(firstNameInput).sendKeys(firstName);
            Reports.generateReport(driver, test, Status.PASS, "Entered first name: " + firstName);
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter first name: " + e.getMessage());
            throw e;
        }
    }

    public void enterLastName(String lastName) {
        try{
            driver.findElement(lastNameInput).sendKeys(lastName);
            Reports.generateReport(driver, test, Status.PASS, "Entered last name: " + lastName);
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter last name: " + e.getMessage());
            throw e;
        }
    }

    public void enterEmail(String email) {
        try{
            driver.findElement(emailInput).sendKeys(email);
            Reports.generateReport(driver, test, Status.PASS, "Entered email: " + email);
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter email: " + e.getMessage());
            throw e;
        }
    }

    public void enterPassword(String password) {
        try{
            driver.findElement(passwordInput).sendKeys(password);
            Reports.generateReport(driver, test, Status.PASS, "Entered password");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter password: " + e.getMessage());
            throw e;
        }
    }

    public void enterConfirmPassword(String confirmPassword) {
        try{
            driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
            Reports.generateReport(driver, test, Status.PASS, "Entered confirm password");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter confirm password: " + e.getMessage());
            throw e;
        }
    }

    public void clickRegisterButton() {
        try{
            driver.findElement(registerButton).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked register button");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click register button: " + e.getMessage());
            throw e;
        }
    }

    public void clickLogoutLink() {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked logout link");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click logout link: " + e.getMessage());
            throw e;
        }
    }

    public boolean isMyCoursesPageDisplayed() {
        try{
            return wait.until(ExpectedConditions.visibilityOfElementLocated(myCoursesLink)).isDisplayed();
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "My Courses page not displayed: " + e.getMessage());
            throw e;
        }
    }
}