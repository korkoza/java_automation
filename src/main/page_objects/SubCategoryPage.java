package page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class SubCategoryPage {
    @Step("Sorted products by {option}")
    public SubCategoryPage sortProducts(SortingOptionEnum option) {
        $x("//rz-sort/select")
                .scrollTo()
                .click();

        $x(format("//rz-sort/select/option[@value='%s']", option.getOptionSelector()))
                .click();

        return Selenide.page(SubCategoryPage.class);
    }

    public ArrayList<Product> getAllProducts() {
        int productsQuantity = $$x("//ul[@class='catalog-grid ng-star-inserted']/li")
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(60))
                .size();

        var productsList = new ArrayList<Product>();

        for (int i = 1; i <= productsQuantity; i++) {
            productsList.add(new Product(i));
        }

        return productsList;
    }
}