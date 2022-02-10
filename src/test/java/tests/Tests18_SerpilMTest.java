
package tests;

import com.google.common.base.*;
import org.junit.*;
import pages.*;
import utilities.*;

public class Tests18_SerpilMTest {
    HomePage homePage;
    CartPage cartPage;

    @Test
    public void test1() throws InterruptedException {

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        // 3. Verify that categories are visible on left side bar
        homePage = new HomePage();
        Assert.assertTrue(homePage.category.isDisplayed());

        // 4. Click on 'Women' category
        //Action actions = new Actions(Driver.getDriver());
        //actions.moveToElement(homePage.productBlueTop).perform();
        homePage.womenCategory.click();
        //Driver.getDriver().wait(2);

        // 5. Click on any category link under 'Women' category, for example: Dress
        homePage.womenDress.isEnabled();

        // 6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        homePage.womenCategory.click();
        Assert.assertTrue(homePage.womenCategory.isDisplayed());

        // 7. On left side bar, click on any sub-category link of 'Men' category
        homePage.menTshirt.click();
//test
        // 8. Verify that user is navigated to that category page
        homePage.menPlusSign.click();
        Assert.assertTrue(homePage.menTshirt.isDisplayed());
    }
}