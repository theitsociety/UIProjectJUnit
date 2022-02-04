package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPage {
    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Verify that 'ENTER ACCOUNT INFORMATION' is visible
    @FindBy(xpath = "(//b)[1]")
    public WebElement enterAccount;

    // Fill details: Title, Name, Email, Password, Date of birth
    @FindBy(id = "uniform-id_gender2")
    public WebElement genderCheckBox;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(xpath = "//*[@disabled='disabled']")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    // Selecting birth day
    @FindBy(id = "days")
    public WebElement day;

    @FindBy(id = "months")
    public WebElement month;

    @FindBy(id = "years")
    public WebElement year;

    @FindBy(id = "newsletter")
    public WebElement newsletter;

    @FindBy(id = "optin")
    public WebElement receiveOffers;

    @FindBy(id = "first_name")
    public WebElement firstname;

    @FindBy(id = "last_name")
    public WebElement lastname;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "address2")
    public WebElement address2;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "zipcode")
    public WebElement zipcode;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccount;

    @FindBy(xpath = "//b")
    public WebElement accountCrated;

    @FindBy(xpath = "//*[@data-qa='continue-button']")
    public WebElement continue1;
}