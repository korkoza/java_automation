package page_objects.base_page;

import lombok.Getter;

@Getter
public class BasePage {
    private final Header header = new Header();
}
