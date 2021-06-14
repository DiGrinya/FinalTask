package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends BasePage{

    public SigninPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='userid']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@id='signin_ggl_btn']")
    private WebElement singInWithGoogle;

    @FindBy(xpath = "//button[@id='signin_fb_btn']")
    private WebElement singInWithFacebook;

    @FindBy(xpath = "//button[@id='signin_appl_btn']")
    private WebElement singInWithApple;

    @FindBy(xpath = "//p[@id='signin-error-msg']")
    private WebElement notExistWarning;


    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isSingInWithGoogleVisible() {
        return singInWithGoogle.isDisplayed();
    }

    public boolean isSingInWithFacebookVisible() {
        return singInWithFacebook.isDisplayed();
    }

    public boolean isSingInWithAppleVisible() {
        return singInWithApple.isDisplayed();
    }

    public void enterLoginToSignInField(String login){
        emailField.sendKeys(login);
    }

    public String getNotExistWarning(){
        return notExistWarning.getText();
    }

}
