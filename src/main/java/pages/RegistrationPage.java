package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@id='password_err']")
    private WebElement messageWarning;

    @FindBy(xpath = "//button[@id='EMAIL_REG_FORM_SUBMIT']")
    private WebElement createAccountButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isNameFieldVisible() {
        return nameField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    public boolean isLastNameFieldVisible() {
        return lastNameField.isDisplayed();
    }

    public void setNameField(String info){
        nameField.sendKeys(info);
    }

    public void setLastNameField(String info){
        lastNameField.sendKeys(info);
    }

    public void setEmailField(String info){
        emailField.sendKeys(info);
    }

    public void setPasswordField(String info){
        passwordField.sendKeys(info);
    }

    public String getMessageWarning(){
        return messageWarning.getText();
    }

    public WebElement isMessageWarningVisible(){
        return messageWarning;
    }

    public void clickCreateAccountButton(){
        createAccountButton.click();
    }

}
