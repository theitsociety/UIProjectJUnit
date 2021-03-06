package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC26_AytenT {
//
//    Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'                  +
// 3. Verify that home page is visible successfully         +
//4. Scroll down page to bottom
//5. Verify 'SUBSCRIPTION' is visible                                  +
//6. Click on arrow at bottom right side to move upward
//7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen


    HomePage page = new HomePage();

    @Test
    public void testTC026() {
//        2.step
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

//        3. step
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertTrue(actualTitle.equals(expectedTitle));

//        4. Step
        JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();
        je.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        ReusableMethods.waitFor(3);

//5. step

        Assert.assertEquals("SUBSCRIPTION", page.subciptionButton.getText());
        System.out.println(page.subciptionButton.getText());

//        6. Step
        je.executeScript("window.scrollTo(0,-350)");
          ReusableMethods.waitFor(4);
//        7. Step

        WebElement verifyScroll = Driver.getDriver().findElement(By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']"));
        Assert.assertEquals("Full-Fledged practice website for Automation Engineers",verifyScroll.getText());
 Driver.closeDriver();
    }
}
