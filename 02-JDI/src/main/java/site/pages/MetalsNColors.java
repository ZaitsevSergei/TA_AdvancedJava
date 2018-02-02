package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalsNColors extends WebPage {
    @JFindBy(css = "")
    private RadioButtons summaryRadioButtons;

}
