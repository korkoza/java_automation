package page_objects;

import page_objects.base_page.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class ComparisonPage extends BasePage {
    public ComparisonPage addProductToCart(int position) {
        $x(format("//rz-products-section/ul/li[%s]//button[contains(@class,'buy')]", position)).click();

        return this;
    }

    public ProductForComparison getProductForComparison(int position) {
        return new ProductForComparison(position);
    }
}
