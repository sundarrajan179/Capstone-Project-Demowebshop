// InvalidLoginCredentialsPageSteps.java
package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import Hooks.Hooks;

import pages.InvalidLoginCredentialsPage;
import utils.Base;

public class InvalidLoginCredentialsPageSteps {

    private WebDriver driver = Base.driver;
    private InvalidLoginCredentialsPage invalidLoginPage;
    ExtentTest test = Hooks.test;

    @Given("I am on the home page for invalid login testing")
    public void iAmOnTheHomePageForInvalidLoginTesting() {
        invalidLoginPage = new InvalidLoginCredentialsPage(driver,test);
        // Assuming your setup already navigates to the home page
    }

    @When("I navigate to the login page and enter invalid credentials")
    public void iNavigateToTheLoginPageAndEnterInvalidCredentials() {
        invalidLoginPage.clickLoginLink();
        invalidLoginPage.enterEmail("hshewhqh2h1h3h@gmail.com");
        invalidLoginPage.enterPassword("1234");
        invalidLoginPage.clickLoginButton();
    }

    @Then("I should see an error message for invalid login")
    public void iShouldSeeAnErrorMessageForInvalidLogin() {
        invalidLoginPage.verifyErrorMessage();
    }
}