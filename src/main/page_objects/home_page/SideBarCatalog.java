package page_objects.home_page;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import page_objects.CategoryPage;
import page_objects.ICategory;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class SideBarCatalog {
    @Step("Opened {category} from side bar menu")
    public CategoryPage openCategoryPage(ICategory category) {
        $x(format("//sidebar-fat-menu//li[%s]", category.getCategoryPosition())).click();

        return Selenide.page(CategoryPage.class);
    }
}
