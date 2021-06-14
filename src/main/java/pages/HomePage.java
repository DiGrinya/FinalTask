package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='gh-menu']//a[contains(@href,'cart.payments')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//span[@id='gh-ug']//a[contains(@href,'signin.ebay')]")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='gh-ug']//a[contains(@href,'reg.ebay')]")
    private WebElement registerButton;

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@title='Advanced Search']")
    private WebElement advancedSearchButton;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='gf-flags-wpr']//a[@role='button']")
    private WebElement languageButton;

    @FindBy(xpath = "//div[@id='gf-f']//a[contains(@href,'ru')]")
    private WebElement russianLanguageButton;




    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isCartIconVisible() {
        cartIcon.isDisplayed();
    }

    public void isSignInButtonVisible() {
        signInButton.isDisplayed();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void isRegisterButtonVisible() {
        registerButton.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void clickCartButton() {
        cartIcon.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickLanguageButton() {
        languageButton.click();
    }

    public void clickRussianLanguageButton() {
        russianLanguageButton.click();
    }

    public String getCurrentSiteLanguage(){
        return languageButton.getText();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickAdvancedSearchButton() {
        advancedSearchButton.click();
    }


}
