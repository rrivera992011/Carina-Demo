package laba.carina.demo;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;
import laba.carina.demo.gui.saucedemo.components.HamburgerMenu;
import laba.carina.demo.gui.saucedemo.components.ProductItem;
import laba.carina.demo.gui.saucedemo.components.TopBarMenu;
import laba.carina.demo.gui.saucedemo.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoTest extends SauceDemoAbstractTest {

    @Test()
    @MethodOwner(owner = "Rafael")
    @TestPriority(Priority.P0)
    public void testProductAddedToCart() {
        String username = R.TESTDATA.get("standard_username");
        String password = R.TESTDATA.get("standard_password");

        String productName = "Sauce Labs Backpack";
        ProductsPage productsPage = loginUtil.login(username, password);
        Assert.assertTrue(productsPage.isPageOpened(),"Products page is not opened");
        List<ProductItem> products = productsPage.getProducts();

        for(ProductItem productItem: products){
            if(productName.equals(productItem.getProductTitle())){
                productItem.clickAddToCartButton();
            }
        }

        TopBarMenu topBarMenu = productsPage.getTopBarMenu();
        CartPage cartPage = topBarMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertTrue(cartPage.isProductDisplayed(productName), "Product '" + productName + "' is not displayed");
    }

    @Test()
    @MethodOwner(owner = "Rafael")
    @TestPriority(Priority.P0)
    public void testAddToCartAndCheckout() {
        String username = R.TESTDATA.get("standard_username");
        String password = R.TESTDATA.get("standard_password");
        String productName = "Sauce Labs Backpack";
        String firstName = "Apple";
        String lastName = "Jack";
        String postalCode = "23456";

        ProductsPage productsPage = loginUtil.login(username, password);
        Assert.assertTrue(productsPage.isPageOpened(),"Products page is not opened");
        List<ProductItem> products = productsPage.getProducts();

        for(ProductItem productItem: products){
            if(productName.equals(productItem.getProductTitle())){
                productItem.clickAddToCartButton();
            }
        }

        TopBarMenu topBarMenu = productsPage.getTopBarMenu();
        CartPage cartPage = topBarMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertTrue(cartPage.isProductDisplayed(productName), "Product '" + productName + "' is not displayed");

        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.isPageOpened(), "Checkout page is not opened");
        checkoutPage.typeFirstName(firstName);
        checkoutPage.typeLastName(lastName);
        checkoutPage.typePostalCode(postalCode);

        OverviewPage overviewPage = checkoutPage.clickContinueButton();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");

        CompletionPage completionPage = overviewPage.clickFinishButton();
        Assert.assertTrue(completionPage.isPageOpened(), "Completion page is not opened");
    }

    @Test()
    @MethodOwner(owner = "Rafael")
    @TestPriority(Priority.P0)
    public void testClickOnAboutPage(){
        String username = R.TESTDATA.get("standard_username");
        String password = R.TESTDATA.get("standard_password");

        ProductsPage productsPage = loginUtil.login(username, password);
        Assert.assertTrue(productsPage.isPageOpened(),"Products page is not opened");

        TopBarMenu topBarMenu = productsPage.getTopBarMenu();
        HamburgerMenu hamburgerMenu = topBarMenu.clickOnHamburgerMenuButton();
        AboutPage aboutPage = hamburgerMenu.clickOnFindAboutLink();

        Assert.assertTrue(aboutPage.isPageOpened(),"About page is not opened");
    }

    @Test()
    @MethodOwner(owner = "Rafael")
    @TestPriority(Priority.P0)
    public void testSortProductsAndAddToCart(){
        String username = R.TESTDATA.get("standard_username");
        String password = R.TESTDATA.get("standard_password");
        String productOrderOption = "za";
        String productName = "Sauce Labs Onesie";

        ProductsPage productsPage = loginUtil.login(username, password);
        Assert.assertTrue(productsPage.isPageOpened(),"Products page is not opened");

        productsPage.clickOnProductSortContainer();
        productsPage.clickOnProductSortContainerOption(productOrderOption);

        List<ProductItem> products = productsPage.getProducts();

        for(ProductItem productItem: products){
            if(productName.equals(productItem.getProductTitle())){
                productItem.clickAddToCartButton();
            }
        }

        TopBarMenu topBarMenu = productsPage.getTopBarMenu();
        CartPage cartPage = topBarMenu.clickOnCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertTrue(cartPage.isProductDisplayed(productName), "Product '" + productName +
                "' is not displayed");
    }

    @Test()
    @MethodOwner(owner = "Rafael")
    @TestPriority(Priority.P0)
    public void testLogOutFromProductsPage(){
        String username = R.TESTDATA.get("standard_username");
        String password = R.TESTDATA.get("standard_password");

        ProductsPage productsPage = loginUtil.login(username, password);
        Assert.assertTrue(productsPage.isPageOpened(),"Products page is not opened");

        TopBarMenu topBarMenu = productsPage.getTopBarMenu();
        HamburgerMenu hamburgerMenu = topBarMenu.clickOnHamburgerMenuButton();
        LoginPage loginPage = hamburgerMenu.clickOnLogoutLink();

        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
    }
}