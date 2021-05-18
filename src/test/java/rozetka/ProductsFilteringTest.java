package rozetka;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.CategoryWithPopularProducts;
import page_objects.Product;
import page_objects.subcategory_page.FilterSectionEnum;
import page_objects.subcategory_page.FiltersSideBar;
import page_objects.subcategory_page.SubCategoryEnum;
import page_objects.home_page.HomePage;
import util.TestRunner;

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
    public void testFilteringByAvailability() {
        var productsList = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.PC)
                .openSubCategory(SubCategoryEnum.NOTEBOOKS)
                .getFiltersSideBar()
                .filterByAvailability()
                .getCatalogGrid()
                .getAllProducts();

        boolean areProductsFilteredByAvailability = true;

        for(Product product: productsList){
            if (!product.isAvailable()) {
                areProductsFilteredByAvailability = false;
                break;
            }
        }

        assertTrue(areProductsFilteredByAvailability, "Products should be filtered by availability");
    }

    @Test
    public void testFilterByDisplayType() {
        FilterSectionEnum filterName = FilterSectionEnum.DISPLAY_TYPE;
        int position = 8;

        var filteredProductList =homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.PC)
                .openSubCategory(SubCategoryEnum.NOTEBOOKS)
                .getFiltersSideBar()
                .filterByFilterName(filterName, position)
                .getCatalogGrid()
                .getAllProducts();

        String selectedFilterValue = FiltersSideBar.getSelectedFilterValue(filterName, position);

        boolean areProductsFilteredByDisplayType = true;

        for (Product product: filteredProductList) {
            if (!product.getDescription().contains(selectedFilterValue)) {
                areProductsFilteredByDisplayType = false;
                break;
            }
        }

        assertTrue(areProductsFilteredByDisplayType, "Products should be filtered by display type");
    }
}
