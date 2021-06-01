package rozetka;

import com.codeborne.selenide.Selenide;
import com.google.common.collect.Ordering;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.CategoryWithPopularProducts;
import page_objects.SortingOption;
import page_objects.subcategory_page.SubCategory;
import page_objects.home_page.HomePage;
import util.TestRunner;

import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertTrue;

public class ProductsSortingTest extends TestRunner {
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
    public void testProductsSortingByPriceAsc() {
        var productsList = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.GARDEN)
                .openSubCategory(SubCategory.PLANTS)
                .getCatalogSettings()
                .sortProducts(SortingOption.CHEAP)
                .getCatalogGrid()
                .getAllProductsWithoutDescription();

        var productPricesList = productsList
                .stream()
                .map(product -> product.getPrice())
                .collect(toList());

        var areProductsSortedByPriceAsc = Ordering
                .natural()
                .isOrdered(productPricesList);

        assertTrue(areProductsSortedByPriceAsc, "Products should be sorted from cheap to expensive");
    }

    @Test
    public void testProductsSortingByPriceDesc() {
        var productsList = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.GARDEN)
                .openSubCategory(SubCategory.PLANTS)
                .getCatalogSettings()
                .sortProducts(SortingOption.EXPENSIVE)
                .getCatalogGrid()
                .getAllProductsWithoutDescription();

        var productPricesList = productsList
                .stream()
                .map(product -> product.getPrice())
                .collect(toList());

        var areProductsSortedByPriceDesc = Ordering
                .natural()
                .reverse()
                .isOrdered(productPricesList);

        assertTrue(areProductsSortedByPriceDesc, "Products should be sorted from expensive to cheap");
    }

    @Test
    public void testProductsSortingByPopularity() {
        var productsList = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.GARDEN)
                .openSubCategory(SubCategory.WATERING_CANS)
                .getCatalogSettings()
                .sortProducts(SortingOption.POPULARITY)
                .getCatalogGrid()
                .getAllProductsWithoutDescription();

        var productTopSalesList = productsList
                .stream()
                .map(product -> product.isTopSale())
                .map(product -> product ? 1 : 0)
                .collect(toList());

        var areProductsSortedByPopularity = Ordering
                .natural()
                .reverse()
                .isOrdered(productTopSalesList);

        assertTrue(areProductsSortedByPopularity, "Products should be sorted by popularity");
    }

    @Test
    public void testProductsSortingByNovelty() {
        var productsList = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.PC)
                .openSubCategory(SubCategory.NOTEBOOKS)
                .getCatalogSettings()
                .sortProducts(SortingOption.NOVELTY)
                .getCatalogGrid()
                .getAllProductsWithoutDescription();

        var productNoveltyList = productsList
                .stream()
                .map(product -> product.isNovelty())
                .map(product -> product ? 1 : 0)
                .collect(toList());

        var areProductsSortedByNovelty = Ordering
                .natural()
                .reverse()
                .isOrdered(productNoveltyList);

        assertTrue(areProductsSortedByNovelty, "Products should be sorted by Novelty");
    }
}
