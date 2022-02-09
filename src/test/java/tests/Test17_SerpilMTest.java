package tests;

import com.google.common.base.*;
import org.junit.*;
import pages.*;
import utilities.*;

public class Test17_SerpilMTest {

    HomePage homePage;
    CartPage cartPage;
    @Test
    public  void test1() throws InterruptedException {

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        // 3. Verify that home page is visible successfully
        homePage = new HomePage();
        Assert.assertTrue(homePage.signUpLogin.isDisplayed());

        //  4. Add products to cart
        //Action actions = new Actions(Driver.getDriver());
        //actions.moveToElement(homePage.productBlueTop).perform();
        //Driver.getDriver().wait(2);
        homePage.productBlueTop.click();

        //  5. Click 'Cart' button
        homePage.addToCartProductBlueTop.click();

        //  6. Verify that cart page is displayed
        homePage.viewCart.click();
        cartPage =new CartPage();
        Assert.assertTrue(cartPage.cartPage.isDisplayed());

        //  7. Click 'X' button corresponding to particular product
        cartPage.deleteButton.click();

        //  8. Verify that product is removed from the cart
        Assert.assertTrue(cartPage.cartEmptyText.isDisplayed());
    }
}

