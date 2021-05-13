package util;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class TestRunner {
    @BeforeClass
    public void configureBrowserSelenide() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }
}
