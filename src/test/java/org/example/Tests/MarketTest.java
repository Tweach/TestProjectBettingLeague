package org.example.Tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.example.ConfProperties;
import org.example.Pages.CardProductPage;
import org.example.Pages.MainPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

@Listeners({MarketTest.class})
public class MarketTest extends TestListenerAdapter {
    public static MainPage mainPage;
    public static CardProductPage cardProductPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        cardProductPage = new CardProductPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test(description = "Tests on yandex.market.ru")
    public void marketTest() {
        step1();
        step2();
        step3();
        step4();
        step5();
        step6();
        step7();
        step8();
        step9();
    }

    @Step("Step 1")
    public void step1() {
        mainPage.catalogButtonClick();
        screenshot();
    }

    @Step("Step 2")
    public void step2() {
        mainPage.electronicsButtonClick();
        screenshot();
    }

    @Step("Step 3")
    public void step3() {
        mainPage.TVsButtonClick();
        screenshot();
    }

    @Step("Step 4")
    public void step4() {
        mainPage.inputMinPriceField("20000");
        screenshot();
    }

    @Step("Step 5")
    public void step5() {
        mainPage.clickCheckboxLG();
        screenshot();
    }

    @Step("Step 6")
    public void step6() {
        mainPage.clickCheckboxSamsung();
        screenshot();
    }

    @Step("Step 7")
    public void step7() {
        mainPage.clickFirstSearchResult();
        screenshot();
    }

    @Step("Step 8")
    public void step8() {
        cardProductPage.checkBrandNameSamsungOrLG();
        screenshot();
    }

    @Step("Step 9")
    public void step9() {
        cardProductPage.checkPriceEquals20000OrMore();
        screenshot();
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}