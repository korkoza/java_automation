package page_objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SubCategory {
    PLANTS("//a[contains(@href,'/rasteniya')]"),
    WATERING_CANS("//a[contains(@href,'/leyki')]"),
    NOTEBOOKS("//div/a[contains(@href,'/notebooks/c80004/')][1]");

    private final String subCategoryLocator;
}
