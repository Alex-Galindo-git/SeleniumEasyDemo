package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
            System.out.println("A popUp has displayed, will be closed shortly...");
            WebElement is = isList.get(0);
            (is).click();
            System.out.println("The PopUp element was clicked and closed...");
        } else {
            System.out.println("The element was not seen in DOM ,please find error since Pop was not closed on this test case");
        }
    }

    public void enterAndShowInputMessageField() throws Exception {
        InputMessageField.clear();
        InputMessageField.sendKeys("QA assessment trial #1");
        System.out.println("The 'input field message was entered :" + "QA assessment trial #1");
        ShowMessageBtn.click();
        Thread.sleep(2000);//pause for demo purpose to
//        Assert.assertEquals("QA assessment trial #1","QA assessment trial #1");
    }

    /*
    From this URL: https://www.seleniumeasy.com/test/basic-first-form-demo.html.
     Your next test should:
        1. Interact with the menu on the left of the page and click "Input Forms"
        2. On the sub-menu, click "Checkbox Demo"
        3. Under "Multiple Checkbox Demo" there are "product requirements" for check/uncheck all,
           come up with a test assertion to test this functionality.
*/
    @FindBy(xpath = "//ul[@id='treemenu']/li/ul/li[1]/a[@href='#']")
    public WebElement InputFormsMenu;
    @FindBy(xpath = "//ul[@id='treemenu']/li/ul/li[1]/ul//a[@href='./basic-checkbox-demo.html']")
    public WebElement CheckBoxMenu;

    public void clickCheckboxTestMenu() {

        try {
            InputFormsMenu.click();
            System.out.println("Clicking on Left MenuInput Form to display DropDown Options");
            scrollToElement(CheckBoxMenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(css = "input#check1")
    public WebElement CheckAllBtn;
    //**adding checkboxes as Lists to make sure they re read by webdriver to see if they are UNselected!!**
//Boolean checkIfElementPresent= driver.findElements(By.xpath("//input[@id='checkbox2']")).size()!= 0;

    @FindBy(xpath = "//div[@id='easycont']//div[@class='col-md-6 text-left']/div[2]/div[@class='panel-body']/div[1]/label")
    public WebElement optionOne;
    @FindBy(xpath = "//div[@id='easycont']//div[@class='col-md-6 text-left']/div[2]/div[@class='panel-body']/div[2]/label")
    public WebElement optionTwo;
    @FindBy(xpath = "//div[@id='easycont']//div[@class='col-md-6 text-left']/div[2]/div[@class='panel-body']/div[3]/label")
    public WebElement optionThree;
    @FindBy(xpath = "//div[@id='easycont']//div[@class='col-md-6 text-left']/div[2]/div[@class='panel-body']/div[4]/label")
    public WebElement optionFour;

    public void multiCheckBoxTestValidationAndThenClickEachBox() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(2000);
            CheckAllBtn.isDisplayed();
            //Seeing Options 1 through 5 unselected ,'Check All ' willbe selected********

            if (!optionOne.isSelected() && !optionTwo.isSelected() && !optionThree.isSelected() && !optionFour.isSelected())
                System.out.println("Checkboxes Not selected by default");
            Thread.sleep(3000);
            scrollToElement(CheckAllBtn);
            System.out.println("clicking on Check All btn after verifying all previous 4 Checkboxes were UNselected.");

            optionOne.isSelected();
            Thread.sleep(2000);
            optionTwo.isSelected();
            Thread.sleep(2000);
            optionThree.isSelected();
            Thread.sleep(2000);
            optionFour.isSelected();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    In real life we wouldn't waste precious seconds to mouse nav, sorry to make you do that.
    The next test is working with selectors but it would be far too easy to use native selects.
    My final test for you is to work with jquery selects.
        1. From this URL: https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html
        2. Under the country select Japan & assert the field value is Japan
        3. Under the multi select select Delaware & Vermont & assert the field values
        4. Under US Outlying Territories assert that Guam & United States Minor Outlying Islands are disabled
*/

    @FindBy(css = ".select2.select2-container.select2-container--below.select2-container--default  span[role='combobox']")
    public WebElement CountryDropDown;
    @FindBy(css = "//*[@id='select2-country-results']/li[7]']")
    public WebElement CountryJapan;

    @FindBy(css = "input[role='textbox']")
    public WebElement multiSelect;

    public void goToSearchCountry() throws Exception {
        driver.get(urlCountry);
        System.out.println("Opening page,... ");
        Thread.sleep(6000);
    }

    public void selectJapanTest() throws InterruptedException {

        driver.get(urlCountry);
        System.out.println("Opening page,... testing Url waiting to load elements... ... ");
        Thread.sleep(3000);
        try {
            scrollToElement(CountryDropDown);
            CountryJapan.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
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