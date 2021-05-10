package page_objects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import com.google.common.collect.Ordering;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class SubCategoryPage {
    @Step("Sorted products by {option}")
    public SubCategoryPage orderProducts(OrderingOption option) {
        $x("//rz-sort/select")
                .scrollTo()
                .click();

        $x(format("//rz-sort/select/option[@value='%s']", option.getOptionSelector()))
                .click();

        return Selenide.page(SubCategoryPage.class);
    }

    public List<Integer> getProductsPrices() {
        return $$x("//span[contains(@class,'goods-tile__price-value')]")
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(60))
                .stream()
                .map(p -> p.getText())
                .map(p -> p.replaceAll("[^0-9]", ""))
                .map(p -> Integer.valueOf(p))
                .collect(Collectors.toList());
    }

    public boolean areProductsOrderedByPriceAsc() {
        var productPrices = getProductsPrices();
        return Ordering.natural().isOrdered(productPrices);
    }

    public boolean areProductsOrderedByPriceDesc() {
        var productPrices = getProductsPrices();
        return Ordering.natural().reverse().isOrdered(productPrices);
    }

    public List<String> getProductTileDisplayedText() {
        return $$x("//div[@class='goods-tile__inner']")
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(60))
                .stream()
                .map(p -> p.getText())
                .collect(Collectors.toList());
    }

    public boolean areProductsOrderedByPopularity() {
        var productTileDisplayedText = getProductTileDisplayedText();

        var orderCheсkingList = new ArrayList<Integer>();

        for (String product : productTileDisplayedText) {
            if (product.contains("ТОП ПРОДАЖІВ")) {
                orderCheсkingList.add(1);
            } else orderCheсkingList.add(0);
        }

        return (Ordering.natural().reverse().isOrdered(orderCheсkingList)) && (orderCheсkingList.get(0) == 1);
    }

    public boolean areProductsOrderedByNovelty() {
        var productTileDisplayedText = getProductTileDisplayedText();

        var orderCheсkingList = new ArrayList<Integer>();

        for (String product : productTileDisplayedText) {
            if (product.contains("НОВИНКА")) {
                orderCheсkingList.add(1);
            } else orderCheсkingList.add(0);
        }

        return (Ordering.natural().reverse().isOrdered(orderCheсkingList)) && (orderCheсkingList.get(0) == 1);
    }

    public boolean areProductsOrderedBySale() {
        var productTileDisplayedText = getProductTileDisplayedText();

        var orderCheckingList = new ArrayList<Integer>();

        for (String product: productTileDisplayedText) {
            if (product.contains("АКЦІЯ") || product.contains("ТОП ПРОДАЖІВ") || product.contains("ТІЛЬКИ В РОЗЕТЦІ")
                    || product.contains("СУПЕРЦІНА")){
                orderCheckingList.add(1);
            } else orderCheckingList.add(0);
        }

        return (Ordering.natural().reverse().isOrdered(orderCheckingList) && orderCheckingList.get(0) == 1);
    }
}
