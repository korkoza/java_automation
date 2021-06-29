package util;

import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestRunner {

    @Parameters("browser")
    @BeforeClass
    public void configureBrowserSelenide(String browser) {
        Configuration.browser = browser;
        Configuration.startMaximized = true;
        Configuration.timeout = 60000;
    }

    @AfterSuite
    public void printSuiteFailedTests(ITestContext context) {
        var failedTests = context.getFailedTests().getAllResults();
        System.out.println("Printing tests that failed.");
        for (ITestResult failedTest : failedTests) {
            System.out.println("Method Name: " + failedTest.getMethod().getMethodName() + "()");
        }
    }
}
