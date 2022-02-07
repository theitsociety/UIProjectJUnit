package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="//div[@class='logo pull-left']")
    public WebElement automationExerciseText;


    @FindBy(xpath="//a[@href='/login']")
    public WebElement signUpLogin;
    @FindBy(xpath ="//a[@href='/contact_us']")
    public WebElement contactUsButton ;
    @FindBy(xpath = "//a[@href='/test_cases']")
    public WebElement testCasesButton;
    @FindBy(xpath = "(//a)[10]")
    public WebElement loggedUsername;
    @FindBy(xpath = "(//a[@href='/view_cart'])[1]")
    public WebElement cartButton;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement assertMessage;
    @FindBy(xpath = "//*[text()='Blue Top']")
    public WebElement productBlueTop;
    @FindBy(xpath ="(//a[@data-product-id='1'])[2]" )
    public WebElement addToCartProductBlueTop;
    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShopping;
    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteButton;
    @FindBy(xpath = "//i[@class='material-icons card_travel']")
    public WebElement productButton;
    @FindBy(xpath="//*[contains(text(),'recommended')]")
    public WebElement recommended;
    @FindBy(xpath = "(//a[@data-product-id='2' and @class='btn btn-default add-to-cart'])[3]")
    public WebElement recommendedAddToCart;
    @FindBy(xpath = "//*[contains(text(), 'View Cart')]")
    public WebElement viewCart;
    @FindBy(xpath = "//*[contains(text(), 'Men Tshirt')]")
    public WebElement menTshirt;


    @FindBy(xpath = "h2[(text () ='Subscription')]")
    public WebElement subscriptionText;
    @FindBy(id= " susbscribe_email")
    public WebElement emailTextBox;
    @FindBy(className= "fa fa-arrow-circle-o-right")
    public WebElement arrowButton;
    @FindBy(id= "success-subscribe")
    public WebElement successMessage;

}
