package page_objects;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Selenide.$$x;

public class CategoryPage {

    public int getPopularProductsQuantity() {
        return $$x("//rz-widget-goods//app-goods-tile-lite")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .size();
    }
}