package page_objects.subcategory_page;

import com.codeborne.selenide.CollectionCondition;
import page_objects.Product;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$$x;

public class CatalogGrid {
    public List<Product> getAllProducts() {
        int productsQuantity = $$x("//ul[@class='catalog-grid ng-star-inserted']/li")
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(60))
                .size();

        return IntStream.rangeClosed(1, productsQuantity)
                .mapToObj(number -> new Product(number))
                .collect(Collectors.toList());
    }
}
