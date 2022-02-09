package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='All Products']")
    public WebElement allProductsHead;
    @FindBy(xpath = "//a[@href='/product_details/4']")
    public WebElement productDetail;
    //These elements are in the product detail page for Stylish Dress
    @FindBy(xpath = "//a[@href='#reviews']")
    public WebElement productReview;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameBox;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;
    @FindBy(xpath = "//textarea[@id='review']")
    public WebElement reviewArea;
    @FindBy(xpath = "//button[@id='button-review']")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@class='alert-success alert']")
    public WebElement successMessage;


    @FindBy(xpath = "(//li)[2]")
    public WebElement products;

    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    public WebElement allProductsText;

    @FindBy(xpath = "//input[@class= 'form-control input-lg']")
    public WebElement searchBox;

    @FindBy(xpath = "//i[@class= 'fa fa-search']")
    public WebElement searchButton;

    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    public WebElement searchedProducts;


    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    public WebElement allProducts;
}


