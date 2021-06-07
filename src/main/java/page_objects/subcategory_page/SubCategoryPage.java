package page_objects.subcategory_page;

import lombok.Getter;

import static java.lang.String.format;

@Getter
public class SubCategoryPage {
    private CatalogGrid catalogGrid = new CatalogGrid();
    private FiltersSideBar filtersSideBar = new FiltersSideBar();
    private CatalogSettings catalogSettings = new CatalogSettings();
}