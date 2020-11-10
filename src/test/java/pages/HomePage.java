package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /*
    From this URL: https://www.seleniumeasy.com/test/basic-first-form-demo.html
         1. There will be a marketing modal that pops up. Your code should handle this case and click "No"
         2. Set the value of id user-message to "QA assessment trial #1"
         3. Click 'Show Message'
         4. Assert that "Your Message" matches "QA assessment trial #1"
 */
    @FindBy(linkText = "No, thanks!")
    public WebElement NoOption_PopUpBtn;

    @FindBy(css = "input#user-message")
    public WebElement InputMessageField;

    @FindBy(css = "form#get-input > .btn.btn-default")
    public WebElement ShowMessageBtn;

    @FindBy(css = "span#display")
    public WebElement DisplayMessage;

    public void goToPage() throws Exception {
        driver.get(baseUrl);
        System.out.println("Opening page,... testing Url waiting to load elements... ... ");
        Thread.sleep(6000);
    }

       public void clickNoOnModalPopUp() throws Exception {
//         this is finding element through list  works through iterating through DOM elements!!
        List<WebElement> isList = driver.findElements(By.cssSelector(".at-cm-no-button"));
        if (!isList.isEmpty()) {
            System.out.println("A popUp has displayed");
            WebElement is = isList.get(0);
            (is).click();
            System.out.println("The modal element 'no thanks' was clicked and closed...");
        } else {
            System.out.println("The element was not seen in DOM ,please find error since Pop up was not closed on this test case");
        }
    }

    public void enterAndShowInputMessageField() throws Exception {
        InputMessageField.clear();
        InputMessageField.sendKeys("QA assessment trial #1");
//        System.out.println("The 'input field message was entered :" + "QA assessment trial #1");
        ShowMessageBtn.click();
        Thread.sleep(2000);//pause for demo purpose to
      //  Assert.assertEquals("QA assessment trial #1","QA assessment trial #1");
    }


//    @Test
//    public void multiSelectDelewareAndVermont() {
//
//    }
//
//    @Test
//    public void validateDisabledValuesSelect() {
//
//    }
}