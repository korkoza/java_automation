package google;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

@Deprecated
@UtilityClass
public class WebElementUtil {
    public static void hideElement(WebElement element) {
        executeJavaScript("arguments[0].style.visibility='hidden'", element);
    }

    public static void showElement(WebElement element) {
        executeJavaScript("arguments[0].style.visibility='visible'", element);
    }
}