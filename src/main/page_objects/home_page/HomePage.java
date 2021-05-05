package page_objects.home_page;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.*;


import static java.lang.String.format;

@Getter
public class HomePage {
    private Header header = new Header();
    private SideBar sideBar = new SideBar();

    @Step("Opened the home page")
    public HomePage open() {
        Selenide.open("https://rozetka.com.ua/ua/");
        return this;
    }
}
