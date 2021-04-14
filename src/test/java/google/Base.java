package google;

import com.codeborne.selenide.Selenide;

public class Base {
    public String getTitle() {
        return Selenide.title();
    }
}
