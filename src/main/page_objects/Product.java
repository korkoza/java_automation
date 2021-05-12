package page_objects;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

@Getter
public class Product {
    private boolean isTopSale;
    private boolean isNovelty;
    private final String title;
    private final int price;

    public Product(int position) {
        this.title = $x(format("//ul[@class='catalog-grid ng-star-inserted']/li[%s]//span[@class='goods-tile__title']",
                position)).getText();
        this.price = Integer.parseInt($x(format("//ul[@class='catalog-grid ng-star-inserted']/li[%s]//" +
                        "span[contains(@class,'goods-tile__price-value')]",
                position)).getText().replaceAll("[^0-9]", ""));
        try {
            this.isTopSale = $x(format("//ul[@class='catalog-grid ng-star-inserted']/li[%s]//" +
                    "span[contains((@class),'popularity')]", position)).exists();
        } catch (NoSuchElementException e) {
            this.isTopSale = false;
        }
        try {
            this.isNovelty = $x(format("//ul[@class='catalog-grid ng-star-inserted']/li[%s]//" +
                    "span[contains((@class),'novelty')]", position)).exists();
        } catch (NoSuchElementException e) {
            this.isNovelty = false;
        }
    }
}
