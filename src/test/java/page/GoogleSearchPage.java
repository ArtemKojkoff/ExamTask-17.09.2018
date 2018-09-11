package page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class GoogleSearchPage extends BasePage {


    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
   private List<WebElement> searchResults;

  @FindBy(xpath = "//a[@aria-label='page 2']")
  private WebElement buttonPage2;


    public GoogleSearchPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
        waitUntilElementIsVisible(buttonPage2, 20);
    }



 private int getSearchResultCount(){
     return searchResults.size();
 }
    public List<String> getSearchResultsList() {
        List<String> searchResaltsList = new ArrayList<String>();
        for (WebElement searchResult: searchResults){
            ((JavascriptExecutor)browser).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResaltsList.add(searchResult.getText());
        }
        return searchResaltsList;
    }

    public void nextPage(){
     buttonPage2.click();
    }



    public boolean isLoaded() {
        return getCurrentPageTitle().contains("selenium - Поиск в Google")
                && getCurrentPageUrl().contains("https://www.google.com/search?");
    }


}
