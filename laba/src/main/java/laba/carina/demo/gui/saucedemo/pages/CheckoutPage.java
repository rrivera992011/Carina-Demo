package laba.carina.demo.gui.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(css = ".checkout_buttons .btn_primary")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//input[@id='first-name']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//input[@id='postal-code']")
    private ExtendedWebElement postalCodeField;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(continueButton);
    }

    public void typeFirstName(String firstName){
        firstNameField.type(firstName);
    }

    public void typeLastName(String lastName){
        lastNameField.type(lastName);
    }

    public void typePostalCode(String postalCode){
        postalCodeField.type(postalCode);
    }

    public OverviewPage clickContinueButton(){
        continueButton.click();
        return new OverviewPage(driver);
    }
}