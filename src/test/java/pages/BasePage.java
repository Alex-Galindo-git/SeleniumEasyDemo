package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class BasePage {
    //We need to create a ThreadLocal object to be accessed by a specific thread
    private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public String baseUrl;
    public String urlCountry;
    public WebDriverWait pageWait;
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

//        threadLocalDriver.set(driver);
//        pageWait = new WebDriverWait(getDriver(), 15);
        baseUrl = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
        urlCountry ="https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html";
    }

    // added some methods to  make interaction faster
    //    public Actions action = new Actions(driver);
    public Random random = new Random();

    public WebDriverWait wait;//= new WebDriverWait(driver, 60);

    protected <T> void writeText(T element, String text) {
        if (element.getClass().getName().contains("By")) {
            driver.findElement((By) element).sendKeys(text);
        } else {
            ((WebElement) element).sendKeys(text);
        }
    }

    public <T> void scrollToElement(T element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public <T> String readText(T element) {
        if (element.getClass().getName().contains("By")) {
            return driver.findElement((By) element).getText();

        } else {
            return ((WebElement) element).getText();
        }
    }

    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByInt(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public void clickEscapeButton() throws Exception {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);
        driver.switchTo().defaultContent();
    }

    public void hoverClick(WebElement element) {
        Actions action = new Actions(driver);
        if (element.getClass().getName().contains("By")) {
            driver.findElement((By) element);
            action.moveToElement(element);
            action.click().build().perform();

        } else
            System.out.println("Unable to hover and click over this element");
    }

    public <T> void waitForStaleness(T element) {
        if (element.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.stalenessOf((WebElement) element));
        }
    }

    public <T> void waitForInvisibility(T element) {
        if (element.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.invisibilityOf((WebElement) element));
        }
    }

    public <T> void waitForVisibility(T element) {
        if (element.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.visibilityOf((WebElement) element)).click();
        } else {
            System.out.println("Could not find visible element using visibilityOfElement ");
        }
    }

    public <T> void waitForClickable(T element) {
        if (element.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.elementToBeClickable((By) element)).click();
        } else {
            System.out.println("Could not find visible element using visibilityOfElement ");
        }

    }
}