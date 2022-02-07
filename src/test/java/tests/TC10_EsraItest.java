package tests;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.ProductPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class TC10_EsraItest {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Scroll down to footer
    5. Verify text 'SUBSCRIPTION'
    6. Enter email address in input and click arrow button
    7. Verify success message 'You have been successfully subscribed!' is visible
     */
    HomePage homePage;
    ProductPage productPage;

    @Test
    public void VerifySubscriptionInHomePage() {
        homePage = new HomePage();
        productPage = new ProductPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        // Assert.assertEquals("Automation Exercise", Driver.getDriver().getTitle());
        ReusableMethods.verifyElementDisplayed(homePage.automationExerciseText);

//        Actions actions = new Actions(Driver.getDriver());
//        actions.keyDown(homePage.subscriptionText, Keys.SHIFT);

        ReusableMethods.scrollToElement(homePage.subscriptionText);
        ReusableMethods.verifyElementDisplayed(homePage.subscriptionText);

        homePage.emailTextBox.sendKeys("ghhh@gmail.com");
        homePage.arrowButton.click();

        ReusableMethods.verifyElementDisplayed(homePage.successMessage);

    }
}
