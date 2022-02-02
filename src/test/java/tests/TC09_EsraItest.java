package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.TC09_EsraIpage;
import utilities.ConfigurationReader;
import utilities.Driver;

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


    TC09_EsraIpage tc09_esraIpage;

    @Test
    public void SearchProduct(){
        tc09_esraIpage = new TC09_EsraIpage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        boolean text = tc09_esraIpage.automationExerciseText.isDisplayed();
        Assert.assertTrue(text);
        tc09_esraIpage.products.click();

        String allProductsText =tc09_esraIpage.allProducts.getText();
        Assert.assertEquals(allProductsText,"ALL PRODUCTS");

        tc09_esraIpage.searchBox.sendKeys("Blue Top");
        tc09_esraIpage.searchButton.click();

        String searchProducts= tc09_esraIpage.searchedProducts.getText();
        Assert.assertEquals(searchProducts, "SEARCHED PRODUCTS");




    }


}
