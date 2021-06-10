package page_objects;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ProductSearchResultPage {

    public String getProductTitle(int position) {
        return $x(format("//ul[@class='catalog-grid ng-star-inserted']/li[%s]//span[@class='goods-tile__title']", position))
                .getText();
    }
}
