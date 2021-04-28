package rozetka;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class SearchResult {

    public String getResultTextByPosition(int position) {
        return $x(format("//ul[@class='catalog-grid ng-star-inserted']/li[1]", position)).getText();
    }
}
