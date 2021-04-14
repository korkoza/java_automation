package google;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleHomePage {

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
}
