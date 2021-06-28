package page_objects;

import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

@Getter
public class ProductForComparison {
    private final String title;
    private final int price;

    public ProductForComparison(int position) {
        this.title = $x(format("//rz-products-section/ul/li[%s]//a", position)).getText();
        this.price = Integer.parseInt($x(format("//rz-products-section/ul/li[%s]//div[contains(@class," +
                "'product__price--red')]", position)).getOwnText().replaceAll("[^0-9]", ""));
    }
}
