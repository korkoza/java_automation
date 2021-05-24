package page_objects.subcategory_page;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import page_objects.SortingOption;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CatalogSettings {
    @Step("Sorted products by {option}")
    public SubCategoryPage sortProducts(SortingOption option) {
        $x("//rz-sort/select")
                .scrollTo()
                .click();

        $x(format("//rz-sort/select/option[@value='%s']", option.getOptionSelector()))
                .click();

        return Selenide.page(SubCategoryPage.class);
    }
}
