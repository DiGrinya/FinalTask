package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//h1[@class='main-title']")
    private WebElement shoppingCartTitle;

    @FindBy(xpath = "//a[@data-test-id='start-shopping']")
        private WebElement startShoppingButton;

    @FindBy(xpath = "//a[@data-test-id='sign-in']")
    private WebElement signIn;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getShoppingCartTitle() {
        return shoppingCartTitle;
    }

    public boolean isShoppingCartTitleVisible() {
        return shoppingCartTitle.isDisplayed();
    }

    public void clickStartShoppingButton() {
        startShoppingButton.click();
    }

    public WebElement getSignInButton() {
        return signIn;
    }

}
