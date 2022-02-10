package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.SignUpLoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC15_AslanY {

    HomePage homePage;
    SignUpLoginPage signUpLoginPage;
    @Test
    public void registerBeforeCheckout() {

        //Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        //Verify that home page is visible successfully
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(actualTitle, expectedTitle);

        homePage = new HomePage();
        homePage.signUpLogin.click();

        signUpLoginPage = new SignUpLoginPage();
        signUpLoginPage.signUpName.sendKeys("test");
        signUpLoginPage.signUpEmail.sendKeys("testtest@test.com");
        signUpLoginPage.signInButton.click();

    }
}
