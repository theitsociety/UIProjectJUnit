package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpLoginButton;

    @FindBy(xpath = "//h2[.='New User Signup!']")
    public WebElement newUserSignUpText;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement inputName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement inputEmail;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement signUpButton;

    @FindBy(xpath = "//h2[.='Login to your account']")
    public WebElement loginToYourAccountText;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPasswordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;





}
