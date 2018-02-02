package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import entities.User;

public class LoginForm extends Form<User> {
    @JFindBy(css = "#Login")
    public TextField login;

    @JFindBy(css = "#Password")
    public TextField password;

    @JFindBy(css = "[type=submit]")
    public Button submit;
}
