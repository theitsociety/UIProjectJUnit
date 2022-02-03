package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeletePage {
    public DeletePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
