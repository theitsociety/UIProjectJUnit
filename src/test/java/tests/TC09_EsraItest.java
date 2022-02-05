package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.TC09_SearchProduct_EsraIpage;
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
    //TC09_SearchProduct_EsraIpage

    TC09_SearchProduct_EsraIpage tc09_SearchProduct_esraIpage;


    @Test
    public void SearchProduct() {
        tc09_SearchProduct_esraIpage = new TC09_SearchProduct_EsraIpage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
       // Assert.assertEquals("Automation Exercise", Driver.getDriver().getTitle());
        ReusableMethods.verifyElementDisplayed(tc09_SearchProduct_esraIpage.automationExerciseText);

        tc09_SearchProduct_esraIpage.products.click();
        ReusableMethods.verifyElementDisplayed(tc09_SearchProduct_esraIpage.allProductsText);

        tc09_SearchProduct_esraIpage.searchBox.sendKeys("Blue Top");
        tc09_SearchProduct_esraIpage.searchButton.click();

        ReusableMethods.waitForVisibility(tc09_SearchProduct_esraIpage.searchedProducts, 1000);
        ReusableMethods.verifyElementDisplayed(tc09_SearchProduct_esraIpage.searchedProducts);
        Driver.getDriver().navigate().back();

        List<WebElement> productList = Driver.getDriver().findElements(By.xpath("//div[@class='product-image-wrapper']"));
        System.out.println(productList.size());

        List<String> allProductList= new ArrayList<>();
        for (WebElement eachPrice : productList) {
            allProductList.add(eachPrice.getText());
        }
        System.out.println(allProductList);

        ReusableMethods.verifyElementDisplayed(tc09_SearchProduct_esraIpage.allProducts);



    }
    @After
    public void tearDown() {
        Driver.getDriver().close();


    }



}
