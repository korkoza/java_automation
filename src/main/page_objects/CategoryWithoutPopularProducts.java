package page_objects;

import lombok.*;

@Getter
@AllArgsConstructor
public enum CategoryWithoutPopularProducts implements ICategory {
    GOODS_FOR_HOUSE(5), TOOLS(6), SPORT(9),
    SHOES_CLOTHES(10), BUSINESS(15), SERVICES(16);

    public final int categoryPosition;

    public int getCategoryPosition() {
        return categoryPosition;
    }
}
