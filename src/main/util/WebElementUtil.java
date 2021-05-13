package util;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;

public class WebElementUtil {
    public static boolean doesElementExist(SelenideElement element) {
        try {
            return element.exists();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
