package rozetka;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class HomePage {
    @Step("Opened the home page")
    public HomePage open() {
        Selenide.open("https://rozetka.com.ua/ua/");
        return this;
    }

    @Step("Searched {searchTerm}")
    public SearchResult doSearch(String searchTerm) {
        $(byName("search")).sendKeys(searchTerm, Keys.ENTER);
        return Selenide.page(SearchResult.class);
    }

    @AllArgsConstructor
    @Getter
    public enum CategoriesWithPopularGoods {
        NOTEBOOKS(1), SMARTPHONES(2), GAMES(3), POBUTOVA_TEHNIKA(4),
        SANTEHNIKA(7), DACHA(8), KRASA_ZDOROVYA(11), KIDS(12),
        OFFICE_SCHOOL(13), ALCOHOL_PRODUKTY(14);

        private final int locatorNumber;
    }

    @AllArgsConstructor
    @Getter
    public enum CategoriesWithoutPopularGoods {
        TOVARY_DLYA_DOMU(5), INSTRUMENTY_AVTOTOVARY(6), SPORT(9),
        VZUTTYA_ODIAG(10), TOVARY_BIZNES(15), POSLUGY(16);
        private final int locatorNumber;
    }

    @Step("Opened {category} from side bar menu")
    public CategoryPage openCategoryFromSideBarMenu(CategoriesWithPopularGoods category) {
        $x(format("//sidebar-fat-menu//li[%s]", category.locatorNumber)).click();

        return Selenide.page(CategoryPage.class);
    }
}
