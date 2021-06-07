package page_objects.subcategory_page;

import com.codeborne.selenide.CollectionCondition;
import page_objects.Product;
import page_objects.ProductWithDescription;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$$x;

public class CatalogGrid {
    public List<Product> getAllProductsWithoutDescription() {
        int productsQuantity = $$x("//ul[@class='catalog-grid ng-star-inserted']/li")
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(3))
                .size();

        return IntStream.rangeClosed(1, productsQuantity)
                .mapToObj(number -> new Product(number))
                .collect(Collectors.toList());
    }

    public List<ProductWithDescription> getAllProductsWithDescription() {
        int productsQuantity = $$x("//ul[@class='catalog-grid ng-star-inserted']/li")
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(3))
                .size();

        return IntStream.rangeClosed(1, productsQuantity)
                .mapToObj(number -> new ProductWithDescription(number))
                .collect(Collectors.toList());
    }
}
