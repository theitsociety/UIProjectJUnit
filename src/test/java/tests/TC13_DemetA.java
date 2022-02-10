package tests;


import org.junit.After;
import org.junit.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

/*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'View Product' for any product on home page
    5. Verify product detail is opened
    6. Increase quantity to 4
    7. Click 'Add to cart' button
    8. Click 'View Cart' button
    9. Verify that product is displayed in cart page with exact quantity
     */
public class TC13_DemetA {
    HomePage homePage;
    @Test
    public void test13() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        ReusableMethods.waitForVisibility(homePage.slideImagesText, 10);
        ReusableMethods.verifyElementDisplayed(homePage.slideImagesText);
        homePage.blueTop.click();
        ReusableMethods.verifyElementDisplayed(homePage.writeYourReview);
        homePage.quantityOfBlueTop.sendKeys("4");
        homePage.addCartBlueTop.click();
        homePage.viewCartBlueTop.click();
        ReusableMethods.verifyElementDisplayed(homePage.blueTop);
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }

}
