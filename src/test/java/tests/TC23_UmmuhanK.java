package tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;


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
        Assert.assertTrue(homePage.signUpLogin.isDisplayed());

//      4. Click 'Signup / Login' button
        homePage.signUpLogin.click();

//      5. Fill all details in Signup and create account
        signUpLoginPage =new SignUpLoginPage();
        signUpLoginPage.signUpName.sendKeys("Ali");
        signUpLoginPage.signUpEmail.sendKeys("johndoes23@gmail.com");
        signUpLoginPage.signInButton.click();

        signInPage =new SignInPage();
        signInPage.genderCheckBox.click();

        Assert.assertTrue(signInPage.enterAccount.isDisplayed());
        signInPage.genderCheckBox.click();
        signInPage.name.clear();
        signInPage.name.sendKeys("Ali");
        signInPage.email.clear();
        signInPage.email.sendKeys("johndoes23@gmail.com");
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

        String accountCreatedMessage = signInPage.accountCrated.getText();
        Assert.assertEquals("ACCOUNT CREATED!", accountCreatedMessage);
        signInPage.continue1.click();

//      7. Verify ' Logged in as username' at top
        String loggedUsername =homePage.loggedUsername.getText();
        Assert.assertEquals("Logged in as Ali", loggedUsername);

//      8. Add products to cart

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homePage.productBlueTop).perform();
        homePage.productBlueTop.click();
        homePage.addToCartProductBlueTop.click();
        homePage.continueShopping.click();

//      9. Click 'Cart' button
        homePage.cartButton.click();

//      10. Verify that cart page is displayed
        cartPage = new CartPage();
        String cartPagetext= cartPage.cartPage.getText();
        Assert.assertEquals("Shopping Cart", cartPagetext);

//      11. Click Proceed To Checkout
        cartPage.proceedToCheckout.click();

//      12. Verify that the delivery address is same address filled at the time registration of account
        String deliveryAdd= cartPage.deliveryAddress.getText();
        Assert.assertTrue(deliveryAdd.contains(address1));

//        13. Verify that the billing address is same address filled at the time registration of account
        String  billingAdd =cartPage.billingAddress.getText();
        Assert.assertTrue(billingAdd.contains(address1));


//        14. Click 'Delete Account' button
        homePage.deleteButton.click();
//        15. Verify 'ACCOUNT DELETED!' and click 'Continue' button


    }
}