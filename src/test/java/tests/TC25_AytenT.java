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

public class TC25_AytenT {

    HomePage page = new HomePage();
    @Test
    public void testTC025() {
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
    //    je.executeScript("window.scrollTo(0,-350)");
     //   Driver.getDriver().findElement(By.id("scrollUp")).click();
    //    page.UpArrow.click();
        ReusableMethods.waitFor(4);
//        7. Step

        WebElement verifyScroll = Driver.getDriver().findElement(By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']"));
        Assert.assertEquals("Full-Fledged practice website for Automation Engineers", verifyScroll.getText());
        Driver.closeDriver();
    }
}
