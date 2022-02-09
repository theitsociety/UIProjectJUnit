package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.ProductPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;


public class TC09_EsraItest{
/*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. Enter product name in search input and click search button
    7. Verify 'SEARCHED PRODUCTS' is visible
    8. Verify all the products related to search are visible
     */

    HomePage homePage;
    ProductPage productPage;

    @Test
    public void SearchProduct() {
        homePage = new HomePage();
        productPage = new ProductPage();

        //Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        //  Verify that home page is visible successfully
        Assert.assertEquals("Automation Exercise", Driver.getDriver().getTitle());
        ReusableMethods.verifyElementDisplayed(homePage.automationExerciseText);

        //Click on 'Products' button
        productPage.products.click();

        // Verify user is navigated to ALL PRODUCTS page successfully
        ReusableMethods.verifyElementDisplayed( productPage.allProductsText);

        // Enter product name in search input and click search button
        productPage.searchBox.sendKeys("Blue Top");
        productPage.searchButton.click();

        //Verify 'SEARCHED PRODUCTS' is visible
        ReusableMethods.verifyElementDisplayed( productPage.searchedProducts);
        Driver.getDriver().navigate().back();



        //Verify all the products related to search are visible
        ReusableMethods.verifyElementDisplayed(productPage.allProducts);
        Assert.assertTrue(productPage.allProducts.isDisplayed());


        List<WebElement> productList = Driver.getDriver().findElements(By.xpath("//div[@class='product-image-wrapper']"));
        System.out.println(productList.size());

        List<String> allProductList= new ArrayList<>();
        List<String> allProductsHas = new ArrayList<>();
        for (WebElement eachPrice : productList) {
            allProductList.add(eachPrice.getText());
            allProductsHas.add(eachPrice.getText());
        }

        System.out.println("All products are visible!!! " + "\n" + allProductList);
        Assert.assertEquals(allProductList,allProductsHas);

    }



    @After
    public void tearDown() {
        Driver.getDriver().close();


    }



}
