package page_objects;

import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

@Getter
public class Product {
    private final boolean isTopSale;
    private final boolean isNovelty;
    private final String title;
    private final int price;
    private final boolean isAvailable;

    public Product(int position) {
        this.title = $x(format("//ul[@class='catalog-grid ng-star-inserted']/li[%s]//span[@class='goods-tile__title']",
                position)).getText();
        this.price = Integer.parseInt($x(format("//ul[@class='catalog-grid ng-star-inserted']/li[%s]//" +
                        "span[contains(@class,'goods-tile__price-value')]",
                position)).getText().replaceAll("[^0-9]", ""));
        this.isTopSale = $x(format("//ul[@class='catalog-grid ng-star-inserted']/" +
                "li[%s]//span[contains((@class),'popularity')]", position)).exists();
        this.isNovelty = $x(format("//ul[@class='catalog-grid ng-star-inserted']/" +
                "li[%s]//span[contains((@class),'novelty')]", position)).exists();
        this.isAvailable = $x(format("//ul[@class='catalog-grid ng-star-inserted']" +
                "/li[%s]//div[contains(@class,'availability--available')]", position)).exists();
    }
}
