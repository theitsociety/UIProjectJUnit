package pages;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage{

    @FindBy (xpath = "//h2[@class='title text-center']")
    public WebElement accountCreatedText;

    @FindBy(xpath = "//a[.='Continue']")
    public WebElement continueButton;




}
