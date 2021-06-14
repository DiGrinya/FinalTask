package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//span[@id='qtySubTxt']//span")
    private WebElement quantityOfAvailableProduct;

    @FindBy(xpath = "//input[@id='qtyTextBox']")
    private WebElement quantityProductField;

    @FindBy(xpath = "//div[@id='w1-15-_errMsg']")
    private WebElement changeTheQuantityMessage;

    @FindBy(xpath = "//div[@id='atc-area']//a")
    private WebElement addToCartButton;


    @FindBy(xpath = "//a[@id='binBtn_btn']")
    private WebElement buyItNowButton;

    @FindBy(xpath = "//button[@id='sbin-gxo-btn']")
    private WebElement checkAsGuestButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getQuantityOfAvailableProduct(){
        return quantityOfAvailableProduct.getText();
    }

    public void setQuantityOfProduct(final String quantity){
        quantityProductField.sendKeys(quantity);
    }

    public WebElement getQuantityProductField() {
        return quantityProductField;
    }

    public String getChangeTheQuantityMessage() {
        return changeTheQuantityMessage.getText();
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public WebElement isAddToCartButtonVisible(){
        return addToCartButton;
    }

    public void clickBuyItNowButton(){
        buyItNowButton.click();
    }

    public WebElement getBuyItNowButton() {
        return buyItNowButton;
    }

    public WebElement getCheckAsGuestButton() {
        return checkAsGuestButton;
    }

    public void clickCheckAsGuestButton(){
        checkAsGuestButton.click();
    }
}
