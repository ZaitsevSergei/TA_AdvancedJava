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
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPage;
import pageObjects.IndexPageOnSelenide;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Listeners(AllureAttachmentListener.class)
@Features({"TestCase1"})
@Stories({"Different Elements Page Test"})
public class DifferentElementsPageTest extends BaseSelenide {

    IndexPageOnSelenide indexPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpTest(){
        // 2. Open test site by URL
        indexPage = new IndexPageOnSelenide();
    }


    // 1. Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void differentElementsPageActionsTest() {

        // 3. Perform login
        indexPage.login(UserEnum.PITER_CHAILOVSKII);

        // 4. Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserName(UserEnum.PITER_CHAILOVSKII);

        // 5. Check interface on Home page, it contains all needed elements.
        // check image count
        indexPage.checkBenefitsIconsCount(4);
        // check benefits texts
        indexPage.checkBenefitsTexts(BenefitsTextsEnum.values());
        // check header text
        indexPage.checkHeader(HeaderTextEnum.TEXT1);
        // check main text
        indexPage.checkMainText(MainTextEnum.TEXT1);

        // 6. Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkHeaderServiceContent(ServiceContentEnum.values());

        // 7. Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkSideMenuServiceContent(ServiceContentEnum.values());

        // 8. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage dEPage = indexPage.navigateToDifferentElementsPage();

        // 9. Check interface on Service page, it contains all needed elements.
        dEPage.checkInterface();

        // 10. Select and assert checkboxes
        dEPage.selectCheckboxes(new CheckboxesEnum[]{CheckboxesEnum.WATER, CheckboxesEnum.WIND}, SelectedEnum.SELECTED);

        // 11. Select radio
        dEPage.selectRadioButtons(RadioButtonsEnum.SELEN);

        // 12.Select in dropdown Yellow
        dEPage.selectDropdownItem(DropdownEnum.YELLOW);

        // 13. Check in logs section selected values and status (true|false)
        dEPage.checkLogs(new String[]{CheckboxesEnum.WATER.toString(), CheckboxesEnum.WIND.toString(),
                RadioButtonsEnum.SELEN.toString(), DropdownEnum.YELLOW.toString()}, SelectedEnum.SELECTED);

        // 14. Unselect and assert checkboxes
        dEPage.selectCheckboxes(new CheckboxesEnum[]{CheckboxesEnum.WATER, CheckboxesEnum.WIND}, SelectedEnum.UNSELECTED);

        // 15. Check in logs section unselected values and status (true|false)
        dEPage.checkLogs(new String[]{CheckboxesEnum.WATER.toString(), CheckboxesEnum.WIND.toString()},
                SelectedEnum.UNSELECTED);
    }
}
