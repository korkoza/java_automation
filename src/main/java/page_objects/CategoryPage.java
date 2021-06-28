package page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import page_objects.subcategory_page.SubCategory;
import page_objects.subcategory_page.SubCategoryPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

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
    public SubCategoryPage openSubCategory(SubCategory subCategory) {
        $x(subCategory.getSubCategoryLocator())
                .scrollTo()
                .click();
        return Selenide.page(SubCategoryPage.class);
    }
}