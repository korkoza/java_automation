package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static google.TestRunner.chromeDriver;

public class GoogleSearchResultPage {

    public WebElement getLinkContainingText(String text) {
        WebElement link;
        return link = chromeDriver
                .findElement(By.xpath(String.format("//a[contains(@href,%s)]",text)));
    }

    public String getLinkText(int position) {
        return chromeDriver
                .findElement(By.xpath(String.format("//div[@class='hlcw0c']/descendant::h3[%s]",position)))
                .getText();
    }

    public GoogleImagesPage goToImages() {
        chromeDriver
                .findElement(By.xpath("//div[@class='hdtb-mitem'][1]/a[@class='hide-focus-ring']"))
                .click();
        return new GoogleImagesPage();
    }
}
