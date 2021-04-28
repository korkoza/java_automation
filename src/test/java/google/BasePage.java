package google;

import com.codeborne.selenide.Selenide;

@Deprecated
public class BasePage {
    public String getTitle() {
        return Selenide.title();
    }
}