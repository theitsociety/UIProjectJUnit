package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.SignUpLoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC04_EsraM {

    HomePage homePage;
    SignUpLoginPage signUpLoginPage;


    @Test

  /* Launch browser
     Navigate to url 'http://automationexercise.com'
     Verify that home page is visible successfully
     Click on 'Signup / Login' button
     Verify 'Login to your account' is visible
     Enter correct email address and password
     Click 'login' button
     Verify that 'Logged in as username' is visible
     Click 'Logout' button
     Verify that user is navigated to login page */

    public void LogoutUser() {

        //   Launch browser Navigate to url 'http://automationexercise.com'Verify that home page is visible successfully

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Assert.assertEquals("Automation Exercise", Driver.getDriver().getTitle());

        homePage = new HomePage();
        Assert.assertTrue(homePage.signUpLogin.isDisplayed());
        homePage.signUpLogin.click();


//      Verify 'Login to your account' is visible
        signUpLoginPage = new SignUpLoginPage();
        Assert.assertEquals("Login to your account", signUpLoginPage.loginMessage.getText());

//      Login with invalid password
        signUpLoginPage.loginEmail.sendKeys("flowers@hotmail.com");
        signUpLoginPage.loginPassword.sendKeys("flowers");
        signUpLoginPage.loginButton.click();

//      Verify that 'Logged in as username' is visible
        Assert.assertEquals("Logged in as flowers", signUpLoginPage.loggedInAsMessage.getText());

//      Click 'Logout' button  /   Verify that user is navigated to login page
        signUpLoginPage.logOutbutton.click();
        Assert.assertEquals("Login to your account", signUpLoginPage.loginMessage.getText());

    }
}
