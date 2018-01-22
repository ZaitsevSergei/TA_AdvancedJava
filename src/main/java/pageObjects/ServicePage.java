package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class ServicePage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioButtons;

    @FindBy(css = ".colors .uui-form-element")
    private SelenideElement dropdownElement;

    @FindBy(css = "[name='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = ".main-content-hg [type='button']")
    private SelenideElement button;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection logs;

    public void checkInterface()
    {
        // check checkboxes
        Assert.assertNotEquals(checkBoxes.size(), 0);
        // check radio buttons
        Assert.assertNotEquals(radioButtons.size(), 0);
        // check dropdown
        dropdownElement.should(visible);
        // check default button
        defaultButton.should(visible);
        // check button
        button.should(visible);


    }
}
