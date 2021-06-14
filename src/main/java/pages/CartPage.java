package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//button[@class='call-to-action btn btn--large btn--primary']")
    private WebElement checkOutButton;

    @FindBy(xpath = "//div[@class='listsummary-content']//h3")
    private WebElement nameOfProduct;



    @FindBy(xpath = "//button[contains(@aria-label,'Remove')]")
    private WebElement removeProductFromCart;

    @FindBy(xpath = "//div[@class='font-title-3']")
    private WebElement emptyCartMessage;

    public WebElement getRemoveProductFromCart() {
        return removeProductFromCart;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfProduct(){
        return nameOfProduct.getText();
    }

    public void clickRemoveProductFromCart(){
        removeProductFromCart.click();
    }

    public String getEmptyCartMessage(){
        return emptyCartMessage.getText();
    }

    public WebElement getEmptyCartMessageElement(){
        return emptyCartMessage;
    }

}
