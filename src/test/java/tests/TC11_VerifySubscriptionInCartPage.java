package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class TC11_VerifySubscriptionInCartPage {

    HomePage homePage;

    @Test
    public void verifySubscriptionInCartPage(){

        //Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        //Verify that home page is visible successfully
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(actualTitle, expectedTitle);

        homePage = new HomePage();

        //Click 'Cart' button
        homePage.cartButton.click();

        //Scroll down to Subscription text
        JSUtils.scrollIntoViewJS(homePage.subscriptionText);
        ReusableMethods.waitFor(2);

        //Verify text 'SUBSCRIPTION'
        Assert.assertTrue(homePage.subscriptionText.isDisplayed());


        //Enter email address in email input box and click arrow button
        homePage.emailTextBox.sendKeys("test@gmail.com");
        homePage.arrowButton.click();

        //Verify success message 'You have been successfully subscribed!' is visible
        ReusableMethods.waitFor(1);
        Assert.assertTrue(homePage.successMessage.isDisplayed());
    }
}
