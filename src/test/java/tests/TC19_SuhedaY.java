package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.BrandPage;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TC19_SuhedaY {

    HomePage homePage=new HomePage();
    BrandPage brandPage=new BrandPage();

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        //Click on 'Products' button
        homePage.productButton.click();
        // brandPage.products.click();

        //Verify that Brands are visible on left side bar
        Assert.assertTrue(brandPage.brands.isDisplayed());
        /**if(brandPage.brands.isDisplayed()){
         System.out.println("Element is visible");
         }else{
         System.out.println("Element is invisible");
         }*/

        //Click on any brand name
        List<WebElement> allBrands=Driver.getDriver().findElements(By.xpath("//div[@class='brands-name']//li"));
        //* get the length of total brands
        int totalSize=allBrands.size();
        //* get random number
        Random random=new Random();
        int randomBrand=random.nextInt(totalSize);
        //* select the list item
        allBrands.get(randomBrand).click();

        //Verify that user is navigated to brand page and brand products are displayed
        String title1=Driver.getDriver().getTitle();
        if(title1!="Automation Exercise - All Products"){
            System.out.println("User is navigated to brand page");
        }else{
            System.out.println("User is not navigated to brand page");
        }
        //*Verify that brand products are displayed
        Assert.assertTrue(brandPage.brandProducts.isDisplayed());

        //On left side bar, click on any other brand link
        List<WebElement> allBrands2=Driver.getDriver().findElements(By.xpath("//div[@class='brands-name']//li"));
        int totalSize2=allBrands2.size();
        Random random2=new Random();
        int randomBrand2=random.nextInt(totalSize2);
        allBrands2.get(randomBrand2).click();

        //Verify that user is navigated to that brand page and can see products
        String title2=Driver.getDriver().getTitle();
        if(title2!=title1){
            System.out.println("User is navigated to other brand page");
        }else{
            System.out.println("User is not navigated to other brand page");
        }

    }

    @After
    public void tearDown(){
        // driver.close();
    }

}