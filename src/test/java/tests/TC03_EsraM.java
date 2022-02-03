package tests;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.SignUpLoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;


public class TC03_EsraM {
    HomePage homePage;
    SignUpLoginPage signUpLoginPage;


    //Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter incorrect email address and password
    //7. Click 'login' button
    //8. Verify error 'Your email or password is incorrect!' is visible


    @Test
    public void loginWithInvalidCredentials() {


        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Assert.assertEquals("Automation Exercise", Driver.getDriver().getTitle());
        homePage = new HomePage();
        Assert.assertTrue(homePage.signUpLogin.isDisplayed());
        homePage.signUpLogin.click();
        signUpLoginPage = new SignUpLoginPage();
        Assert.assertEquals("Login to your account", signUpLoginPage.loginMessage.getText());


//      Login with invalid password


        signUpLoginPage.loginEmail.sendKeys("flower@hotmail.com");
        signUpLoginPage.loginPassword.sendKeys("flowers");
        signUpLoginPage.loginButton.click();
        System.out.println(signUpLoginPage.incorrectEmail.getText());
        Assert.assertEquals("Your email or password is incorrect!", signUpLoginPage.incorrectEmail.getText());

        Driver.getDriver().close();
    }
}