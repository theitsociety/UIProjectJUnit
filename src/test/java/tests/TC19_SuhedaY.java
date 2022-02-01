package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TC19_SuhedaY {

    WebDriver driver;
    Random random=new Random();

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test() {
        //Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //Verify that Brands are visible on left side bar
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='brands_products']")).isDisplayed());
        /**if(driver.findElement(By.xpath("//div[@class='brands_products']")).isDisplayed()){
         System.out.println("Element is visible");
         }else{
         System.out.println("Element is invisible");
         }*/

        //Click on any brand name
        List<WebElement> allBrands=driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked']/a[@href='/brand_products/']"));

        System.out.println(allBrands);

        //ul[@id="someid"]/li[@class="someclass"]

    }



    //Verify that user is navigated to brand page and brand products are displayed
    //On left side bar, click on any other brand link
    //Verify that user is navigated to that brand page and can see products
    @After
    public void tearDown(){
        // driver.close();
    }

}

