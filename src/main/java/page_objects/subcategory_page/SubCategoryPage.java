package page_objects.subcategory_page;

import lombok.Getter;
import page_objects.base_page.BasePage;

@Getter
public class SubCategoryPage extends BasePage {
    private CatalogGrid catalogGrid = new CatalogGrid();
    private FiltersSideBar filtersSideBar = new FiltersSideBar();
    private CatalogSettings catalogSettings = new CatalogSettings();
}