package google;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebElementUtils {
    public static JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();

    public static void hideElement(WebElement element) {
        js.executeScript("arguments[0].style.visibility='hidden'", element);
    }

    public static void showElement(WebElement element) {
        js.executeScript("arguments[0].style.visibility='visible'", element);
    }
}