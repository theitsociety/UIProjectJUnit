package tests;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01SehriTTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();
    AccountCreatedPage accountCreatedPage = new AccountCreatedPage();

    Faker faker = new Faker();


    @Test
    public void TestCase01(){

    //2. Navigate to url 'http://automationexercise.com'
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

    //3. Verify that home page is visible successfully
        Assert.assertEquals("Automation Exercise", Driver.getDriver().getTitle());
        //Assert.assertTrue(homePage.homeIcon.isDisplayed());
        ReusableMethods.waitFor(3);

    //4. Click on 'Signup / Login' button
        loginPage.signUpLoginButton.click();

    // 5. Verify 'New User Signup!' is visible
        Assert.assertEquals("New User Signup!",loginPage.newUserSignUpText.getText());

    // 6. Enter name and email address
        loginPage.inputName.sendKeys("palmiye");
        ReusableMethods.waitFor(2);

        //String fakeEmail= faker.internet().emailAddress();

        loginPage.inputEmail.sendKeys("asdef@gmail.com");
        ReusableMethods.waitFor(2);

    //7. Click 'Signup' button
        loginPage.signUpButton.click();
        ReusableMethods.waitFor(2);

    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
       // wait.until(ExpectedConditions.visibilityOf(signUpPage.enterAccountInformationText));
       Assert.assertEquals("Text is not matching","ENTER ACCOUNT INFORMATION", signUpPage.enterAccountInformationText.getText());

    //9. Fill details: Title, Name, Email, Password, Date of birth
        ReusableMethods.waitForVisibility(signUpPage.titleMrs, 2);
        signUpPage.titleMrs.click();
        ReusableMethods.waitFor(2);

        signUpPage.passwordInput.sendKeys("1234");
        ReusableMethods.waitFor(1);

        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("scroll(0, 400);");

        Select select = new Select(signUpPage.day);
        select.selectByIndex(3);
        ReusableMethods.waitFor(1);

        Select select1 = new Select(signUpPage.month);
        select1.selectByIndex(2);
        ReusableMethods.waitFor(1);

        Select select2 = new Select(signUpPage.year);
        select2.selectByIndex(5);
        ReusableMethods.waitFor(1);

    //10. Select checkbox 'Sign up for our newsletter!'
        signUpPage.checkboxNewsletter.click();
        ReusableMethods.waitFor(1);

    //11. Select checkbox 'Receive special offers from our partners!'
        signUpPage.checkboxSpecialOffer.click();
        ReusableMethods.waitFor(1);

        JavascriptExecutor js1 = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("scroll(0, 400);");



    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        signUpPage.firstNameInput.sendKeys("Palmiye");
        ReusableMethods.waitFor(1);

        signUpPage.lastNameInput.sendKeys("Lastname");
        ReusableMethods.waitFor(1);

        signUpPage.companyInput.sendKeys("Company");
        ReusableMethods.waitFor(1);

        signUpPage.address1Input.sendKeys("College Station");
        ReusableMethods.waitFor(1);

        Select select3 = new Select(signUpPage.countryDropdown);
        select3.selectByValue("United States");
        ReusableMethods.waitFor(2);

        signUpPage.stateInput.sendKeys("Georgia");
        ReusableMethods.waitFor(2);

        signUpPage.cityInput.sendKeys("Athens");
        ReusableMethods.waitFor(2);

        signUpPage.zipcodeInput.sendKeys("12345");
        ReusableMethods.waitFor(2);

        js.executeScript("scroll(0, 200);");

        signUpPage.mobileNumberInput.sendKeys("7057037878");
        ReusableMethods.waitFor(3);

    //13. Click 'Create Account button'
        signUpPage.createAccountButton.click();
        ReusableMethods.waitFor(3);

    //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertEquals("Account created not visible","ACCOUNT CREATED!",accountCreatedPage.accountCreatedText.getText());

    //15. Click 'Continue' button
        ReusableMethods.waitFor(2);
        accountCreatedPage.continueButton.click();

    //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(homePage.loggedInAsIcon.isDisplayed());

    //17. Click 'Delete Account' button
        homePage.deleteAccountButton.click();

    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        //There is a defect. Account Deleted link doesn't work
        //I don't know how to verify it


    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }



}
