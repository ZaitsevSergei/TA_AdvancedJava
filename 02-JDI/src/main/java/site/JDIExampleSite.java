package site;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.User;
import ru.yandex.qatools.allure.annotations.Step;
import site.pages.HomePage;
import site.sections.LoginForm;

@JSite("https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {
    public static HomePage homePage;

    public static LoginForm loginForm;

    @JFindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step
    public static void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
    }
}
