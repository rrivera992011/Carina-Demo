package laba.carina.demo.utils;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import laba.carina.demo.gui.saucedemo.pages.LoginPage;
import laba.carina.demo.gui.saucedemo.pages.ProductsPage;
import org.testng.Assert;

public class LoginUtil implements ICustomTypePageFactory {

    public ProductsPage login(String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page is not opened");
        loginPage.typeUsername(username);
        loginPage.typePassword(password);

        return loginPage.clickLoginButton();
    }
}