package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactUsPage {
    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//h2)[2]")
    public WebElement getInTouchText ;

    @FindBy(name = "name")
    public WebElement nameText;
    @ FindBy(name="email")
    public WebElement email;
    @ FindBy(name="subject")
    public WebElement subject;
    @ FindBy(name="message")
    public WebElement message;
    @ FindBy(name="upload_file")
    public WebElement uploadFile;
    @ FindBy(name="submit")
    public WebElement submit;
    @ FindBy(xpath= "//*[text()='Success! Your details have been submitted successfully.']")
    public WebElement successMessage;

}


