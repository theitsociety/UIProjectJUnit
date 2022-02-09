package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC12_AddProductsInCart {

    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;

    @Test
    public void addProductsInCart(){

        //Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        //Verify that home page is visible successfully
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(actualTitle, expectedTitle);

        homePage = new HomePage();

        homePage.productButton.click();

        productPage = new ProductPage();


        Actions action1 = new Actions(Driver.getDriver());
        ReusableMethods.waitFor(2);
        action1.moveToElement(productPage.productPicture1).build().perform();
        action1.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        productPage.addToCart.click();
        productPage.continueShopping.click();

        Actions action2 = new Actions(Driver.getDriver());
        action2.moveToElement(productPage.productPicture2).build().perform();
        productPage.addToCart2.click();


        productPage.viewCart.click();

        cartPage = new CartPage();


        Assert.assertTrue(cartPage.product1.isDisplayed());

        Assert.assertTrue(cartPage.product2.isDisplayed());

        Assert.assertEquals("Rs. 500", cartPage.product_1_Price.getText());

        Assert.assertEquals("Rs. 400", cartPage.product_2_Price.getText());

        Assert.assertEquals("1", cartPage.product_1_Quantity.getText());

        Assert.assertEquals("1", cartPage.product_2_Quantity.getText());

        Assert.assertEquals("Rs. 500",cartPage.product_1_TotalPrice.getText());

        Assert.assertEquals("Rs. 400",cartPage.product_2_TotalPrice.getText());

    }
}
