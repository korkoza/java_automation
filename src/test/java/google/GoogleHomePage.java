package google;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleHomePage extends BasePage {
    public GoogleHomePage open() {
        Selenide.open("https://www.google.com/");
        return this;
    }

    public GoogleSearchResultPage doSearch(String searchTerm) {
        $(By.name("q")).sendKeys(searchTerm, Keys.ENTER);

        return Selenide.page(GoogleSearchResultPage.class);
    }

    public GoogleHomePage switchLanguage(String lang) {
        $x(format("//div[@id='SIvCob']/a[contains(text(),'%s')]", lang))
                .click();

        return this;
    }

    public String getSearchButtonText() {
        return $(By.name("btnK")).getValue();
    }

    public String getFeelLuckyButtonText() {
        return $(By.name("btnI")).getValue();
    }

    public GoogleHomePage setTextToSearch(String searchTerm) {
        $(By.name("q")).sendKeys(searchTerm);
        return Selenide.page(GoogleHomePage.class);
    }

    public GoogleSearchResultPage iAmFeelingLucky() {
        $(By.name("btnI")).click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    public WebElement getLogo() {
        return $x("//img[@class='lnXdpd']");
    }
}
