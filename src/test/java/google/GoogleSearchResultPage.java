package google;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
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

    @Step("Opened Images page")
    public GoogleImagesPage goToImagesPage() {
        $x("//div[@class='hdtb-mitem'][1]/a[@class='hide-focus-ring']")
                .click();
        return Selenide.page(GoogleImagesPage.class);
    }

    @Step("Opened results page #{pageNumber}")
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

    @Step("Opened Books page")
    public GoogleBooksPage goToBooksPage() {
        $x("//div[@id='hdtb-msb']//div[@class='GOE98c']")
                .click();
        $x("//div[@id='lb']//g-menu-item[2]")
                .click();
        return Selenide.page(GoogleBooksPage.class);
    }

    @Step("Opened Tools menu")
    public GoogleSearchResultPage openToolsMenu() {
        $(byId("hdtb-tls"))
                .click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    @AllArgsConstructor
    @Getter
    public enum FilterByCreatedTime {
        ANY_TIME(1), PAST_HOUR(2), PAST_24_HOURS(3), PAST_WEEK(4), PAST_MONTH(5), PAST_YEAR(6), CUSTOM_RANGE(7);
        private final int locatorNumber;
    }

    @Step("Filtered results by created date {timeUnit}")
    public GoogleSearchResultPage filterResultsByPeriod(FilterByCreatedTime timeUnit) {
        $x("//div[@id='hdtbMenus']/span[2]/g-popup")
                .click();

        $x(format("//div[@id='lb']//g-menu-item[%s]", timeUnit.locatorNumber))
                .shouldBe(visible)
                .click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    public String getLifetimeOfResultByPosition(int position) {
        return $x(format("//div[@class='g'][1]//*[contains(text(),'тому')]", position))
                .getText();
    }

    public String getResultDescriptionByPosition(int position) {
        return $x(format("//div[@class='g'][%s]//div[@class='IsZvec']/span", position))
                .getText()
                .toLowerCase();
    }
}
