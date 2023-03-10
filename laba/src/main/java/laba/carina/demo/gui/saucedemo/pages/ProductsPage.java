package laba.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import laba.carina.demo.gui.saucedemo.components.ProductItem;
import laba.carina.demo.gui.saucedemo.components.TopBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends AbstractPage {
    @FindBy(xpath = "//span[@class='title'][text()='Products']")
    private ExtendedWebElement titleLabel;

    @FindBy(css = ".shopping_cart_link")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<ProductItem> products;

    @FindBy(css = ".product_sort_container")
    private ExtendedWebElement productSortContainer;

    @FindBy(xpath = "//span[@class='select_container']//option[@value='%s']")
    private ExtendedWebElement productSortContainerOption;

    @FindBy(xpath = "//div[@class='header_label']")
    private TopBarMenu topBarMenu;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(titleLabel);
    }

    public List<ProductItem> getProducts() {
        return products;
    }

    public void clickOnProductSortContainer(){
        productSortContainer.click();
    }

    public void clickOnProductSortContainerOption(String option){
        productSortContainerOption.format(option).click();
    }

    public TopBarMenu getTopBarMenu(){
        return topBarMenu;
    }
}