package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    @FindBy(how = How.ID, using = "sntch_button")
    public WebElement chatboxButton;

    @FindBy(how=How.CSS, using = ".navbar-brand > img")
    public WebElement snatchBotImage;

    @FindBy(how=How.CSS, using ="iframe[name='mobile']")
    public WebElement iframe;

    public void clickonChatboxButton() {
        chatboxButton.click();
    }



}
