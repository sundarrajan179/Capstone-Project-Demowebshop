// ProductDetailPageSteps.java
package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import Hooks.Hooks;

import pages.ProductDetailPage;
import utils.Base;

public class ProductDetailPageSteps {

    private WebDriver driver = Base.driver;
    private ProductDetailPage productDetailPage;
    ExtentTest test = Hooks.test;

    @Given("I am on the home page for product detail testing")
    public void iAmOnTheHomePageForProductDetailTesting() {
        productDetailPage = new ProductDetailPage(driver, test);
        // Assuming your setup already navigates to the home page
    }

    @When("I search for {string} and click the product link")
    public void iSearchForAndClickTheProductLink(String searchTerm) {
        productDetailPage.searchProduct(searchTerm);
        productDetailPage.clickProductLink();
    }

    @Then("the product name contains {string}")
    public void theProductNameContains(String expectedText) {
        productDetailPage.verifyProductNameContains(expectedText);
    }

    @Then("the product description is {string}")
    public void theProductDescriptionIs(String expectedDescription) {
        productDetailPage.verifyProductDescription(expectedDescription);
    }

    @Then("the product price is {string}")
    public void theProductPriceIs(String expectedPrice) {
        productDetailPage.verifyProductPrice(expectedPrice);
    }

    @When("I click the add to wishlist button")
    public void iClickTheAddToWishlistButton() {
        productDetailPage.clickAddToWishlist();
    }

    @When("I click the add to cart button")
    public void iClickTheAddToCartButton() {
        productDetailPage.clickAddToCart();
    }
}