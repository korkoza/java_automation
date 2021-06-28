package page_objects.base_page;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import page_objects.CheckoutPage;
import page_objects.ComparisonPage;
import page_objects.ProductSearchResultPage;
import page_objects.subcategory_page.SubCategoryPage;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class Header {
    @Step("Searched {searchTerm}")
    public SubCategoryPage doSearchReturnSubCategoryPage(String searchTerm) {
        $(byName("search")).sendKeys(searchTerm, Keys.ENTER);
        return Selenide.page(SubCategoryPage.class);
    }

    @Step("Searched {searchTerm}")
    public ProductSearchResultPage doSearchReturnProductSearchResulPage(String searchTerm) {
        $(byName("search")).sendKeys(searchTerm, Keys.ENTER);
        return Selenide.page(ProductSearchResultPage.class);
    }

    @Step("Opened list of comparisons")
    public Header openListOfComparisons() {
        $x("//rz-comparison//button").click();

        return Selenide.page(Header.class);
    }

    public int getCountOfItemsForComparison(int position) {
        Selenide.sleep(3000);
        return Integer.parseInt(($x(format("//rz-comparison-modal//ul/li[%s]//" +
                "span[@class='comparison-modal__quantity']", position)).getText()));
    }

    @Step("Opened #{position} comparison")
    public ComparisonPage openComparisonByPosition(int position) {
        $x(format("//rz-comparison-modal//ul/li[%s]/a", position)).click();

        return Selenide.page(ComparisonPage.class);
    }

    @Step("Opened the cart")
    public Header openCart() {
        $x("//rz-cart//button").click();

        return this;
    }

    @Step("Opened Checkout")
    public CheckoutPage openCheckoutPage() {
        $x("//a[contains(@href,'checkout')]").click();

        return Selenide.page(CheckoutPage.class);
    }
}