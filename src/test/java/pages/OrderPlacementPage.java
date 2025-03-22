// OrderPlacementPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OrderPlacementPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.xpath("//input[@value='Search']");
    private By productLink = By.cssSelector("h2[class='product-title'] a");
    private By addToCartButton = By.id("add-to-cart-button-43");
    private By shoppingCartLink = By.xpath("//span[normalize-space()='Shopping cart']");
    private By countryDropdown = By.id("CountryId");
    private By stateDropdown = By.id("StateProvinceId");
    private By zipCodeInput = By.id("ZipPostalCode");
    private By estimateShippingButton = By.name("estimateshipping");
    private By termsOfServiceCheckbox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");
    private By checkoutAsGuestButton = By.xpath("//input[@value='Checkout as Guest']");
    private By firstNameInput = By.id("BillingNewAddress_FirstName");
    private By lastNameInput = By.id("BillingNewAddress_LastName");
    private By emailInput = By.id("BillingNewAddress_Email");
    private By companyInput = By.id("BillingNewAddress_Company");
    private By billingCountryDropdown = By.id("BillingNewAddress_CountryId");
    private By cityInput = By.id("BillingNewAddress_City");
    private By addressInput = By.id("BillingNewAddress_Address1");
    private By billingZipCodeInput = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberInput = By.id("BillingNewAddress_PhoneNumber");
    private By billingSaveButton = By.xpath("//input[@onclick='Billing.save()']");
    private By pickUpInStoreCheckbox = By.id("PickUpInStore");
    private By shippingSaveButton = By.xpath("//input[@onclick='Shipping.save()']");
    private By paymentMethodNextButton = By.className("payment-method-next-step-button");
    private By paymentInfoNextButton = By.className("payment-info-next-step-button");
    private By confirmButton = By.xpath("//input[@value='Confirm']");
    private By orderSuccessMessage = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");

    public OrderPlacementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void searchProduct(String searchTerm) {
        driver.findElement(searchBox).sendKeys(searchTerm);
        driver.findElement(searchButton).click();
    }

    public void clickProductLink() {
        wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void clickShoppingCartLink() {
        driver.findElement(shoppingCartLink).click();
    }

    public void selectCountry(String country) {
        Select dropdown = new Select(driver.findElement(countryDropdown));
        dropdown.selectByVisibleText(country);
    }

    public void selectState(String state) {
        Select dropdown = new Select(driver.findElement(stateDropdown));
        dropdown.selectByVisibleText(state);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(zipCodeInput).sendKeys(zipCode);
    }

    public void clickEstimateShipping() {
        driver.findElement(estimateShippingButton).click();
    }

    public void clickTermsOfService() {
        driver.findElement(termsOfServiceCheckbox).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void clickCheckoutAsGuest() {
        driver.findElement(checkoutAsGuestButton).click();
    }

    public void enterBillingDetails(String firstName, String lastName, String email, String company, String city, String address, String zipCode, String phoneNumber) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(companyInput).sendKeys(company);
        Select dropdown = new Select(driver.findElement(billingCountryDropdown));
        dropdown.selectByVisibleText("United States");
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(billingZipCodeInput).sendKeys(zipCode);
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void clickBillingSave() {
        driver.findElement(billingSaveButton).click();
    }

    public void clickPickUpInStore() {
        driver.findElement(pickUpInStoreCheckbox).click();
    }

    public void clickShippingSave() {
        driver.findElement(shippingSaveButton).click();
    }

    public void clickPaymentMethodNext() {
        driver.findElement(By.className("payment-method-next-step-button")).click();
    }

    public void clickPaymentInfoNext() {
        driver.findElement(By.className("payment-info-next-step-button")).click();
    }

    public void clickConfirm() {
        driver.findElement(confirmButton).click();
    }

    public void verifyOrderSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessMessage));
        Assert.assertTrue(driver.findElement(orderSuccessMessage).isDisplayed(), "Order not successfully processed.");
    }
}