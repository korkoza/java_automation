package rozetka;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.CategoryWithPopularProducts;
import page_objects.OrderingOption;
import page_objects.home_page.HomePage;
import util.TestRunner;

import static org.testng.Assert.assertTrue;

public class ProductsOrderingTest extends TestRunner {
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
    public void testProductsOrderingByPriceAsc() {
        var areProductsOrderedByPriceAsc = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.GARDEN)
                .openPlantsSubCategory()
                .orderProducts(OrderingOption.CHEAP)
                .areProductsOrderedByPriceAsc();

        assertTrue(areProductsOrderedByPriceAsc, "Products should be sorted from cheap to expensive");
    }

    @Test
    public void testProductsOrderingByPriceDesc() {
        var areProductsOrderedByPriceDesc = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.GARDEN)
                .openPlantsSubCategory()
                .orderProducts(OrderingOption.EXPENSIVE)
                .areProductsOrderedByPriceDesc();

        assertTrue(areProductsOrderedByPriceDesc, "Products should be sorted from expensive to cheap");

    }

    @Test
    public void testProductsOrderingByPopularity() {
        var areProductsOrderedByPopularity = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.GARDEN)
                .openWateringCanSubCategory()
                .orderProducts(OrderingOption.POPULARITY)
                .areProductsOrderedByPopularity();

        assertTrue(areProductsOrderedByPopularity, "Products should be ordered by popularity");
    }

    @Test
    public void testProductsOrderingByNovelty() {
        var areProductsOrderedByNovelty = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.PC)
                .openNotebookSubcategory()
                .orderProducts(OrderingOption.NOVELTY)
                .areProductsOrderedByNovelty();

        assertTrue(areProductsOrderedByNovelty, "Products should be ordered by Novelty");
    }

    @Test
    public void testProductsOrderingBySale() {
        var areProductsOrderedBySale = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.PC)
                .openNotebookSubcategory()
                .orderProducts(OrderingOption.SALE)
                .areProductsOrderedBySale();

        assertTrue(areProductsOrderedBySale, "Products should be ordered by Sale");
    }
}
