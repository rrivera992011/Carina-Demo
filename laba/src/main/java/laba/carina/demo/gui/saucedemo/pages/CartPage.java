package laba.carina.demo.gui.saucedemo.pages;

import com.amazonaws.event.DeliveryMode;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//span[@class='title'][text()='Your Cart']")
    private ExtendedWebElement titleLabel;

    @FindBy(xpath = "//div[@class='inventory_item_name'][text()='%s']")
    private ExtendedWebElement productTitle;

    @FindBy(css = ".btn_action")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(titleLabel);
    }

    public boolean isProductDisplayed(String productName){
        return productTitle.format(productName).isElementPresent();
    }

    public CheckoutPage clickCheckoutButton(){
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}