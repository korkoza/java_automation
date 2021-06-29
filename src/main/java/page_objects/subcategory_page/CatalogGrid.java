package page_objects.subcategory_page;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import page_objects.Product;
import page_objects.ProductWithDescription;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CatalogGrid {
    public List<Product> getAllProductsWithoutDescription() {
        int productsQuantity = $$x("//ul[@class='catalog-grid ng-star-inserted']/li")
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(3))
                .size();

        return IntStream.rangeClosed(1, productsQuantity)
                .mapToObj(Product::new)
                .collect(Collectors.toList());
    }

    public List<ProductWithDescription> getAllProductsWithDescription() {
        int productsQuantity = $$x("//ul[@class='catalog-grid ng-star-inserted']/li")
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(3))
                .size();

        return IntStream.rangeClosed(1, productsQuantity)
                .mapToObj(ProductWithDescription::new)
                .collect(Collectors.toList());
    }

    @Step("Added the product #{position} to comparison list")
    public CatalogGrid selectProductForComparison(int position) {
        $x(format("//ul[@class='catalog-grid ng-star-inserted']/li[%s]//button[contains(@class,'compare')]", position))
                .hover()
                .click();

        return this;
    }
}