package laba.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import laba.carina.demo.gui.saucedemo.pages.LoginPage;
import laba.carina.demo.gui.saucedemo.pages.ProductsPage;
import org.testng.Assert;

public class LoginUtil implements IAbstractTest {

    public ProductsPage login(){
        String username = "standard_user";
        String password = "secret_sauce";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page is not opened");
        loginPage.typeUsername(username);
        loginPage.typePassword(password);

        return loginPage.clickLoginButton();
    }
}