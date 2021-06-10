package page_objects.home_page;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.*;
import page_objects.base_page.BasePage;

@Getter
public class HomePage extends BasePage {
    private SideBarCatalog sideBarCatalog = new SideBarCatalog();

    @Step("Opened the home page")
    public HomePage open() {
        Selenide.open("https://rozetka.com.ua/ua/");
        return this;
    }
}
