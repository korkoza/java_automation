package page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import page_objects.subcategory_page.SubCategoryEnum;
import page_objects.subcategory_page.SubCategoryPage;

import static com.codeborne.selenide.Selenide.*;

public class CategoryPage {

    public int getPopularProductsQuantity() {
        try {
            return $$x("//rz-widget-goods//app-goods-tile-lite")
                    .shouldHave(CollectionCondition.sizeGreaterThan(0))
                    .size();
        } catch (AssertionError e) {
            return 0;
        }
    }

    @Step("Opened subcategory {locator}")
    public SubCategoryPage openSubCategory(SubCategoryEnum subCategory) {
        $x(subCategory.getSubCategoryLocator())
                .scrollTo()
                .click();
        return Selenide.page(SubCategoryPage.class);
    }
}