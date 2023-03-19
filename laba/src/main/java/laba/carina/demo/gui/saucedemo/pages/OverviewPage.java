package laba.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends AbstractPage {

    @FindBy(css = ".btn_action")
    private ExtendedWebElement finishButton;
    public OverviewPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(finishButton);
    }

    public CompletionPage clickFinishButton(){
        finishButton.click();
        return new CompletionPage(driver);
    }
}