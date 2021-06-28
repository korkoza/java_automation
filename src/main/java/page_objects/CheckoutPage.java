package page_objects;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CheckoutPage {
    public int getCheckoutProductPrice(int position) {
        return Integer.parseInt($x(format("//div[@class='check-order']/fieldset/ul/li[%s]//" +
                "span[contains(@class,'price_color_red')]", position))
                .getText()
                .replaceAll("[^0-9]", ""));
    }

    public String getCheckoutProductTitle(int position) {
        return $x(format("//div[@class='check-order']/fieldset/ul/li[%s]//a", position)).getText();
    }
}
