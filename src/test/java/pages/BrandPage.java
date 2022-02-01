package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrandPage {

    public BrandPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="(//div[@class='col-sm-8']//li)[2]/a")
    public WebElement products;

    @FindBy(xpath="//div[@class='brands_products']")
    public WebElement brands;

    @FindBy(xpath="//div[@class='features_items']")
    public WebElement brandProducts;






}
