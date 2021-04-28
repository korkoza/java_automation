package rozetka;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class UITest extends TestRunner {
    public HomePage homePage;

    @BeforeMethod
    public void openBrowser() {
        homePage = new HomePage().open();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWindow();
    }

    @Test
    public void testFirstResultContainSearchedTerm() {
        var searchTerm = "смартфон";
        int position = 1;

        var firstResultTitle = homePage
                .doSearch(searchTerm)
                .getResultTextByPosition(position);

        assertTrue(firstResultTitle.contains(searchTerm), format("Result #%s should contain '%s'", position, searchTerm));
    }

    @Test
    public void testCategoryOpenedFromSideBarMenuContainsPopularGoods() {
        int categoryGoodsQuantity = homePage
                .openCategoryFromSideBarMenu(HomePage.CategoriesWithPopularGoods.SMARTPHONES)
                .getCategoryGoodsQuantity();

        Assert.assertTrue(categoryGoodsQuantity > 0, "Category should contain some goods");
    }
}
