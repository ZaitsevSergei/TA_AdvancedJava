package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;

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

    /* Check interface on Service page, it contains all needed elements.
    4 - checkboxes, 4 radios, dropdown, 2 - buttons, left section, right section.*/
    public void checkInterface()
    {
        // check checkboxes
        Assert.assertEquals(checkBoxes.size(), 4);
        // check radio buttons
        Assert.assertEquals(radioButtons.size(), 4);
        // check dropdown
        dropdownElement.should(visible);
        // check default button
        defaultButton.should(visible);
        // check button
        button.should(visible);
    }
}
