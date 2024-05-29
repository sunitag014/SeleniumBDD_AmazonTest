package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;

import java.time.Duration;

public class Homepage_Page extends BaseClass {
    public WebDriver driver;
    public static String price,subTotalOnCartPage,subTotalOnProductPagePrice,priceOfProductOnCartPage;
    private final WebDriverWait wait;
    public Homepage_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void navigateToURL(String url) {

        BaseClass.driver.get(url);

    }
    public void searchInSearchBox(String searchText) throws InterruptedException {
    WebElement searchBox =BaseClass.driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.clear();
    searchBox.sendKeys(searchText);
    searchBox.sendKeys(Keys.ENTER);
Thread.sleep(3000);
    }
    public void verifyText(String expectedText)
    {
        String actualText = BaseClass.driver.findElement(By.xpath("//span[text()='Results']")).getText();

    }
    public void clickOnFirstAddToCartButton(String index) throws InterruptedException {
        try {
            String addToCartXPath = "(//button[text()='Add to cart'])[" + index + "]";

            WebElement addToCartButton =BaseClass.driver.findElement(By.xpath(addToCartXPath));
            addToCartButton.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Rethrow the exception to propagate it up the stack
        }
        Thread.sleep(3000);


    }

    public void priceOfOnProductPage(String index)
    {
        price =null;
        WebElement priceForFirstItem = BaseClass.driver.findElement(By.xpath("(//span[@class='a-price'])[" + index + "]"));
        price= priceForFirstItem.getText();
        price=price.concat(".00");
        price=price.substring(1);
        WebElement subTotalOnProductPage = BaseClass.driver.findElement(By.xpath("//span[@class='ewc-subtotal-amount']"));
        subTotalOnProductPagePrice= subTotalOnProductPage.getText();
        subTotalOnProductPagePrice=subTotalOnProductPagePrice.trim();
        System.out.println("Price : " +price);
        System.out.println("subTotalOnProductPagePrice:"+subTotalOnProductPagePrice);

    }
    public void clickOnCartButton()
    {
        WebElement cartButton = BaseClass.driver.findElement(By.id("nav-cart-count"));
        cartButton.click();

    }

    public void getPriceOfItem(String index){
        WebElement priceOfSelectedItem = BaseClass.driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[" + index + "]"));
        subTotalOnCartPage = priceOfSelectedItem.getText();
        subTotalOnCartPage=subTotalOnCartPage.trim();

        WebElement priceOfProduct = BaseClass.driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
        priceOfProductOnCartPage= priceOfProduct.getText();
        priceOfProductOnCartPage=priceOfProductOnCartPage.trim();

        System.out.println("subTotalOnCartPage: " +subTotalOnCartPage);
        System.out.println("priceOfProductOnCartPage: " +priceOfProductOnCartPage);

    }


}