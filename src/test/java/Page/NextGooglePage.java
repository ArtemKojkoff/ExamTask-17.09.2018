package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class NextGooglePage extends BasePage {

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults2;

    @FindBy(xpath = "//a[@aria-label='Page 1']")
    private WebElement buttonPage1;

    public NextGooglePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
        waitUntilElementIsVisible(buttonPage1, 10);
    }

    private int getSearchResultCount(){
        return searchResults2.size();
    }
    public List<String> getSearchResultsList() {
        List<String> searchResaltsList = new ArrayList<String>();
        for (WebElement searchResult: searchResults2){
            ((JavascriptExecutor)browser).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResaltsList.add(searchResult.getText());
        }
        return searchResaltsList;
    }






    public boolean isLoaded() {
        return getCurrentPageTitle().contains("selenium - Поиск в Google")
                && getCurrentPageUrl().contains("https://www.google.com/search?");
    }

}
