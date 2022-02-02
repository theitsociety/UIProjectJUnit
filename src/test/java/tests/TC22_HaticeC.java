package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Scroll to bottom of page
    4. Verify 'RECOMMENDED ITEMS' are visible
    5. Click on 'Add To Cart' on Recommended product
    6. Click on 'View Cart' button
    7. Verify that product is displayed in cart page
     */

public class TC22_HaticeC {
    HomePage homePage;

    @Test
    public void test22() {
        homePage = new HomePage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        ReusableMethods.scrollToElement(homePage.recommended);
        ReusableMethods.verifyElementDisplayed(homePage.recommended);
        ReusableMethods.waitForVisibility(homePage.recommendedAddToCart, 10);
        homePage.recommendedAddToCart.click();
        homePage.viewCart.click();
        ReusableMethods.verifyElementDisplayed(homePage.menTshirt);
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
