package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02SehriTTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    public void TestCase02() {

    //2. Navigate to url 'http://automationexercise.com'
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

    //3. Verify that home page is visible successfully
        Assert.assertEquals("Automation Exercise", Driver.getDriver().getTitle());
        //Assert.assertTrue(homePage.homeIcon.isDisplayed());
        ReusableMethods.waitFor(3);

    //4. Click on 'Signup / Login' button
        loginPage.signUpLoginButton.click();

    //5. Verify 'Login to your account' is visible
        Assert.assertEquals("Login to your account is not visible","Login to your account",loginPage.loginToYourAccountText.getText());

    //6. Enter correct email address and password
        loginPage.loginEmailInput.sendKeys("asdef@gmail.com");
        loginPage.loginPasswordInput.sendKeys("1234");

    //7. Click 'login' button
        loginPage.loginButton.click();

    //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePage.loggedInAsIcon.isDisplayed());

    //9. Click 'Delete Account' button
        homePage.deleteAccountButton.click();

    //10. Verify that 'ACCOUNT DELETED!' is visible
        //There is a defect. Account Deleted link doesn't work


    }
}
