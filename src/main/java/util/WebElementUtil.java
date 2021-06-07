package util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class WebElementUtil {
    public static boolean doesElementExist(SelenideElement element) {
        try {
            return element.should(Condition.exist, Duration.ofMillis(100)).exists();
        } catch (AssertionError e) {
            return false;
        }
    }
}
