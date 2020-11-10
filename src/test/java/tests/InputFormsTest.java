package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InputForms;

public class InputFormsTest extends BaseDriver {
    InputForms inputForms;

    @Test(priority = 1)
    public void clickCheckBoxesAndValidateSelection() throws Exception {
        inputForms = new InputForms(driver);

        inputForms.clickCheckboxTestMenu();
        Assert.assertEquals(driver.getCurrentUrl(), ("https://www.seleniumeasy.com/test/basic-checkbox-demo.html"));
        inputForms.multiCheckBoxTestValidationAndThenClickEachBox();

    }

    @Test(priority = 2)
    public void selectDropDownOption() throws Exception {
        inputForms.selectJapanTest();
    }
}