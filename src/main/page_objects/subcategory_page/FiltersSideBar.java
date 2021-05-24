package page_objects.subcategory_page;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class FiltersSideBar {
    @Step("Filtered products by {filterName}")
    public SubCategoryPage filterByFilterName(String filterLocator) {
        $x(format("//a[contains(@href, '%s')]", filterLocator)).click();

        return Selenide.page(SubCategoryPage.class);
    }

    @Step("Filtered products by price range [{minPrice} - {maxPrice}]")
    public SubCategoryPage filterByPrice(String minPrice, String maxPrice) {
        $x("//input[@formcontrolname='min']")
                .doubleClick()
                .sendKeys(minPrice);

        $x("//input[@formcontrolname='max']")
                .doubleClick()
                .sendKeys(maxPrice, Keys.ENTER);

        return Selenide.page(SubCategoryPage.class);
    }
}
