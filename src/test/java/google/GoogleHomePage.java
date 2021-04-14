package google;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleHomePage extends Base {

    public GoogleHomePage open() {
        Selenide.open("https://www.google.com/");
        return this;
    }

    public GoogleSearchResultPage doSearch(String searchTerm) {
        $(By.name("q")).sendKeys(searchTerm, Keys.ENTER);

        return Selenide.page(GoogleSearchResultPage.class);
    }

    public String getTitle() {
        return Selenide.title();
    }

    public GoogleHomePage switchLanguage(String lang) {
        $x(String.format("//div[@id='SIvCob']/a[contains(text(),'%s')]", lang))
                .click();

        return this;
    }

    public String getSearchButtonText() {
        return $(By.name("btnK")).getValue();
    }

    public String getFeelLuckyButtonText() {
        return $(By.name("btnI")).getValue();
    }

    public GoogleHomePage typeTextToSearchField(String searchTerm) {
        $(By.name("q")).sendKeys(searchTerm);
        return Selenide.page(GoogleHomePage.class);
    }

    public GoogleSearchResultPage iAmFeelingLucky() {
        $(By.name("btnI")).click();
        return Selenide.page(GoogleSearchResultPage.class);
    }
}
