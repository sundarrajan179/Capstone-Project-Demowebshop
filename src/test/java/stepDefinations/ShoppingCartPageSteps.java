
// ShoppingCartPageSteps.java
package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import Hooks.Hooks;

import pages.ShoppingCartPage;
import utils.Base;

public class ShoppingCartPageSteps {

    private WebDriver driver = Base.driver;
    private ShoppingCartPage shoppingCartPage;
    ExtentTest test = Hooks.test;

    @Given("I am on the home page for shopping cart testing")
    public void iAmOnTheHomePageForShoppingCartTesting() {
        shoppingCartPage = new ShoppingCartPage(driver, test);
        // Assuming your setup already navigates to the home page
    }

    @When("I search for {string} and add the product to cart")
    public void iSearchForAndAddTheProductToCart(String searchTerm) {
        shoppingCartPage.searchProduct(searchTerm);
        shoppingCartPage.clickProductLink();
        shoppingCartPage.clickAddToCart();
    }

    @When("I go to the shopping cart")
    public void iGoToTheShoppingCart() {
        shoppingCartPage.clickShoppingCartLink();
    }

    @When("I remove the product from cart")
    public void iRemoveTheProductFromCart() {
        shoppingCartPage.clickRemoveFromCartCheckbox();
        shoppingCartPage.clickUpdateCartButton();
    }

    @Then("the shopping cart is empty")
    public void theShoppingCartIsEmpty() {
        shoppingCartPage.verifyEmptyCartMessage("Your Shopping Cart is empty!");
    }
}