package google;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstUITest extends TestRunner {

    @BeforeMethod
    public void openBrowser() {
       new GoogleHomePage().open();
    }

    @AfterMethod
    public void closeBrowser() {
        chromeDriver.quit();
    }

    @Test
    public void testGoogleSearchResultContainsResource() {
        WebElement linkContainingText = null;
        String chekedResource = "\"wikipedia\"";

        try {
           linkContainingText = new GoogleHomePage()
                    .doSearch("smartphone")
                    .getLinkContainingText(chekedResource);
        } catch (NoSuchElementException e) {
            System.out.println("Link containing " + chekedResource + " is not found. Either it is not found indeed or try checking the locator for corectness");
        } finally {
            Assert.assertNotNull(linkContainingText);
        }
    }

    @Test
    public void testFirstResultContainsFunnykitten(){
        String searchTerm = "funny kitten";

        String firstResult = new GoogleHomePage()
                .doSearch(searchTerm)
                .getLinkText(1);

        Assert.assertTrue(firstResult.contains(searchTerm));
    }

    @Test
    public void testImagesContainFunny(){
        String varForAssertion = "Funny";

        Integer numberOfImages = new GoogleHomePage()
                .doSearch("funny kitten")
                .goToImages()
                .getNumberOfImages();

        Assert.assertTrue(numberOfImages >= 10);

        String firstImageText = new GoogleImagesPage()
                .getImageText(1);

        String fifthImageText = new GoogleImagesPage()
                .getImageText(5);

        Assert.assertTrue(firstImageText.contains(varForAssertion)||fifthImageText.contains(varForAssertion));

        String pageTitle = new GoogleImagesPage()
                .clickOnLogo()
                .getTitle();

        Assert.assertTrue(pageTitle.equals("Google"));
    }
}