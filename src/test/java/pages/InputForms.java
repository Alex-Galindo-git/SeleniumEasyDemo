package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputForms extends BasePage {

    public InputForms(WebDriver driver) {
        super(driver);
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
            System.out.println("clicking on Check All btn after verifying all previous 4 Checkboxes were Unselected.");

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

     private String radioUrl = "https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
    private String SelectUrl = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
    private String InputFormUrl = "https://www.seleniumeasy.com/test/input-form-demo.html";
    private String AjaxFormUrl = "https://www.seleniumeasy.com/test/ajax-form-submit-demo.html";
    private String JquerySelectUrl = "https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html";

    public void goToRadioBtnLink() {
        driver.get(SelectUrl);
    }

    public void goToSelectDropDownBtnLink() {
        driver.get(InputFormUrl);
    }

    public void goToInputFormSubmitBtnLink() {
        driver.get(AjaxFormUrl);
    }

    public void goToAjaxFormSubmitBtnLink() {
        driver.get(JquerySelectUrl);
    }

    public void goToJquerySelectBtnLink() {
        driver.get(radioUrl);
    }

     /*

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


}
