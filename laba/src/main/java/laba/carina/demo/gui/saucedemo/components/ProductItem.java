package main.java.laba.carina.demo.gui.saucedemo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {
    @FindBy(xpath = ".//div[@class='inventory_item_name']")
    private ExtendedWebElement productTitleLabel;

    @FindBy(xpath = ".//button[contains(@id, 'add-to-cart')]")
    private ExtendedWebElement addToCartButton;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getProductTitle(){
        return productTitleLabel.getText();
    }
}