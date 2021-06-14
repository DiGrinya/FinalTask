package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedSearchPage extends BasePage {

    @FindBy(xpath = "//input[@id='_nkw']")
    private WebElement keywordField;

    @FindBy(xpath = "//input[@name='_udlo']")
    private WebElement lowerPriceField;

    @FindBy(xpath = "//input[@name='_udhi']")
    private WebElement higherPriceField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isKeywordFieldVisible() {
        return keywordField.isDisplayed();
    }

    public boolean isLowerPriceFieldVisible() {
        return lowerPriceField.isDisplayed();
    }

    public boolean isHigherPriceFieldVisible() {
        return higherPriceField.isDisplayed();
    }

    public void setKeywordField(String info){
        keywordField.sendKeys(info);
    }

    public void setLowerPriceField(String info){
        lowerPriceField.sendKeys(info);
    }

    public void setHigherPriceField(String info){
        higherPriceField.sendKeys(info);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

}
