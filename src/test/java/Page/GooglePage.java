package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement queryField;





    public GoogleSearchPage enterSelenium(String text){
        queryField.sendKeys("selenium");
        queryField.sendKeys(Keys.ENTER);
        return new GoogleSearchPage(browser);

    }



    public GooglePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
      //  waitUntilElementIsVisible(alertBox, 10);
    }

    public boolean isLoaded() {
        return queryField.isDisplayed()
                && getCurrentPageTitle().contains("Google")
                && getCurrentPageUrl().contains("https://www.google.com/");
    }

}
