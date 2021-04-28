package rozetka;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Selenide.$$x;

public class CategoryPage {

    public int getCategoryGoodsQuantity() {
        return $$x("//rz-widget-goods//app-goods-tile-lite")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .size();
    }
}