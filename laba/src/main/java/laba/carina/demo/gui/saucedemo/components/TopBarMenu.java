package laba.carina.demo.gui.saucedemo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import laba.carina.demo.gui.saucedemo.pages.CartPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopBarMenu extends AbstractUIObject {

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement hamburgerMenuButton;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private ExtendedWebElement cartButton;

    public TopBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HamburgerMenu clickOnHamburgerMenuButton(){
        hamburgerMenuButton.click();
        return new HamburgerMenu(driver);
    }

    public CartPage clickOnCartButton(){
        cartButton.click();
        return new CartPage(driver);
    }
}