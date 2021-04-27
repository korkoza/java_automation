package google;

import com.codeborne.selenide.Selenide;

public class BasePage {
    public String getTitle() {
        return Selenide.title();
    }
}