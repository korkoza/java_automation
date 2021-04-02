import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstUITest {

    static {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
    static WebDriver chromeDriver = new ChromeDriver();

    @Test
    public static void testGoogleReturnWikipediaPage(){

        chromeDriver.get("https://google.com");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        chromeDriver
                .findElement(By.xpath("//input[@class='gLFyf gsfi']"))
                .sendKeys("smartphone", Keys.ENTER);

        WebElement linkToWikipedia = chromeDriver
                .findElement(By.xpath("//a[contains(@href,'wikipedia')]"));

        Assert.assertNotNull(linkToWikipedia);

        chromeDriver.quit();
    }

    @Test
    public static void testFirstResultContainFunnykitten(){

        chromeDriver.get("https://google.com");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        chromeDriver
                .findElement(By.xpath("//input[@class='gLFyf gsfi']"))
                .sendKeys("funny kitten", Keys.ENTER);

        String firstResult = chromeDriver
                .findElement(By.xpath("//div[@class='hlcw0c']/descendant::h3[1]"))
                .getText();

        Assert.assertTrue(firstResult.contains("funny kitten"));

        chromeDriver.quit();
    }

    @Test
    public static void testImagesContainFunny(){

        // 1. Open google.com

        chromeDriver.get("https://google.com");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // 2. Search for "funny kitten"

        chromeDriver
                .findElement(By.xpath("//input[@class='gLFyf gsfi']"))
                .sendKeys("funny kitten", Keys.ENTER);


        // 3. Navigate to Images

        WebElement imagesLink = chromeDriver
                .findElement(By.xpath("//div[@class='hdtb-mitem'][1]/a[@class='hide-focus-ring']"));

        imagesLink.click();

        // 4. Check that result list contain at least 10 items2

        WebElement tenthImageOfKitten = chromeDriver
                .findElement(By.xpath("//div[@class='islrc']/div[10]"));

        Assert.assertNotNull(tenthImageOfKitten);

        // 5. Check that the first and the fifth links text contain "funny"

        String firstImageText = chromeDriver
                .findElement(By.xpath("//div[@class='islrc']/div[1]"))
                .getText();


        String fifthImageText = chromeDriver
                .findElement(By.xpath("//div[@class='islrc']/div[5]"))
                .getText();

        Assert.assertTrue(firstImageText.contains("Funny")||fifthImageText.contains("Funny"));

        // 6. Go to the home page via clicking on logo

        WebElement logoImage = chromeDriver
                .findElement(By.xpath("//a[@class='F1hUFe jbTlie']"));

        logoImage.click();

        // 7. Check whether home page opens

        String pageTitle = chromeDriver
                .getTitle();

        Assert.assertTrue(pageTitle.contains("Google"));

        chromeDriver.quit();
    }
}