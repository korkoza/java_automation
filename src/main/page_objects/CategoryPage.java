package page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

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

    @Step("Opened Plants subcategory")
    public SubCategoryPage openPlantsSubCategory() {
        $x("//a[@title='Рослини і догляд за ними'][1]")
                .scrollTo()
                .click();
        return Selenide.page(SubCategoryPage.class);
    }

    @Step("Opened Watering Cans subcategory")
    public SubCategoryPage openWateringCanSubCategory() {
        $x("//a[@title='Лійки для квітів']")
                .scrollTo()
                .click();
        return Selenide.page(SubCategoryPage.class);
    }

    @Step("Opened Notebooks subcategory")
    public SubCategoryPage openNotebookSubcategory() {
        $x("//a[@title='Ноутбуки'][2]")
                .scrollTo()
                .hover()
                .click();
        return Selenide.page(SubCategoryPage.class);
    }
}