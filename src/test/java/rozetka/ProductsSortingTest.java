package rozetka;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.CategoryWithPopularProducts;
import page_objects.SortingOptionEnum;
import page_objects.SubCategoryEnum;
import page_objects.home_page.HomePage;
import util.TestRunner;

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
                .openSubCategory(SubCategoryEnum.PLANTS)
                .sortProducts(SortingOptionEnum.CHEAP)
                .getAllProducts();

        var areProductsSortedByPriceAsc = true;

        for (int i = 0; i < productsList.size() - 1; i++) {
            if (productsList.get(i).getPrice() > productsList.get(i + 1).getPrice()) {
                areProductsSortedByPriceAsc = false;
                break;
            }
        }

        assertTrue(areProductsSortedByPriceAsc, "Products should be sorted from cheap to expensive");
    }

    @Test
    public void testProductsSortingByPriceDesc() {
        var productsList = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.GARDEN)
                .openSubCategory(SubCategoryEnum.PLANTS)
                .sortProducts(SortingOptionEnum.EXPENSIVE)
                .getAllProducts();

        var areProductsSortedByPriceDesc = true;

        for (int i = 0; i < productsList.size() - 1; i++) {
            if (productsList.get(i).getPrice() < productsList.get(i + 1).getPrice()) {
                areProductsSortedByPriceDesc = false;
                break;
            }
        }

        assertTrue(areProductsSortedByPriceDesc, "Products should be sorted from expensive to cheap");
    }

    @Test
    public void testProductsSortingByPopularity() {
        var productsList = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.GARDEN)
                .openSubCategory(SubCategoryEnum.WATERING_CANS)
                .sortProducts(SortingOptionEnum.POPULARITY)
                .getAllProducts();

        var areProductsSortedByPopularity = true;

        for (int i = 0; i < productsList.size() - 1; i++) {
            if (!productsList.get(0).isTopSale()) {
                areProductsSortedByPopularity = false;
                break;
            }
            if (!(productsList.get(i).isTopSale() && productsList.get(i + 1).isTopSale())) {
                for (int j = i + 1; j < productsList.size() - 1; j++) {
                    if (productsList.get(j).isTopSale() || productsList.get(j + 1).isTopSale()) {
                        areProductsSortedByPopularity = false;
                        break;
                    }
                }
            }
            if (!areProductsSortedByPopularity) {
                break;
            }
        }

        assertTrue(areProductsSortedByPopularity, "Products should be sorted by popularity");
    }

    @Test
    public void testProductsSortingByNovelty() {
        var productsList = homePage
                .getSideBarCatalog()
                .openCategoryPage(CategoryWithPopularProducts.PC)
                .openSubCategory(SubCategoryEnum.NOTEBOOKS)
                .sortProducts(SortingOptionEnum.NOVELTY)
                .getAllProducts();

        var areProductsSortedByNovelty = true;

        for (int i = 0; i < productsList.size() - 1; i++) {
            if (!productsList.get(0).isNovelty()) {
                areProductsSortedByNovelty = false;
                break;
            }
            if (!(productsList.get(i).isNovelty() && productsList.get(i + 1).isNovelty())) {
                for (int j = i + 1; j < productsList.size() - 1; j++) {
                    if (productsList.get(j).isNovelty() || productsList.get(j + 1).isNovelty()) {
                        areProductsSortedByNovelty = false;
                        break;
                    }
                }
            }
            if (!areProductsSortedByNovelty) {
                break;
            }
        }

        assertTrue(areProductsSortedByNovelty, "Products should be sorted by Novelty");
    }
}
