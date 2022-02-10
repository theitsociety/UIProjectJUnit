package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SignUpLoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC20_SuhedaY {


    @Before
    public void setUp() {
        //Launch browser
        //Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    SignUpLoginPage signUpLoginPage = new SignUpLoginPage();
    CartPage cartPage = new CartPage();

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void viewAndCartBrandProducts() {

        //Click on 'Products' button
        homePage.productButton.click();

        //Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(productPage.allProductsHead.isDisplayed());

        //Enter product name in search input and click search button
        productPage.searchProduct.sendKeys("jeans");
        productPage.searchButton.click();

        //Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(productPage.searchedProductsText.isDisplayed());

        //Verify all the products related to search are visible
        List<WebElement> allSearchedProducts = Driver.getDriver().findElements(By.xpath("//div[@class='product-overlay']"));
        System.out.println(allSearchedProducts.size());
        for (WebElement element : allSearchedProducts) {
            Assert.assertTrue(element.isDisplayed());
        }
        /**There is a bug. For example when "dress" searched,unlike dresses, other outfits are also visible. But I can't it automize
         because  name of every image, which is related to dress, doesn't containing "dress" keyword.  */

        // Add those products to cart
        List<WebElement> allAddToCart = Driver.getDriver().findElements(By.xpath("//*[@data-product-id]"));
        System.out.println(allAddToCart.size());
        //Because of two cart symbols for each product,it should be taken half of product size
        int actualAddedProductSize = allAddToCart.size() / 2;

        for (int i = 0; i < allAddToCart.size() / 2; i++) {
            WebElement each = allAddToCart.get(2 * i);
            //WebElement each=allAddToCart.get(2*i + 1);

            JSUtils.scrollIntoViewJS(each);
            ReusableMethods.waitFor(2);
            each.click();
            productPage.continueShopping.click();
        }

        //Click 'Cart' button and verify that products are visible in cart
        homePage.cartButton.click();

        List<WebElement> TotalRowsOrder = cartPage.orderTable.findElements(By.tagName("tr"));
        System.out.println("Total number of rows in the table are " + TotalRowsOrder.size());
        Assert.assertEquals(actualAddedProductSize, TotalRowsOrder.size());


        //Click 'Signup / Login' button and submit login details
        homePage.signUpLogin.click();

        signUpLoginPage.loginPassword.sendKeys("alican");
      /* try{
            signUpLoginPage.signinLoginEmail.sendKeys("ali_can@gmail.com");
           // js.executeScript("document.getElementById('email').value='ali_can@gmail.com'");
       }catch(Exception e){
           System.out.println("Failed");
       }
*/
        signUpLoginPage.loginButton.click();

        //Again, go to Cart page
        homePage.cartButton.click();

        //Verify that those products are visible in cart after login as well
        List<WebElement> TotalRowsOrder2 = cartPage.orderTable.findElements(By.tagName("tr"));
        Assert.assertEquals(TotalRowsOrder.size(), TotalRowsOrder2.size());

    }
}
