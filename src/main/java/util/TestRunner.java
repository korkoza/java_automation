package util;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestRunner {
    @BeforeClass
    @Parameters("browser")
    public void configureBrowserSelenide(String browser) {
        Configuration.browser = browser;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }
}
