package google;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

@Deprecated
public class GoogleImagesPage extends BasePage {

    public Integer getQuantityOfImages() {
        return $$x("//div[@class='islrc']/div")
                .shouldHave(CollectionCondition.sizeGreaterThan(10))
                .size();
    }

    public String getImageText(int position) {
        return $x(format("//div[@class='islrc']/div[%s]", position))
                .getText();
    }

    @Step("Navigated to Home page via clicking on the logo")
    public GoogleHomePage goToHomePageViaLogo() {
        $x("//div[@class='oDnpvd']//a")
                .click();
        return Selenide.page(GoogleHomePage.class);
    }
}
