package hw4;

import base.BaseSelenide;
import enums.elements.SelectedEnum;
import enums.elements.UserEnum;
import enums.indexPageEnums.BenefitsTextsEnum;
import enums.indexPageEnums.HeaderTextEnum;
import enums.indexPageEnums.MainTextEnum;
import enums.indexPageEnums.ServiceContentEnum;
import enums.servicePageEnums.CheckboxesEnum;
import enums.servicePageEnums.DropdownEnum;
import enums.servicePageEnums.RadioButtonsEnum;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPage;
import pageObjects.IndexPageOnSelenide;

import static com.codeborne.selenide.Selenide.open;

public class TestCase1 extends BaseSelenide {

    // 1. Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void differentElementsPageActionsTest() {
        // 2. Open test site by URL
        IndexPageOnSelenide page = open("https://jdi-framework.github.io/tests", IndexPageOnSelenide.class);

        // test index page
        testIndexPage(page);

        // 8. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage dEPage = page.navigateToDifferentElementsPage();

        // test Different elements page
        testDifferentElementsPage(dEPage);
    }

    //  test index page
    private void testIndexPage(IndexPageOnSelenide page) {
        // 3. Perform login
        page.login(UserEnum.PITER_CHAILOVSKII);

        // 4. Assert User name in the left-top side of screen that user is loggined
        page.checkUserName(UserEnum.PITER_CHAILOVSKII);

        // 5. Check interface on Home page, it contains all needed elements.
        // check image count
        page.checkBenefitsIconsCount(4);
        // check benefits texts
        page.checkBenefitsTexts(BenefitsTextsEnum.values());
        // check header text
        page.checkHeader(HeaderTextEnum.TEXT1.toString());
        // check main text
        page.checkMainText(MainTextEnum.TEXT1.toString());

        // 6. Click on "Service" subcategory in the header and check that drop down contains options
        page.checkHeaderServiceContent(ServiceContentEnum.values());

        // 7. Click on Service subcategory in the left section and check that drop down contains options
        page.checkSideMenuServiceContent(ServiceContentEnum.values());
    }

    // test Different elements page
    private void testDifferentElementsPage(DifferentElementsPage page) {
        // 9. Check interface on Service page, it contains all needed elements.
        page.checkInterface();

        // 10. Select and assert checkboxes
        page.selectCheckboxes(new CheckboxesEnum[]{CheckboxesEnum.WATER, CheckboxesEnum.WIND}, SelectedEnum.SELECTED);

        // 11. Select radio
        page.selectRadioButtons(RadioButtonsEnum.SELEN);

        // 12.Select in dropdown Yellow
        page.selectDropdownItem(DropdownEnum.YELLOW);

        // 13. Check in logs section selected values and status (true|false)
        page.checkLogs(new String[]{CheckboxesEnum.WATER.toString(), CheckboxesEnum.WIND.toString(),
                RadioButtonsEnum.SELEN.toString(), DropdownEnum.YELLOW.toString()}, SelectedEnum.SELECTED);

        // 14. Unselect and assert checkboxes
        page.selectCheckboxes(new CheckboxesEnum[]{CheckboxesEnum.WATER, CheckboxesEnum.WIND}, SelectedEnum.UNSELECTED);

        // 15. Check in logs section unselected values and status (true|false)
        page.checkLogs(new String[]{CheckboxesEnum.WATER.toString(), CheckboxesEnum.WIND.toString()},
                SelectedEnum.UNSELECTED);
    }
}
