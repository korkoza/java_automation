package page_objects.subcategory_page;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FilterSectionName {
    READY_TO_SHIP("gotovo-k-otpravke"), PRODUCER("producer"), PRICE("price"),
    DISPLAY_TYPE("36519");

    private final String filterName;
}
