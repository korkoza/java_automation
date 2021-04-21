package google;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class GoogleBooksPage extends BasePage {

    public String getLinkTextByPosition(int position) {
        return $x(format("//div[@class='Yr5TG'][%s]//h3", position))
                .getText()
                .toLowerCase();
    }
}
