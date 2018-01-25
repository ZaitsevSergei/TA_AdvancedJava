package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class BaseSelenide {

    @BeforeSuite
    public void setUpSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        Configuration.timeout = 6000;
        Configuration.pollingInterval = 1000;
        Configuration.collectionsPollingInterval = 1000;
    }
}
