// OrderPlacementPageSteps.java
package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.OrderPlacementPage;
import utils.Base;

public class OrderPlacementPageSteps {

    private WebDriver driver = Base.driver;
    private OrderPlacementPage orderPage = new OrderPlacementPage(driver);

    @Given("I am on the home page for order placement testing")
    public void iAmOnTheHomePageForOrderPlacementTesting() {
        // Assuming your setup already navigates to the home page
    }

    @When("I add a product to cart and proceed to checkout as guest")
    public void iAddAProductToCartAndProceedToCheckoutAsGuest() {
        orderPage.searchProduct("smartphone");
        orderPage.clickProductLink();
        orderPage.clickAddToCart();
        orderPage.clickShoppingCartLink();
        orderPage.selectCountry("United States");
        orderPage.selectState("Alabama");
        orderPage.enterZipCode("000000");
        orderPage.clickEstimateShipping();
        orderPage.clickTermsOfService();
        orderPage.clickCheckout();
        orderPage.clickCheckoutAsGuest();
    }

    @When("I fill in billing and shipping details")
    public void iFillInBillingAndShippingDetails() {
        orderPage.enterBillingDetails("John", "Doe", "john.doe@example.com", "Company", "City", "Address", "000000", "1234567890");
        orderPage.clickBillingSave();
        orderPage.clickPickUpInStore();
        orderPage.clickShippingSave();
    }

    @When("I complete the payment process")
    public void iCompleteThePaymentProcess() {
        orderPage.clickPaymentMethodNext();
        orderPage.clickPaymentInfoNext();
        orderPage.clickConfirm();
    }

    @Then("the order should be successfully placed")
    public void theOrderShouldBeSuccessfullyPlaced() {
       orderPage.verifyOrderSuccessMessage();
        
    }
}