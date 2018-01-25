package hw3;

import base.TestBase;
import enums.elements.UserEnum;
import enums.indexPageEnums.HeaderTextEnum;
import enums.indexPageEnums.MainTextEnum;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.IndexPage;

public class Exercise2 extends TestBase {

    @Test
    public void testLoginAction() {
        // create page instance
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

        // navigate to page
        indexPage.open();

        // 3. Assert Browser title
        indexPage.checkTitle("Index Page");

        // 4. Perform login
        indexPage.login(UserEnum.PITER_CHAILOVSKII);

        // 5. Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserName(UserEnum.PITER_CHAILOVSKII);

        // 6. Assert Browser title
        indexPage.checkTitle("Index Page");

        // 7. Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkBenefitsIconsCount(4);

        // 8. Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkBenefitsTexts();

        // 9. Assert that there are the main header and the text below it on the Home Page
        indexPage.checkHeader(HeaderTextEnum.TEXT1.toString());
        indexPage.checkMainText(MainTextEnum.TEXT1.toString());

    }
}
