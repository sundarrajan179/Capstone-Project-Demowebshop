// HomePageSteps.java
package stepDefinations;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Hooks.Hooks;
import io.cucumber.java.en.*;
import pages.HomePage;
import utils.Base;

public class HomePageSteps {

    HomePage homePage;
    WebDriver driver = Base.driver;
    ExtentTest test = Hooks.test;

    @Given("I open the browser and navigated to home page")
    public void i_open_the_browser() {
        homePage = new HomePage(driver, test);
        System.out.println("The browser is opened and Home Page is initialized.");
    }

    @Then("check the page have {string} section")
    public void the_page_must_not_have(String unexpectedText) {
        homePage.checkSectionAbsence(unexpectedText);
    }

    @Then("the search bar should be available")
    public void the_search_bar_should_be_available() {
        homePage.verifySearchBarVisibility();
    }
}