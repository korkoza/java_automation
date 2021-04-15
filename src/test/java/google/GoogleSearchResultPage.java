package google;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleSearchResultPage extends BasePage {

    public List<String> getListOfResults() {
        return $$x("//div[@class='g']")
                .shouldHave(CollectionCondition.sizeGreaterThan(5))
                .texts();
    }

    public String getLinkText(int position) {
        return $x(String.format("//div[@class='hlcw0c']/descendant::h3[%s]",position))
                .getText();
    }

    public GoogleImagesPage goToImagesPage() {
        $x("//div[@class='hdtb-mitem'][1]/a[@class='hide-focus-ring']")
                .click();
        return Selenide.page(GoogleImagesPage.class);
    }

    public GoogleSearchResultPage goToSearchResultPage(int pageNumber) {
        $x(String.format("//a[@aria-label='Page %s']", pageNumber))
            .click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    public int getQuantityOfResultsOnPage() {
        return $$x("//div[@class='g']").size();
    }

    public int getCurrentPageNumber() {
        return Integer.parseInt($x("//td[@class='YyVfkd']").getText());
    }
}
