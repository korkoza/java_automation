package google;
import static google.TestRunner.chromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class GoogleHomePage {

    public GoogleHomePage open() {
        chromeDriver.get("https://www.google.com/");
        return this;
    }

    public GoogleSearchResultPage doSearch(String searchTerm) {
        chromeDriver
                .findElement(By.xpath("//input[@class='gLFyf gsfi']"))
                .sendKeys(searchTerm, Keys.ENTER);
        return new GoogleSearchResultPage();
    }

    public String getTitle() {
        return chromeDriver
                .getTitle();
    }
}
