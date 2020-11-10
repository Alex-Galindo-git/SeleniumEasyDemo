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


}
