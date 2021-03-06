package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.elements.SelectedEnum;
import enums.servicePageEnums.CheckboxesEnum;
import enums.servicePageEnums.DropdownEnum;
import enums.servicePageEnums.RadioButtonsEnum;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DifferentElementsPage {

    // list of checkboxes in the page
    @FindBy(css = ".label-checkbox input")
    private ElementsCollection checkboxes;

    // list of radio buttons in the page
    @FindBy(css = ".label-radio input")
    private ElementsCollection radioButtons;

    // dropdown control
    @FindBy(css = ".colors .uui-form-element")
    private SelenideElement dropdownElement;

    // default button
    @FindBy(css = "[name='Default Button']")
    private SelenideElement defaultButton;

    // button
    @FindBy(css = ".main-content-hg [type='button']")
    private SelenideElement button;

    // list of logs in log panel
    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement logs;

    // left section
    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    // right section
    @FindBy(css = "#mCSB_1_container")
    private SelenideElement rightSection;

    @Step
    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests/page8.htm");
    }


    /* Check interface on Service page, it contains all needed elements.
    4 - checkboxes, 4 radios, dropdown, 2 - buttons, left section, right section.*/
    @Step
    public void checkInterface() {
        // check checkboxes
        Assert.assertEquals(checkboxes.size(), 4);
        // check radio buttons
        Assert.assertEquals(radioButtons.size(), 4);
        // check dropdown
        dropdownElement.should(visible);
        // check default button
        defaultButton.should(visible);
        // check button
        button.should(visible);

        // check left section
        leftSection.should(visible);
        // check right section
        rightSection.should(visible);
    }

    // select and assert checkboxes
    @Step
    public void selectCheckboxes(CheckboxesEnum[] checkboxesToSelect, SelectedEnum condition) {
        for (CheckboxesEnum checkbox : checkboxesToSelect) {
            SelenideElement element = checkboxes.get(checkbox.toInt());
            element.click();
            assertEquals(element.isSelected(), condition.toBoolean());
        }
    }

    // select and assert radio button
    @Step
    public void selectRadioButtons(RadioButtonsEnum radioButtonToSelect) {
        SelenideElement element = radioButtons.get(radioButtonToSelect.toInt());
        element.click();
        assertTrue(element.isSelected());
    }

    // select element in dropdown
    @Step
    public void selectDropdownItem(DropdownEnum item) {
        dropdownElement.selectOption(item.toString());
        assertEquals(dropdownElement.getSelectedText(), item.toString());
    }

    // check log for checkbox, radio and dropdown actions
    @Step
    public void checkLogs(String[] items, SelectedEnum condition) {

        // create regex pattern to get item name
        Pattern itemPattern = Pattern.compile("(?<= ).*?(?=:)");
        // create regex pattern to get item condition
        Pattern conditionPattern = Pattern.compile("(?<=to ).*$");
        // get logs records
        ElementsCollection logRecords = logs.$$("li");

        for (String item : items) {
            // search item with condition
            // if item not found NoSuchElementException will thrown, test failed
            // else all is ok
            try {
                logRecords.stream().filter(validateLog(condition, itemPattern, conditionPattern, item)).findFirst().get();
            } catch (NoSuchElementException e) {
                System.out.println(item);
            }

        }
    }

    // validate log with item and item condition
    private Predicate<SelenideElement> validateLog(SelectedEnum condition, Pattern itemPattern, Pattern conditionPattern, String item) {
        return (log) -> {
            // find item name or item type (before ':' character)
            Matcher itemMatcher = itemPattern.matcher(log.getText());
            itemMatcher.find();

            // find item name or item condition (after word 'to')
            Matcher conditionMatcher = conditionPattern.matcher(log.getText());
            conditionMatcher.find();

            // if item name found check condition
            if (itemMatcher.group().equals(item)) {
                return Boolean.parseBoolean(conditionMatcher.group()) == condition.toBoolean();
            } else {
                // founded item type, check item name
                return item.equals(conditionMatcher.group());
            }
        };
    }


}

