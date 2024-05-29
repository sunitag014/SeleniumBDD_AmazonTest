package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.jsoup.Connection;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.Homepage_Page;
import utilities.BaseClass;


public class Homepage_Step {
    private WebDriver driver;
    BaseClass baseClass = new BaseClass();
    Homepage_Page homepagePage = new Homepage_Page(driver);

    @Given("User is on {string} url on main page")
    public void userIsOnUrlOnMainPage(String url) {
        baseClass.browserLaunch("Chrome");
        homepagePage.navigateToURL(url);
    }

    @And("User will search {string} in search field")
    public void userWillSearchInSearchField(String searchText) throws InterruptedException {
        homepagePage.searchInSearchBox(searchText);
    }

    @Then("User will verify text {string} after searching product")
    public void userWillVerifyTextAfterSearchingProduct(String expectedText) {
        homepagePage.verifyText(expectedText);

    }

    @And("User will click on {string} button")
    public void userWillClickOnButton(String arg0) {
        homepagePage.clickOnCartButton();
    }

    @And("User will click on {string} st item from the list")
    public void userWillClickOnStItemFromTheList(String index) throws InterruptedException {
        homepagePage.clickOnFirstAddToCartButton(index);
    }

    @Then("User will verify prices")
    public void userWillVerifyPrices() {
        System.out.println("Price :" +Homepage_Page.price);
        System.out.println("priceOfProductOnCartPage :" +Homepage_Page.priceOfProductOnCartPage);
        Assertions.assertEquals(Homepage_Page.price, Homepage_Page.priceOfProductOnCartPage, "Prices do not match!");
    }

       @And("User will get price of item {string} on product page")
    public void userWillGetPriceOfItemOnProductPage(String index) {
        homepagePage.priceOfOnProductPage(index);
    }

    @And("User will get price of item {string} on cartPage")
    public void userWillGetPriceOfItemOnPage(String index) {
        homepagePage.getPriceOfItem(index);
    }

    @Then("User will verify Subtotal on Product and Cart Page")
    public void userWillVerifySubtotalOnProductAndCartPage() {
        System.out.println("subTotalOnProductPagePrice :" +Homepage_Page.subTotalOnProductPagePrice);
        System.out.println("subTotalOnCartPage :" +Homepage_Page.subTotalOnCartPage);
        Assertions.assertEquals(Homepage_Page.subTotalOnProductPagePrice, Homepage_Page.subTotalOnCartPage, "Prices do not match!");

    }

    @Then("User will close browser")
    public void userWillCloseBrowser() {
        BaseClass.browserClose();
    }
}
