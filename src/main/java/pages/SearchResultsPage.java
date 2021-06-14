package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//h1//span[contains(text(),'1')][1]")
    private WebElement searchProductCount ;

    @FindBy(xpath = "//div[@id='ResultSetItems']//li[contains(@id,'item')]")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//div[@class='s-item__image-wrapper']//img")
    private WebElement searchingProduct;

    @FindBy(xpath = "//input[@class='gh-tb ui-autocomplete-input']")
    private WebElement inputField;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductCount() {
        return searchProductCount.getText();
    }

    public int getAdvancedProductSearchCount(){
        return searchResultList.size();
    }

    public WebElement getSearchingProduct() {
        return searchingProduct;
    }

    public void clickOnSearchingProduct(){
        searchingProduct.click();
    }

    public void clickInputField(){
        inputField.click();
    }

}
