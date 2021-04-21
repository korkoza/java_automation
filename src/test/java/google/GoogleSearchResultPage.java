package google;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.Selenide;

import java.util.List;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class GoogleSearchResultPage extends BasePage {

    public List<String> getListOfResults() {
        return $$x("//div[@class='g']")
                .shouldHave(CollectionCondition.sizeGreaterThan(5))
                .texts();
    }

    public String getLinkText(int position) {
        return $x(format("//div[@class='hlcw0c']/descendant::h3[%s]", position))
                .getText();
    }

    public GoogleImagesPage goToImagesPage() {
        $x("//div[@class='hdtb-mitem'][1]/a[@class='hide-focus-ring']")
                .click();
        return Selenide.page(GoogleImagesPage.class);
    }

    public GoogleSearchResultPage goToSearchResultPage(int pageNumber) {
        $x(format("//a[@aria-label='Page %s']", pageNumber))
                .click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    public int getQuantityOfResultsOnPage() {
        return $$x("//div[@class='g']")
                .size();
    }

    public int getCurrentPageNumber() {
        return Integer.parseInt($x("//td[@class='YyVfkd']")
                .getText());
    }

    public int getResultsQuantity() {
        // locate results string which contains words, results quantity, time required to find results
        String resultsStr = $(byId("result-stats"))
                .getText();
        // truncate query duration
        resultsStr = resultsStr.substring(0, resultsStr.indexOf("("));
        // extract digits
        resultsStr = resultsStr.replaceAll("[^0-9]", "");
        // convert to integer
        return Integer.valueOf(resultsStr);
    }

    public GoogleBooksPage goToBooksPage() {
        $x("//div[@id='hdtb-msb']//div[@class='GOE98c']")
                .click();
        $x("//div[@id='lb']//g-menu-item[2]")
                .click();
        return Selenide.page(GoogleBooksPage.class);
    }

    public GoogleSearchResultPage openTools() {
        $(byId("hdtb-tls"))
                .click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    public GoogleSearchResultPage filterResultsByPeriod(String timeUnit) {
        int dropDownNumber = 0;

        switch (timeUnit) {
            case "Any time":
                dropDownNumber = 1;
                break;
            case "Past hour":
                dropDownNumber = 2;
                break;
            case "Past 24 hours":
                dropDownNumber = 3;
                break;
            case "Past week":
                dropDownNumber = 4;
                break;
            case "Past month":
                dropDownNumber = 5;
                break;
            case "Past year":
                dropDownNumber = 6;
                break;
            case "Custom range...":
                dropDownNumber = 7;
                break;
        }

        $x("//div[@id='hdtbMenus']/span[2]/g-popup")
                .click();
        $x(format("//div[@id='lb']//g-menu-item[%s]", dropDownNumber))
                .shouldBe(visible)
                .click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    public String getLifetimeOfResultByPosition(int position) {
        return $x(format("//div[@class='g'][1]//div[@class='fG8Fp uo4vr']", position))
                .getText();
    }

    public GoogleSearchResultPage goToResultsPage(int page) {
        $x(format("//a[@aria-label='Page %s']", page))
                .click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    public String getResultDescriptionByPosition(int position) {
        return $x(format("//div[@class='g'][%s]//div[@class='IsZvec']/span", position))
                .getText()
                .toLowerCase();
    }
}
