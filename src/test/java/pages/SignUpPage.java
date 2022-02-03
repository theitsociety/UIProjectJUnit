package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy (xpath = "(//h2[@class='title text-center'])[1]")
    public WebElement enterAccountInformationText;

    @FindBy (id="id=\"uniform-id_gender1\"")
    public WebElement titleMr;

    @FindBy (id="id_gender2")
    public WebElement titleMrs;

    @FindBy (id="name")
    public WebElement nameInput;

    @FindBy (id="email")
    public WebElement emailInput;

    @FindBy(id="password")
    public WebElement passwordInput;

    @FindBy (id="days")
    public WebElement day;

    @FindBy (id="months")
    public WebElement month;

    @FindBy (id="years")
    public WebElement year;

    @FindBy (id="newsletter")
    public WebElement checkboxNewsletter;

    @FindBy (id="optin")
    public WebElement checkboxSpecialOffer;

    @FindBy (id="first_name")
    public WebElement firstNameInput;

    @FindBy(id="last_name")
    public WebElement lastNameInput;

    @FindBy(id ="company")
    public WebElement companyInput;

    @FindBy(id = "address1")
    public WebElement address1Input;

    @FindBy(id = "address2")
    public WebElement address2Input;

    @FindBy (id = "country")
    public WebElement countryDropdown;

    @FindBy (id = "state")
    public WebElement stateInput;

    @FindBy (id = "city")
    public WebElement cityInput;

    @FindBy (id = "zipcode")
    public WebElement zipcodeInput;

    @FindBy (id = "mobile_number")
    public WebElement mobileNumberInput;

    @FindBy (xpath = "//button[.='Create Account']")
    public WebElement createAccountButton;







}
