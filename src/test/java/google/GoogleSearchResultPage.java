package google;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.Selenide;
import lombok.AllArgsConstructor;
import lombok.Getter;

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
                .shouldHave(sizeGreaterThanOrEqual(10))
                .size();
    }

    public int getCurrentPageNumber() {
        return Integer.parseInt($x("//td[@class='YyVfkd']")
                .getText());
    }

    public int getResultsQuantity() {
        String resultsString = $(byId("result-stats"))
                .getText();

        resultsString = resultsString.substring(0, resultsString.indexOf("("));
        resultsString = resultsString.replaceAll("[^0-9]", "");
        return Integer.valueOf(resultsString);
    }

    public GoogleBooksPage goToBooksPage() {
        $x("//div[@id='hdtb-msb']//div[@class='GOE98c']")
                .click();
        $x("//div[@id='lb']//g-menu-item[2]")
                .click();
        return Selenide.page(GoogleBooksPage.class);
    }

    public GoogleSearchResultPage openToolsMenu() {
        $(byId("hdtb-tls"))
                .click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    @AllArgsConstructor
    @Getter
    public enum FilterOption {
        ANY_TIME(1), PAST_HOUR(2), PAST_24_HOURS(3), PAST_WEEK(4), PAST_MONTH(5), PAST_YEAR(6), CUSTOM_RANGE(7);
        private final int locatorNumber;
    }

    public GoogleSearchResultPage filterResultsByPeriod(int locatorNumber) {
        $x("//div[@id='hdtbMenus']/span[2]/g-popup")
                .click();

        $x(format("//div[@id='lb']//g-menu-item[%s]", locatorNumber))
                .shouldBe(visible)
                .click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    public String getLifetimeOfResultByPosition(int position) {
        return $x(format("//div[@class='g'][%s]//span[@class='f']", position))
                .getText();
    }

    public String getResultDescriptionByPosition(int position) {
        return $x(format("//div[@class='g'][%s]//div[@class='IsZvec']/span", position))
                .getText()
                .toLowerCase();
    }
}
