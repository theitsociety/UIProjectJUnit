package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;

import pages.CartPage;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpLoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.file.Files;
import java.nio.file.Paths;


public class TC24_UmmuhanK {
    Faker faker = new Faker();
    HomePage homePage;
    SignUpLoginPage signUpLoginPage;
    CartPage cartPage;
    SignInPage signInPage;



    @Test
    public  void test1() {
//  1. Launch browser
//  2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

//  3. Verify that home page is visible successfully
        homePage = new HomePage();
        ReusableMethods.verifyElementDisplayed(homePage.signUpLogin);

//  4. Add products to cart
        ReusableMethods.doubleClick(homePage.productBlueTop);
        homePage.productBlueTop.click();
        ReusableMethods.waitFor(1);
        homePage.addToCartProductBlueTop.click();
        homePage.continueShopping.click();

//  5. Click 'Cart' button
        homePage.cartButton.click();

//  6. Verify that cart page is displayed
        cartPage = new CartPage();
        ReusableMethods.verifyElementDisplayed(cartPage.cartPage);

//  7. Click Proceed To Checkout
        cartPage.proceedToCheckout.click();

//  8. Click 'Register / Login' button
        cartPage.registerLogin.click();

//  9. Fill all details in Signup and create account
        homePage.signUpLogin.click();
        signUpLoginPage = new SignUpLoginPage();
        signUpLoginPage.signUpName.sendKeys("Jane");
        signUpLoginPage.signUpEmail.sendKeys("jane_1@gmail.com");
        signUpLoginPage.signInButton.click();

//  10. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        signInPage =new SignInPage();
        ReusableMethods.verifyElementDisplayed(signInPage.accountCrated);

        signInPage.genderCheckBox.click();
        signInPage.name.clear();
        signInPage.name.sendKeys("Jane");
//        signInPage.email.clear();
//        signInPage.email.sendKeys("jane_1@gmail.com");
        signInPage.password.sendKeys("1234");

        Select daySelect = new Select(signInPage.day);
        daySelect.selectByIndex(2);

        Select monthSelect = new Select(signInPage.month);
        daySelect.selectByIndex(3);

        Select yearSelect = new Select(signInPage.year);
        yearSelect.selectByValue("2000");

        signInPage.newsletter.click();
        signInPage.receiveOffers.click();

        signInPage.firstname.sendKeys("Jane");
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
        signInPage.continue1.click();

//      11.   Verify ' Logged in as username' at top
        String loggedUsername =homePage.loggedUsername.getText();
        Assert.assertEquals("Logged in as Jane", loggedUsername);

//      12.Click 'Cart' button
        homePage.cartButton.click();

//      13. Click 'Proceed To Checkout' button
        cartPage.proceedToCheckout.click();

//      14. Verify Address Details and Review Your Order
        ReusableMethods.verifyElementDisplayed(cartPage.addressDetails);
        ReusableMethods.verifyElementDisplayed(cartPage.reviewOrder);

//      15. Enter description in comment text area and click 'Place Order'
        cartPage.commentText.sendKeys("hello");
        cartPage.placeOrder.click();

//      16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        cartPage.nameOnCard.sendKeys("John Doe");
        cartPage.cardNumber.sendKeys(faker.finance().creditCard());
        cartPage.cvs.sendKeys("234");
        cartPage.expiryMonth.sendKeys("06");
        cartPage.expiryYear.sendKeys("2035");

//      17. Click 'Pay and Confirm Order' button
        cartPage.payAndConfirmOrder.click();

//      18. Verify success message 'Your order has been placed successfully!'
        ReusableMethods.verifyElementDisplayed(cartPage.successMessage);

//      19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        cartPage.downlandInvoiceButton.click();
        String homeDirectory = System.getProperty("user.home");
        String pathOfImage =   homeDirectory +"/Downloads/invoice.txt";
        boolean isExist = Files.exists(Paths.get(pathOfImage)) ;
        Assert.assertTrue(isExist);

//20.   Click 'Continue' button
        cartPage.continueButton.click();

//21.   Click 'Delete Account' button
        homePage.deleteButton.click();

//22. Verify 'ACCOUNT DELETED!' and click 'Continue' button











    }

}