package tests;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Test;
import pages.HomePage;
import pages.ProductPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Click on 'Products' button
    4. Verify user is navigated to ALL PRODUCTS page successfully
    5. Click on 'View Product' button
    6. Verify 'Write Your Review' is visible
    7. Enter name, email and review
    8. Click 'Submit' button
    9. Verify success message 'Thank you for your review.'
     */

public class TC21_HaticeC {
    HomePage homePage;
    ProductPage productPage;
    Faker faker;

    @Test
    public void test21() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        homePage = new HomePage();
        homePage.productButton.click();
        productPage = new ProductPage();
        ReusableMethods.verifyElementDisplayed(productPage.allProductsHead);
        productPage.productDetail.click();
        ReusableMethods.verifyElementDisplayed(productPage.productReview);
        faker = new Faker();
        productPage.nameBox.sendKeys(faker.name().fullName());
        productPage.emailBox.sendKeys(faker.internet().emailAddress());
        productPage.reviewArea.sendKeys("Nice color");
        productPage.submitButton.click();
        ReusableMethods.waitForVisibility(productPage.successMessage, 2);
        ReusableMethods.verifyElementDisplayed(productPage.successMessage);
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
