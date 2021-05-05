package page_objects.home_page;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import page_objects.ProductSearchResultPage;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class Header {
    @Step("Searched {searchTerm}")
    public ProductSearchResultPage doSearch(String searchTerm) {
        $(byName("search")).sendKeys(searchTerm, Keys.ENTER);
        return Selenide.page(ProductSearchResultPage.class);
    }
}
