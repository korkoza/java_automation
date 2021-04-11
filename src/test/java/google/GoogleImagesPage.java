package google;
import static google.TestRunner.chromeDriver;
import org.openqa.selenium.By;

public class GoogleImagesPage {

    public Integer getNumberOfImages() {
        return chromeDriver
                .findElements(By.xpath("//div[@class='islrc']/div")).size();
    }

    public String getImageText(int position) {
        return chromeDriver
                .findElement(By.xpath(String.format("//div[@class='islrc']/div[%s]", position)))
                .getText();
    }

    public GoogleHomePage clickOnLogo() {
        chromeDriver
                .findElement(By.xpath("//a[@class='F1hUFe jbTlie']"))
                .click();
        return new GoogleHomePage();
    }
}
