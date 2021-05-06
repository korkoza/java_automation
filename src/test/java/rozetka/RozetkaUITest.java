package rozetka;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.CategoryWithPopularProducts;
import page_objects.CategoryWithoutPopularProducts;
import page_objects.home_page.HomePage;
import util.TestRunner;

import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class RozetkaUITest extends TestRunner {
    public HomePage homePage;

    @BeforeMethod
    public void openRozetkaHomePage() {
        homePage = new HomePage().open();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWindow();
    }

    @Test
    public void testFirstProductTitleContainsSearchedTerm() {
        var searchTerm = "телефон";
        int position = 1;

        var firstProductTitle = homePage
                .getHeader()
                .doSearch(searchTerm)
                .getProductTitle(position);

        assertTrue(firstProductTitle.contains(searchTerm), format("Result #%s should contain '%s'", position, searchTerm));
    }

    @Test
    public void testCategoryOpenedFromSideBarMenuDoesNotContainPopularProducts() {
        int categoryPopularProductsQuantity = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithoutPopularProducts.GOODS_FOR_HOUSE)
                .getPopularProductsQuantity();

        assertTrue(categoryPopularProductsQuantity == 0, "Category should contain some goods");
    }

    @Test
    public void testCategoryOpenedFromSideBarMenuContainsPopularProducts() {
        int categoryPopularProductsQuantity = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.ALCOHOL_FOOD)
                .getPopularProductsQuantity();

        assertTrue(categoryPopularProductsQuantity > 0, "Category should contain some goods");
    }
}
