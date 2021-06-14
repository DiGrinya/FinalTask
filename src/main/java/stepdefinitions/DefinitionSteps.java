package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 30;
    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    SigninPage signinPage;
    RegistrationPage registrationPage;
    AdvancedSearchPage advancedSearchPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() throws InterruptedException {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        Thread.sleep(100);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User checks cart visibility")
    public void checkCartVisibility() {
        homePage.isCartIconVisible();
    }


    @And("User checks register button visibility")
    public void checkRegisterButtonVisibility() {
        homePage.isRegisterButtonVisible();
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @When("User clicks 'Sign In' button")
    public void clickSignInButton() {
        homePage.clickSignInButton();
    }


    @And("User checks email field visibility on sign page")
    public void checkEmailFieldVisibility(){
        signinPage = pageFactoryManager.getSigninPage();
        signinPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signinPage.getEmailField());
        signinPage.isEmailFieldVisible();
    }

    @And("User checks another sign in options visibility")
    public void checkAnotherSignInOptionsVisibility(){
        signinPage.isSingInWithGoogleVisible();
        signinPage.isSingInWithFacebookVisible();
        signinPage.isSingInWithAppleVisible();
    }

    @And("User checks sing in with {string} option")
    public void checkSingInOption(final String loginOption){
        signinPage.isEmailFieldVisible();
        signinPage.enterLoginToSignInField(loginOption);
        signinPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }


    @And("User opens shopping cart")
    public void openShoppingCart() {
        homePage.clickCartButton();
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartTitle());
    }

    @And("User checks that shopping cart title visible")
    public void checkShoppingCartTitleVisibility() {
        assertTrue(shoppingCartPage.isShoppingCartTitleVisible());
    }

    @And("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User checks that amount of products in search results are {string}")
    public void checkSearchResult(final String expectedAmount) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(searchResultsPage.getProductCount(), expectedAmount);
    }

    @After
    public void tearDown() {
        driver.close();
    }


    @When("User clicks on language button and switch the language")
    public void userClicksOnLanguageButtonAndSwitchTheLanguage() {
        homePage.clickLanguageButton();
        homePage.clickRussianLanguageButton();
    }

    @Then("User checks location according to {string} language")
    public void userChecksLocationAccordingToLanguage(final String url) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(url));
    }


    @Then("User checks that warning is appear")
    public void userChecksThatWarningAppears() {
        signinPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signinPage.getNotExistWarning());
        assertEquals(signinPage.getNotExistWarning().getText(), "Oops, that's not a match.");
    }


    @And("User checks current website language is {string}")
    public void userChecksCurrentWebsiteLanguage(final String language) {
        assertEquals(homePage.getCurrentSiteLanguage(), language);
    }

    @And("User clicks to register button")
    public void userClicksToRegisterButton() {
        homePage.clickRegisterButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @When("User checks register option with {string} option")
    public void userChecksRegisterOptionWithInfoOption(final String info) {
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.isLastNameFieldVisible();
        registrationPage.isNameFieldVisible();

        registrationPage.setNameField(info);
        registrationPage.setLastNameField(info);
    }


    @And("User check register option with {string} and {string}")
    public void userCheckRegisterOptionWithEmailAndPassword(final String email, final String password)  {
        registrationPage.isEmailFieldVisible();
        registrationPage.isPasswordFieldVisible();

        registrationPage.setEmailField(email);
        registrationPage.setPasswordField(password);
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.isMessageWarningVisible());
    }

    @Then("User checks check the warning message")
    public void userChecksClickRegisterAndCheckMessageWarning() {
        assertEquals(registrationPage.getMessageWarning(), "Please enter a password that's less like your email address.");
    }

    @And("User clicks advanced search button")
    public void userClicksAdvancedSearchButton() {
        homePage.clickAdvancedSearchButton();
    }

    @When("User enters {string} with {string} and {string} price")
    public void userEntersKeywordWithLowerPriceAndHigherPricePrice(final String keyword, final String lowerPrice, final String higherPrice) {
        advancedSearchPage = pageFactoryManager.getAdvancedSearchPage();
        advancedSearchPage.isKeywordFieldVisible();
        advancedSearchPage.isLowerPriceFieldVisible();
        advancedSearchPage.isHigherPriceFieldVisible();

        advancedSearchPage.setKeywordField(keyword);
        advancedSearchPage.setLowerPriceField(lowerPrice);
        advancedSearchPage.setHigherPriceField(higherPrice);
        advancedSearchPage.clickSearchButton();
    }

    @Then("User check that list of product match")
    public void userCheckThatListOfProductEqualsToCount() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertEquals(searchResultsPage.getAdvancedProductSearchCount(), 42);
    }

    @And("User clicks on product in question")
    public void userClicksOnProductInQuestion() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,searchResultsPage.getSearchingProduct());
        searchResultsPage.clickInputField();
        searchResultsPage.clickOnSearchingProduct();
    }

    @When("User change the quantity with bigger {string}")
    public void userChangeTheQuantityWithBiggerValue(final String quantity) {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getQuantityProductField());
        productPage.setQuantityOfProduct(quantity);
    }

    @Then("User gets the change quantity message")
    public void userGetsTheChangeQuantityMessage() {
        productPage = pageFactoryManager.getProductPage();
        //productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getChangeTheQuantityMessage());
        assertEquals(productPage.getChangeTheQuantityMessage(), "Please enter a quantity of 3 or less");
    }

    @When("User clicks add product to cart")
    public void userClicksAddProductToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.isAddToCartButtonVisible());
        productPage.clickAddToCartButton();
    }

    @Then("User checks that mentioned {string} placed in cart")
    public void userChecksThatMentionedProductPlacedInCart(final String product) {
        cartPage = pageFactoryManager.getCartPage();
        assertTrue(cartPage.getNameOfProduct().contains(product));
    }

    @When("User remove product from cart")
    public void userRemoveProductFromCart() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,cartPage.getRemoveProductFromCart() );
        cartPage.clickRemoveProductFromCart();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,cartPage.getEmptyCartMessageElement() );
    }


    @Then("User checks that cart is empty")
    public void userChecksThatCartIsEmpty() {
        assertEquals(cartPage.getEmptyCartMessage(), "You don't have any items in your cart.");
    }

    @When("User clicks on buy it now")
    public void userClicksOnBuyItNow() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getBuyItNowButton());
        productPage.clickBuyItNowButton();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getCheckAsGuestButton());
        productPage.clickCheckAsGuestButton();
    }

    @Then("User clicks that he was redirected to {string} page")
    public void userClicksThatHeWasRedirectedToCheckoutPage(final String url) {
        assertTrue(driver.getCurrentUrl().contains(url));
    }

    @When("User clicks on Done button without filling required fields")
    public void userClicksOnDoneButtonWithoutFillingRequiredFields() {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,checkoutPage.getDoneButton());
        checkoutPage.clickDoneButton();
        checkoutPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, checkoutPage.getEmptyFieldMessage());
    }

    @Then("User checks that empty field {string} appear")
    public void userChecksThatEmptyFieldErrorAppear(final String error) {
        assertEquals(checkoutPage.getEmptyFieldMessageText(), error);
    }
}
