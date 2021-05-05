package page_objects;

import lombok.*;

@Getter
@AllArgsConstructor
public enum CategoryWithPopularProducts implements ICategory {
    NOTEBOOKS(1), SMARTPHONES(2), GAMES(3), HOME_APPLIANCES(4),
    PLUMBING(7), GARDEN(8), BUTY(11), KIDS(12),
    OFFICE_SCHOOL(13), ALCOHOL_FOOD(14);

    public final int categoryPosition;

    public int getCategoryPosition() {
        return categoryPosition;
    }
}