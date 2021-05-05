package google;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

@Deprecated
public class GoogleHomePage extends BasePage {
    @Step("Opened Google home page")
    public GoogleHomePage open() {
        Selenide.open("https://www.google.com/");
        return this;
    }

    @Step("Searched '{searchTerm}'")
    public GoogleSearchResultPage doSearch(String searchTerm) {
        $(By.name("q")).sendKeys(searchTerm, Keys.ENTER);

        return Selenide.page(GoogleSearchResultPage.class);
    }

    @Step("Changed language to {lang}")
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

    @Step("Set '{searchTerm}' to search bar")
    public GoogleHomePage setTextToSearch(String searchTerm) {
        $(By.name("q")).sendKeys(searchTerm);
        return Selenide.page(GoogleHomePage.class);
    }

    @Step("Pressed 'I'm Feeling Lucky' button")
    public GoogleSearchResultPage iAmFeelingLucky() {
        $(By.name("btnI")).click();
        return Selenide.page(GoogleSearchResultPage.class);
    }

    private WebElement logo = $x("//img[@class='lnXdpd']");

    public GoogleHomePage hideLogo() {
        WebElementUtil.hideElement(logo);
        return Selenide.page(GoogleHomePage.class);
    }

    public GoogleHomePage showLogo() {
        WebElementUtil.showElement(logo);
        return Selenide.page(GoogleHomePage.class);
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }
}
