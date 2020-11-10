package tests;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseDriver {

    public WebDriverWait wait;
    public WebDriver driver;

    @BeforeTest
    public void setupBrowserUrl() {
        // setup the chromedriver using WebDriverManager for demo purposes * environments not set.

        chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        wait = new WebDriverWait(driver, 45, 1000);

    }

    public void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

//    @AfterMethod
//    public void AfterMethodLevelSetup(ITestResult result) throws Exception {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            utils.Screenshot.captureFailScreenshot(result.getName());
//            System.out.println("Method failed:" + result.getName());
//        }
//        if (ITestResult.SUCCESS == result.getStatus()) {
//            System.out.println("Method Successful:" + result.getName());
//            utils.Screenshot.captureScreenShotWithURL();
//            Thread.sleep(1200);
//        }
//    }

    @AfterTest
    public void afterTest(ITestContext testContext) {
        System.out.println("Finishing up running tests" + testContext.getName() + ">");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test: afterSuite");
//        driver.quit();
        driver.close();
    }

}