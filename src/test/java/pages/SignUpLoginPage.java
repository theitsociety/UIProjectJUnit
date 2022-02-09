package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpLoginPage {
<<<<<<< HEAD
    public SignUpLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
=======
    public SignUpLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

>>>>>>> main
    @FindBy(xpath = "(//h2)[3]")
    public WebElement newUserSignUpText;
    @FindBy(name = "name")
    public WebElement signUpName;
    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement signUpEmail;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signInButton;
    @FindBy(xpath = "(//input[@name= 'email'])[1]")
    public WebElement loginEmail;
    @FindBy(xpath = "//input[@name= 'password']")
    public WebElement loginPassword;
    @FindBy(xpath = "//button[text()= 'Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//*[text()='Your email or password is incorrect!']")
    public WebElement incorrectEmail;
<<<<<<< HEAD
=======
    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginMessage;
    @FindBy(partialLinkText = "Logged in as")
    public WebElement loggedInAsMessage;
    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement logOutbutton;
>>>>>>> main
}
