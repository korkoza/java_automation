package page_objects.subcategory_page;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class FiltersSideBar {
    public SubCategoryPage filterByAvailability() {
        $x("//div[@data-filter-name='gotovo-k-otpravke']").click();
        return Selenide.page(SubCategoryPage.class);
    }

    public SubCategoryPage filterByFilterName(FilterSectionEnum filterName, int position) {
        int ulLocator = (position / 8) + ((position % 8 == 0) ? 0 : 1);
        int liLocator = (position % 8) + ((position % 8 == 0) ? 8 : 0);

        $x(format("//div[@data-filter-name='%s']//rz-filter-checkbox/ul[%s]/li[%s]//a",
                filterName.getFilterName(), ulLocator, liLocator))
//                .scrollTo()
                .click();

        return Selenide.page(SubCategoryPage.class);
    }

    public static String getSelectedFilterValue(FilterSectionEnum filterName, int position) {
        int ulLocator = (position / 8) + ((position % 8 == 0) ? 0 : 1);
        int liLocator = position % 8;

        return  $x(format("//div[@data-filter-name='%s']//rz-filter-checkbox/ul[%s]/li[%s]//label",
                filterName.getFilterName(), ulLocator, liLocator))
                .getText();
    }
}
