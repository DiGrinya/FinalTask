package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//button[@data-test-id='ADD_ADDRESS_SUBMIT']")
    private WebElement doneButton;

    @FindBy(xpath = "//div[@id='firstName-error']")
    private WebElement emptyFieldMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDoneButton() {
        return doneButton;
    }

    public void clickDoneButton(){
        doneButton.click();
    }

    public WebElement getEmptyFieldMessage() {
        return emptyFieldMessage;
    }

    public String getEmptyFieldMessageText(){
       return emptyFieldMessage.getText();
    }

}
