package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC09_SearchProduct_EsraIpage {


    public TC09_SearchProduct_EsraIpage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
   // @FindBy(className ="logo pull-left")
    @FindBy(xpath ="//div[@class='logo pull-left']")
    public WebElement automationExerciseText;

    @FindBy(xpath="(//li)[2]")
    public WebElement products;

    @FindBy(xpath="//h2[contains(text(),'All Products')]")
    public WebElement allProductsText;

    @FindBy(xpath="//input[@class= 'form-control input-lg']")
    public WebElement searchBox;

    @FindBy(xpath="//i[@class= 'fa fa-search']")
    public WebElement searchButton;

    @FindBy(xpath="//h2[contains(text(),'Searched Products')]")
    public WebElement searchedProducts;

    @FindBy(xpath="//div[@class='product-image-wrapper']")
    public WebElement allProducts;



}

