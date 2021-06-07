package page_objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortingOption {
    CHEAP("1: cheap"), EXPENSIVE("2: expensive"), POPULARITY("3: popularity"),
    NOVELTY("4: novelty"), SALE("5: action"), RANK("6: rank");

    private final String optionSelector;
}
