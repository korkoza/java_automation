package google;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class FirstUITest extends TestRunner {
    public GoogleHomePage googleHomePage;

    @BeforeMethod
    public void openBrowser() {
       googleHomePage = new GoogleHomePage().open();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWindow();
    }

    @Test
    public void testGoogleSearchResultContainsResource() {
        List<String> results = googleHomePage
                .doSearch("smartphone")
                .getListOfResults();

        String expectedTextInResult = "Wikipedia";
        boolean doesResultContainText = false;

        for(String result:results){
            doesResultContainText = result.contains(expectedTextInResult);
            if (doesResultContainText) {
                break;
            }
        }

        Assert.assertTrue(doesResultContainText,String.format("Search result should contain \"%s\"", expectedTextInResult));
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
        GoogleImagesPage imagesPage = googleHomePage
                .doSearch("funny kitten")
                .goToImagesPage();

        int quantityOfImages = imagesPage
                .getQuantityOfImages();

        int expectedQuantityOfImages = 10;
        Assert.assertTrue(quantityOfImages >= expectedQuantityOfImages, String.format("Number of images should be greater or equal than %s", expectedQuantityOfImages));

        String firstImageText = imagesPage
                .getImageText(1);

        String fifthImageText = imagesPage
                .getImageText(5);

        String expectedImageText = "Funny";
        Assert.assertTrue(firstImageText.contains(expectedImageText), String.format("The first image should contain \"%s\"", expectedImageText));
        Assert.assertTrue(fifthImageText.contains(expectedImageText), String.format("The fifth image should contain \"%s\"", expectedImageText));

        String pageTitle = imagesPage
                .goToHomePageViaLogo()
                .getTitle();

        Assert.assertTrue(pageTitle.equals("Google"), "Home page should be opened");
    }

    @Test
    public void testSwitchToUkrainian(){
//        Ukrainian language is open by default.

        String searchButtonText = googleHomePage
                .getSearchButtonText();

        Assert.assertEquals(searchButtonText,"Пошук Google", String.format("Search button text should be \"%s\"", searchButtonText));

        String feelLuckyButtonText = googleHomePage
                .getFeelLuckyButtonText();

        Assert.assertEquals(feelLuckyButtonText,"Мені пощастить", String.format("Search button text should be \"%s\"", feelLuckyButtonText));

        searchButtonText = googleHomePage
                .switchLanguage("Eng")
                .getSearchButtonText();

        Assert.assertEquals(searchButtonText,"Google Search", String.format("Search button text should be \"%s\"", searchButtonText));

        feelLuckyButtonText = googleHomePage
                .getFeelLuckyButtonText();

        Assert.assertEquals(feelLuckyButtonText,"I'm Feeling Lucky", String.format("Search button text should be \"%s\"", feelLuckyButtonText));
    }

    @Test
    public void testFeelLuckyReturnYouTube() {
        String title = googleHomePage
                .setTextToSearch("funny kitten")
                .iAmFeelingLucky()
                .getTitle();

        String expectedText = "YouTube";
        boolean doesTitleContainText = title.contains(expectedText);
        Assert.assertTrue(doesTitleContainText, String.format("Title should contain \"%s\"", expectedText));
    }

    @Test
    public void testFifthPageResult() {
        int pageNumber = 5;

        GoogleSearchResultPage googleSearchResultPage = googleHomePage
                .doSearch("funny kitten")
                .goToSearchResultPage(pageNumber);

        int quantityOfResultsOnPage = googleSearchResultPage
                .getQuantityOfResultsOnPage();

        Assert.assertEquals(quantityOfResultsOnPage, 10, "Page should contain 10 results");

        int currentPageNumber = googleSearchResultPage
                .getCurrentPageNumber();

        Assert.assertEquals(currentPageNumber, pageNumber, String.format("Page number should equal - %s", pageNumber));
    }
}