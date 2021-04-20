package google;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

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

        for (String result : results) {
            doesResultContainText = result.contains(expectedTextInResult);
            if (doesResultContainText) {
                break;
            }
        }

        assertTrue(doesResultContainText, format("Search result should contain \"%s\"", expectedTextInResult));
    }

    @Test
    public void testFirstResultContainsFunnykitten() {
        String searchTerm = "funny kitten";

        String firstResult = googleHomePage
                .doSearch(searchTerm)
                .getLinkText(1);

        assertTrue(firstResult.contains(searchTerm), format("The first result should contain \"%s\"", searchTerm));
    }

    @Test
    public void testImagesContainFunny() {
        GoogleImagesPage imagesPage = googleHomePage
                .doSearch("funny kitten")
                .goToImagesPage();

        int quantityOfImages = imagesPage
                .getQuantityOfImages();

        int expectedQuantityOfImages = 10;
        assertTrue(quantityOfImages >= expectedQuantityOfImages, format("Number of images should be greater or equal than %s", expectedQuantityOfImages));

        String firstImageText = imagesPage
                .getImageText(1);

        String fifthImageText = imagesPage
                .getImageText(5);

        String expectedImageText = "Funny";
        assertTrue(firstImageText.contains(expectedImageText), format("The first image should contain \"%s\"", expectedImageText));
        assertTrue(fifthImageText.contains(expectedImageText), format("The fifth image should contain \"%s\"", expectedImageText));

        String pageTitle = imagesPage
                .goToHomePageViaLogo()
                .getTitle();

        assertTrue(pageTitle.equals("Google"), "Home page should be opened");
    }

    @Test
    public void testSwitchToUkrainian() {
//        Ukrainian language is open by default.

        String searchButtonText = googleHomePage
                .getSearchButtonText();

        Assert.assertEquals(searchButtonText, "Пошук Google", format("Search button text should be \"%s\"", searchButtonText));

        String feelLuckyButtonText = googleHomePage
                .getFeelLuckyButtonText();

        Assert.assertEquals(feelLuckyButtonText, "Мені пощастить", format("Search button text should be \"%s\"", feelLuckyButtonText));

        searchButtonText = googleHomePage
                .switchLanguage("Eng")
                .getSearchButtonText();

        Assert.assertEquals(searchButtonText, "Google Search", format("Search button text should be \"%s\"", searchButtonText));

        feelLuckyButtonText = googleHomePage
                .getFeelLuckyButtonText();

        Assert.assertEquals(feelLuckyButtonText, "I'm Feeling Lucky", format("Search button text should be \"%s\"", feelLuckyButtonText));
    }

    @Test
    public void testFeelLuckyReturnYouTube() {
        String title = googleHomePage
                .setTextToSearch("funny kitten")
                .iAmFeelingLucky()
                .getTitle();

        String expectedText = "YouTube";
        boolean doesTitleContainText = title.contains(expectedText);
        assertTrue(doesTitleContainText, format("Title should contain \"%s\"", expectedText));
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

        Assert.assertEquals(currentPageNumber, pageNumber, format("Page number should equal - %s", pageNumber));
    }

    @Test
    public void testLogoVisibility() {
        WebElement logo = googleHomePage.open()
                .getLogo();

        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].style.visibility='hidden'", logo);

        Assert.assertFalse(logo.isDisplayed(), "Logo should not be displayed");

        js.executeScript("arguments[0].style.visibility='visible'", logo);

        assertTrue(logo.isDisplayed(), "Logo should be displayed");
    }

    @Test
    public void testResultsQuantity() {
        int resultsQuantity = googleHomePage
                .open()
                .doSearch("webdriver")
                .getResultsQuantity();

        assertTrue(resultsQuantity > 5000000, "Results quantity should more than 5 000 000");
    }

    @Test
    public void testLastBookContainsSearchedTerm() {
        String searchTerm = "webdriver";
        String lastResultLink = googleHomePage
                .open()
                .doSearch(searchTerm)
                .goToBooksPage()
                .getLinkTextByPosition(10);

        boolean doesLastLinkContainSearchTerm = Pattern.compile(Pattern.quote(searchTerm), Pattern.CASE_INSENSITIVE).matcher(lastResultLink).find();
        assertTrue(doesLastLinkContainSearchTerm, format("Last link should contain %s", searchTerm));
    }

    @Test
    public void testResultsSortedByTimeContain() {
        String firstResultLifetime = googleHomePage.open()
                .doSearch("webdriver")
                .openTools()
                .sortByTime()
                .getLifetimeOfResultByPosition(1);

        assertTrue(firstResultLifetime.contains("хвилин"), "First result should contain \"хвилин\"");
        assertTrue(firstResultLifetime.contains("тому"), "First result should contain \"тому\"");
    }

    @Test
    public void testFourteenthResultsPageContainsWebdriver() {
        String searchTerm = "webdriver";

        String fourteenthResultDescription = googleHomePage.open()
                .doSearch(searchTerm)
                .goToSearchResultPage(10)
                .goToSearchResultPage(14)
                .getResultDescriptionByPosition(1);

        boolean doesResultDescriptionContainSearchTerm = Pattern.compile(Pattern.quote(searchTerm), Pattern.CASE_INSENSITIVE).matcher(fourteenthResultDescription).find();
        assertTrue((doesResultDescriptionContainSearchTerm), "Result description should contain 'webdriver'");
    }
}