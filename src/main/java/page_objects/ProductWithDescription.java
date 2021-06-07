package page_objects;

import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

@Getter
public class ProductWithDescription extends Product {
    private final String description;

    public ProductWithDescription(int position) {
        super(position);
        this.description = $x(format("//ul[@class='catalog-grid ng-star-inserted']/li[%s]//" +
                "p[contains(@class, 'description')]", position)).getOwnText();
    }
}
