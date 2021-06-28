package rozetka;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.*;
import page_objects.home_page.HomePage;
import page_objects.subcategory_page.SubCategoryPage;
import util.TestRunner;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
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
                .doSearchReturnProductSearchResulPage(searchTerm)
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

    @Test
    public void testProductAtCheckoutHasCorrectTitleAndPrice() {
        SubCategoryPage subCategoryPage = homePage
                .getHeader()
                .doSearchReturnSubCategoryPage("телефон")
                .getFiltersSideBar()
                .filterByPrice(4000, 6000);

        subCategoryPage
                .getCatalogGrid()
                .selectProductForComparison(1)
                .selectProductForComparison(2);

        int countOfItemsForComparison = subCategoryPage
                .getHeader()
                .openListOfComparisons()
                .getCountOfItemsForComparison(1);

        ComparisonPage comparisonPage = subCategoryPage
                .getHeader()
                .openComparisonByPosition(1);

        assertEquals(countOfItemsForComparison, 2);

        ProductForComparison chosenProduct = comparisonPage
                .getProductForComparison(1);

        CheckoutPage checkoutPage = comparisonPage
                .addProductToCart(1)
                .getHeader()
                .openCart()
                .openCheckoutPage();

        String checkoutProductTitle = checkoutPage
                .getCheckoutProductTitle(1);

        assertEquals(checkoutProductTitle, chosenProduct.getTitle());

        int checkoutProductPrice = checkoutPage
                .getCheckoutProductPrice(1);

        assertEquals(checkoutProductPrice, chosenProduct.getPrice());
    }
}
