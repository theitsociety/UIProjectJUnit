package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="//*[text()='Shopping Cart'] " )
    public WebElement cartPage ;
    @FindBy(xpath ="//*[text()='Proceed To Checkout']" )
    public WebElement proceedToCheckout ;
    @FindBy(xpath = "(//li[@class='address_address1 address_address2'])[2]" )
    public WebElement deliveryAddress;
    @FindBy(xpath = "(//li[@class='address_address1 address_address2'])[5]" )
    public WebElement billingAddress;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement addressDetails;
    @FindBy(xpath = "(//h2)[2]")
    public WebElement reviewOrder;
    @FindBy(xpath ="(//a[@href='/login'])[2]" )
    public WebElement registerLogin;
    @FindBy(name ="message")
    public WebElement commentText;
    @FindBy(xpath = "//*[@href='/payment']")
    public WebElement placeOrder;
    @FindBy(name = "name_on_card")
    public WebElement nameOnCard;
    @FindBy(name ="card_number")
    public WebElement cardNumber;
    @FindBy(xpath = "//*[@name='cvc']")
    public WebElement cvs;
    @FindBy(name ="expiry_month")
    public WebElement expiryMonth;
    @FindBy(name ="expiry_year")
    public WebElement expiryYear;
    @FindBy(id ="submit")
    public WebElement payAndConfirmOrder;
    @FindBy(xpath ="//*[contains(text(),'Your order has been')]")
    public WebElement successMessage;
    @FindBy(xpath = "//a[@href='/download_invoice/500']")
    public WebElement downlandInvoiceButton;
    @FindBy (xpath = "//a[@data-qa='continue-button']" )
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    public WebElement subscriptionEmail;

    @FindBy(linkText = "Blue Top")
    public WebElement product1;

    @FindBy(linkText = "Men Tshirt")
    public WebElement product2;



}