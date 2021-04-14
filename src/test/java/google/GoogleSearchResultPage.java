package google;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;

import java.util.List;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleSearchResultPage {

    public boolean resultContainsText(String text) {
        boolean isContained = false;

        List<String> resultTexts = $$x("//div[@class='g']")
                .shouldHave(CollectionCondition.sizeGreaterThan(5))
                .texts();

        for(String i:resultTexts){
            isContained = i.contains(text);
            if (isContained) break;
        }

        return isContained;
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
}
