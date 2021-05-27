package rozetka;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.CategoryWithPopularProducts;
import page_objects.Product;
import page_objects.ProductWithDescription;
import page_objects.subcategory_page.SubCategory;
import page_objects.home_page.HomePage;
import util.TestRunner;

import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class ProductsFilteringTest extends TestRunner {
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
    public void testFilteringByDisplayType() {
        String filterName = "IPS";

        var filteredProductsList = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.PC)
                .openSubCategory(SubCategory.NOTEBOOKS)
                .getFiltersSideBar()
                .filterByFilterName(filterName)
                .getCatalogGrid()
                .getAllProductsWithDescription();

        boolean areProductsFilteredByDisplayType = true;

        for (ProductWithDescription product : filteredProductsList) {
            if (!product.getDescription().contains(filterName)) {
                areProductsFilteredByDisplayType = false;
                break;
            }
        }

        assertTrue(areProductsFilteredByDisplayType,
                format("Products should be filtered by %s display type", filterName));
    }

    @Test
    public void testFilteringByPrice() {
        int minPrice = 2500;
        int maxPrice = 4000;

        var filteredProductList = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.PC)
                .openSubCategory(SubCategory.NOTEBOOKS)
                .getFiltersSideBar()
                .filterByPrice(minPrice, maxPrice)
                .getCatalogGrid()
                .getAllProductsWithoutDescription();

        boolean areProductsFilteredByPrice = true;

        for (Product product : filteredProductList) {
            if (product.getPrice() < minPrice || product.getPrice() > maxPrice) {
                areProductsFilteredByPrice = false;
                break;
            }
        }

        assertTrue(areProductsFilteredByPrice, format("Products should be filtered by specified price range," +
                " [%s - %s]", minPrice, maxPrice));
    }
}
