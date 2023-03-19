package laba.carina.demo.gui.saucedemo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import laba.carina.demo.gui.saucedemo.pages.AboutPage;
import laba.carina.demo.gui.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenu extends AbstractUIObject {

    @FindBy(xpath = "//a[@id='about_sidebar_link']")
    private ExtendedWebElement aboutLink;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private ExtendedWebElement logoutLink;

    public HamburgerMenu(WebDriver driver) {
        super(driver);
    }

    public AboutPage clickOnFindAboutLink(){
        aboutLink.click();
        return new AboutPage(driver);
    }

    public LoginPage clickOnLogoutLink(){
        logoutLink.click();
        return new LoginPage(driver);
    }
}