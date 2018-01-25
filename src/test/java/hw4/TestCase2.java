package hw4;

import base.BaseSelenide;
import enums.datesEnums.SlidersPosition;
import enums.elements.LoginEnum;
import enums.elements.UserName;
import org.testng.annotations.Test;
import pageObjects.DatesPage;
import pageObjects.IndexPageOnSelenide;

import static com.codeborne.selenide.Selenide.open;

public class TestCase2 extends BaseSelenide {

    // 1. Create a new test in a new Java class, specify test name accordingly checking functionality
    @Test
    public void DatesPageSlidersActionTest() {
        // 2. Open test site by URL
        IndexPageOnSelenide page = open("https://jdi-framework.github.io/tests", IndexPageOnSelenide.class);

        // 3. Perform login
        page.login(LoginEnum.EPAM);

        // 4. Assert User name in the left-top side of screen that user is loggined
        page.checkUserName(UserName.PITER_CHAILOVSKII);

        // 5. Open Service -> Dates
        DatesPage datesPage = page.navigateToDatesPage();
        datesPage.setSlidersPosition(SlidersPosition.CUSTOM1);
    }
}
