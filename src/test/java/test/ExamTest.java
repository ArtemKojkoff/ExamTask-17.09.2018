package test;

import page.GoogleSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ExamTest extends BaseTast {




    @Test
    public void searchTest(){
        String serchTerm = "selenium";
        Assert.assertTrue(googlePage.isLoaded(),"GooglePage isn't loaded");

        GoogleSearchPage googleSearchPage = googlePage.enterSelenium("selenium");
        Assert.assertTrue(googleSearchPage.isLoaded(),"GoogleSearchPage isn't loaded");
        Assert.assertEquals(googleSearchPage.getSearchResultsList(),10,"is wrong");

        List<String> searchResults = googleSearchPage.getSearchResultsList();

        for (String searchResult: searchResults) {
            Assert.assertTrue(searchResult.toLowerCase().contains(serchTerm.toLowerCase()),"searchTerm "+serchTerm+" not found in: \n"+searchResult);
        }

        googleSearchPage.nextPage();

        Assert.assertTrue(googleSearchPage.isLoaded(),"GoogleSearchPage isn't loaded");
        Assert.assertEquals(googleSearchPage.getSearchResultsList(),10,"is wrong");

        List<String> searchResults2 = googleSearchPage.getSearchResultsList();

        for (String searchResult: searchResults2) {
            Assert.assertTrue(searchResult.toLowerCase().contains(serchTerm.toLowerCase()),"searchTerm "+serchTerm+" not found in: \n"+searchResult);
        }


    }
}
