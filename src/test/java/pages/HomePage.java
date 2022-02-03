package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy (xpath = "(//a[@href=\"/\"])[2]")
    public WebElement homeIcon;

    @FindBy (xpath = "//i[@class='fa fa-user']")
    public WebElement loggedInAsIcon;

    @FindBy(xpath = "//i[@class='fa fa-trash-o']")
    public WebElement deleteAccountButton;




}
