package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseDriver{
    String CorrectMessageExpected = "QA assessment trial #1";
    String ActualMessage = "QA assessment trial #1";
    HomePage seleniumEasy;


    @Test(priority = 0)
    public void enterMessageAndShouldHaveCorrectMessage() throws Exception {

        seleniumEasy = new HomePage(driver);
        seleniumEasy.goToPage();

        seleniumEasy.clickNoOnModalPopUp();
        seleniumEasy.enterAndShowInputMessageField();
        Assert.assertEquals(ActualMessage, CorrectMessageExpected);
    }

    @Test(priority = 1)
    public void clickCheckBoxesAndValidateSelection() throws Exception {
        seleniumEasy.clickCheckboxTestMenu();
        Assert.assertEquals(driver.getCurrentUrl(),( "https://www.seleniumeasy.com/test/basic-checkbox-demo.html"));
        seleniumEasy.multiCheckBoxTestValidationAndThenClickEachBox();

    }
    @Test(priority = 2)
    public void selectDropDownOption() throws Exception {
        seleniumEasy.selectJapanTest();




    }
}
