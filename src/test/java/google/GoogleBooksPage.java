package google;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleBooksPage extends BasePage {

    public String getLinkTextByPosition(int position) {
        return $x(String.format("//div[@class='Yr5TG'][%s]//h3", position))
                .getText();
    }
}
