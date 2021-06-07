package page_objects.subcategory_page;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class FiltersSideBar {
    @Step("Filtered products by {filterName}")
    public SubCategoryPage filterByFilterName(String filterName) {
        $x(format("//input[@id='%s']//..", filterName)).click();

        return Selenide.page(SubCategoryPage.class);
    }

    @Step("Filtered products by price range [{minPrice} - {maxPrice}]")
    public SubCategoryPage filterByPrice(int minPrice, int maxPrice) {
        var minPriceInputField = $x("//input[@formcontrolname='min']");

        minPriceInputField.clear();
        minPriceInputField.sendKeys(Integer.toString(minPrice));

        var maxPriceInputField = $x("//input[@formcontrolname='max']");

        maxPriceInputField.clear();
        maxPriceInputField.sendKeys(Integer.toString(maxPrice), Keys.ENTER);

        return Selenide.page(SubCategoryPage.class);
    }
}
