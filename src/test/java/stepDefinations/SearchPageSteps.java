// SearchPageSteps.java
package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import Hooks.Hooks;

import pages.SearchPage;
import utils.Base;

public class SearchPageSteps {

    private WebDriver driver = Base.driver;
    private SearchPage searchPage;
    ExtentTest test = Hooks.test;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        searchPage = new SearchPage(driver, test);
        // Assuming your setup already navigates to the home page
    }

    @When("I enter {string} in the search box and click search")
    public void iEnterInTheSearchBoxAndClickSearch(String searchTerm) {
        searchPage.enterSearchTerm(searchTerm);
        searchPage.clickSearchButton();
    }

    @When("I click the advanced search checkbox")
    public void iClickTheAdvancedSearchCheckbox() {
        searchPage.clickAdvancedSearchCheckbox();
    }

    @When("I select {string} from the category dropdown")
    public void iSelectFromTheCategoryDropdown(String category) {
        searchPage.selectCategory(category);
    }

    @When("I enter price range from {string} to {string}")
    public void iEnterPriceRangeFromTo(String from, String to) {
        searchPage.enterPriceRange(from, to);
    }

    @When("I click the search result button")
    public void iClickTheSearchResultButton() {
        searchPage.clickSearchResultButton();
    }

    @Then("search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        Assert.assertTrue(searchPage.isSearchResultDisplayed(), "Search results are not displayed.");
    }
}