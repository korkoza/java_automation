package google;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;

public class GoogleImagesPage extends BasePage {

    public Integer getQuantityOfImages() {
        return $$x("//div[@class='islrc']/div")
                .shouldHave(CollectionCondition.sizeGreaterThan(10))
                .size();
    }

    public String getImageText(int position) {
        return $x(String.format("//div[@class='islrc']/div[%s]", position))
                .getText();
    }

    public GoogleHomePage goToHomePageViaLogo() {
        $x("//div[@class='oDnpvd']//a")
                .click();
        return Selenide.page(GoogleHomePage.class);
    }
}
