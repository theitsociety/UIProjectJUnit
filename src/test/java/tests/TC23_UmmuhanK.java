package tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class TC23_UmmuhanK {
    HomePage homePage;
    SignUpLoginPage signUpLoginPage;
    CartPage cartPage;
    SignInPage signInPage;

    @Test
    public  void test1() {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

//        3. Verify that home page is visible successfully
        homePage = new HomePage();
        ReusableMethods.verifyElementDisplayed(homePage.signUpLogin);

//      4. Click 'Signup / Login' button
        homePage.signUpLogin.click();

//      5. Fill all details in Signup and create account
        signUpLoginPage =new SignUpLoginPage();
        signUpLoginPage.signUpName.sendKeys("Ali");
        signUpLoginPage.signUpEmail.sendKeys("john80@gmail.com");
        signUpLoginPage.signInButton.click();

        signInPage =new SignInPage();
        signInPage.genderCheckBox.click();

        ReusableMethods.verifyElementDisplayed(signInPage.enterAccount);
        signInPage.genderCheckBox.click();

        signInPage.name.clear();
        signInPage.name.sendKeys("Ali");
        //signInPage.email.clear();
        //signInPage.email.sendKeys("john80@gmail.com");
        signInPage.password.sendKeys("1234");

        Select daySelect = new Select(signInPage.day);
        daySelect.selectByIndex(2);

        Select monthSelect = new Select(signInPage.month);
        daySelect.selectByIndex(3);

        Select yearSelect = new Select(signInPage.year);
        yearSelect.selectByValue("2000");

        signInPage.newsletter.click();
        signInPage.receiveOffers.click();

        signInPage.firstname.sendKeys("Alp");
        signInPage.lastname.sendKeys("Moore");
        signInPage.company.sendKeys("Apple");

        signInPage.address1.sendKeys("567 Strawberry Street");
        String address1 = signInPage.address1.getText();
        signInPage.address2.sendKeys("Suite 2");

        Select countrySelect = new Select(signInPage.country);
        countrySelect.selectByVisibleText("United States");

        signInPage.city.sendKeys("Santa Ana");
        signInPage.state.sendKeys("California");
        signInPage.zipcode.sendKeys("90000");
        signInPage.mobileNumber.sendKeys("9006782345");
        signInPage.createAccount.click();

//      6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        ReusableMethods.verifyElementDisplayed(signInPage.accountCrated);
        signInPage.continue1.click();

//      7. Verify ' Logged in as username' at top
        ReusableMethods.verifyElementDisplayed(homePage.loggedUsername);

//      8. Add products to cart
        ReusableMethods.doubleClick(homePage.productBlueTop);
        homePage.productBlueTop.click();
        ReusableMethods.waitFor(1);
        homePage.addToCartProductBlueTop.click();
        homePage.continueShopping.click();

//      9. Click 'Cart' button
        homePage.cartButton.click();

//      10. Verify that cart page is displayed
        cartPage = new CartPage();
        ReusableMethods.verifyElementDisplayed(cartPage.cartPage);

//      11. Click Proceed To Checkout
        cartPage.proceedToCheckout.click();

//      12. Verify that the delivery address is same address filled at the time registration of account
        ReusableMethods.verifyElementDisplayed(cartPage.deliveryAddress);

//        13. Verify that the billing address is same address filled at the time registration of account
        ReusableMethods.verifyElementDisplayed(cartPage.billingAddress);

//        14. Click 'Delete Account' button
        homePage.deleteButton.click();
//        15. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    }
}