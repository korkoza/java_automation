package google;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstUITest extends TestRunner {
    GoogleHomePage googleHomePage = new GoogleHomePage();
    GoogleImagesPage googleImagesPage = new GoogleImagesPage();
    GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage();

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
        String verifiedValue = "YouTube";

        String title = googleHomePage
                .typeTextToSearchField("funny kitten")
                .iAmFeelingLucky()
                .getTitle();

        boolean titleContainsText = title.contains(verifiedValue);
        Assert.assertTrue(titleContainsText, String.format("Title should contain \"%s\"", verifiedValue));
    }

    @Test
    public void testFifthResultPage() {
        int pageResultNumber = googleHomePage
                .doSearch("funny kitten")
                .goToSearchResultPage(5)
                .getNumberOfResultsOnPage();

        Assert.assertEquals(pageResultNumber, 9, "Page should contain 10 results");

        String firstPosition = googleSearchResultPage
                .getPageNumberByPosition(2); // 1 is for "Previous", 12 is for "Next"

        Assert.assertEquals(firstPosition, "1", "First position should point to Page 1");

        String fifthPosition = googleSearchResultPage
                .getPageNumberByPosition(11); // 1 is for "Previous", 12 is for "Next"

        Assert.assertEquals(fifthPosition, "10", "Fifth position should point to Page 10");
    }
}