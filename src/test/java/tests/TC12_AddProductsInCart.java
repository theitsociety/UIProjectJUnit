package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.ProductPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC12_AddProductsInCart {

    HomePage homePage;
    ProductPage productPage;

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

        Assert.assertTrue(productPage.productPicture1.isDisplayed());
        Assert.assertTrue(productPage.productPicture2.isDisplayed());

//        WebElement product1 = Driver.getDriver().findElement(By.id("product-1"));
//        Assert.assertTrue(product1.getText().contains("Blue Top"));
//        WebElement product2 = Driver.getDriver().findElement(By.id("product-2"));
//        Assert.assertTrue(product2.getText().contains("Men Tshirt"));



    }
}
