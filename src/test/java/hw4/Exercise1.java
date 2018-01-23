package hw4;

import base.BaseSelenide;
import enums.indexPageEnums.BenefitsTextsEnum;
import enums.indexPageEnums.HeaderTextEnum;
import enums.indexPageEnums.MainTextEnum;
import enums.indexPageEnums.ServiceContentEnum;
import org.testng.annotations.Test;
import pageObjects.ServicePage;
import pageObjects.IndexPageOnSelenide;

import static com.codeborne.selenide.Selenide.*;

public class Exercise1 extends BaseSelenide{

    // 1. Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void differentElementsPageActionsTest()
    {
        // 2. Open test site by URL
        IndexPageOnSelenide page = open("https://jdi-framework.github.io/tests", IndexPageOnSelenide.class);

        // test index page
        testIndexPage(page);


        // 8. Open through the header menu Service -> Different Elements Page
        ServicePage servicePage = page.navigateToDifferentElementsPage();

        // 9. Check interface on Service page, it contains all needed elements.
        servicePage.checkInterface();

        // 10. Select and assert checkboxes



    }

    private void testIndexPage(IndexPageOnSelenide page) {
        // 3. Perform login
        page.login("epam","1234");

        // 4. Assert User name in the left-top side of screen that user is loggined
        page.checkUserName("Piter Chailovskii");

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
}
