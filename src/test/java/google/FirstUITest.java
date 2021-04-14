package google;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstUITest extends TestRunner {
    GoogleHomePage googleHomePage = new GoogleHomePage();
    GoogleImagesPage googleImagesPage = new GoogleImagesPage();

    @BeforeMethod
    public void openBrowser() {
       googleHomePage.open();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWindow();
    }

    @Test
    public void testGoogleSearchResultContainsResource() {
        String verifiedText = "Wikipedia" ;

        boolean result = googleHomePage
                .doSearch("smartphone")
                .resultContainsText(verifiedText);

        Assert.assertTrue(result,String.format("Search result should contain \"%s\"", verifiedText));
    }

    @Test
    public void testFirstResultContainsFunnykitten(){
        String searchTerm = "funny kitten";

        String firstResult = googleHomePage
                .doSearch(searchTerm)
                .getLinkText(1);

        Assert.assertTrue(firstResult.contains(searchTerm), String.format("The first result should contain \"%s\"", searchTerm));
    }

    @Test
    public void testImagesContainFunny(){
        String varForAssertion = "Funny";
        int expectedNumberOfImages = 9;

        Integer numberOfImages = googleHomePage
                .doSearch("funny kitten")
                .goToImagesPage()
                .getNumberOfImages();

        Assert.assertTrue(numberOfImages >= expectedNumberOfImages, String.format("Number of images should be greater than %s", expectedNumberOfImages));

        String firstImageText = googleImagesPage
                .getImageText(1);

        String fifthImageText = googleImagesPage
                .getImageText(5);

        Assert.assertTrue(firstImageText.contains(varForAssertion), String.format("The first image should contain \"%s\"", varForAssertion));
        Assert.assertTrue(fifthImageText.contains(varForAssertion), String.format("The fifth image should contain \"%s\"", varForAssertion));

        String pageTitle = googleImagesPage
                .goToHomePageViaLogo()
                .getTitle();

        Assert.assertTrue(pageTitle.equals("Google"), "Home page should be opened");
    }
}