package page_objects.subcategory_page;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SubCategoryEnum {
    PLANTS("//a[contains(@href,'/rasteniya')]"),
    WATERING_CANS("//a[contains(@href,'/leyki')]"),
    NOTEBOOKS("//div/a[contains(@href,'/notebooks/c80004/')][1]");

    private final String subCategoryLocator;
}
