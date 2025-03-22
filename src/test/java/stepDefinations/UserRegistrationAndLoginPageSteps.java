// UserRegistrationAndLoginPageSteps.java
package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import Hooks.Hooks;

import pages.UserRegistrationAndLoginPage;
import utils.Base;

public class UserRegistrationAndLoginPageSteps {

    private WebDriver driver = Base.driver;
    private UserRegistrationAndLoginPage userPage;
    ExtentTest test = Hooks.test;

    @Given("I am on the home page for user registration and login testing")
    public void iAmOnTheHomePageForUserRegistrationAndLoginTesting() {
        userPage = new UserRegistrationAndLoginPage(driver, test);
    }

    @Then("the user clicks on the register link")
    public void theUserClicksOnTheRegisterLink() {
        userPage.clickRegisterLink();
    }

    @Then("the registration page is displayed on the screen")
    public void theRegistrationPageIsDisplayedOnTheScreen() {
        // You would normally add an assertion here to verify the correct page is displayed.
    }

    @When("the user enters {string} and {string} and {string} and {string} and {string}")
    public void theUserEntersAndAndAndAnd(String firstName, String lastName, String email, String password, String confirmPassword) {
        userPage.selectGenderMale();
        userPage.enterFirstName(firstName);
        userPage.enterLastName(lastName);
        userPage.enterEmail(email);
        userPage.enterPassword(password);
        userPage.enterConfirmPassword(confirmPassword);
    }

    @When("the user clicks the signup button")
    public void theUserClicksTheSignupButton() {
        userPage.clickRegisterButton();
    }

    @Then("the user sees the My Courses page")
    public void theUserSeesTheMyCoursesPage() {
        Assert.assertTrue(userPage.isMyCoursesPageDisplayed(), "My Courses page is not displayed.");
    }

    @When("the user clicks the Logout")
    public void theUserClicksTheLogout() {
        userPage.clickLogoutLink();
    }
}