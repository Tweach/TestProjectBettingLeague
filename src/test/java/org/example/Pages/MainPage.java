package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;


public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //кнопка "Каталог"
    @FindBy(xpath = "//span[text()='Каталог']")
    private WebElement catalogButton;

    //кнопка "Электроника"
    @FindBy(xpath = "//img/following-sibling::span[text()='Электроника']")
    private WebElement electronicsButton;

    //кнопка "Телевизоры"
    @FindBy(xpath = "//*[@data-zone-name='link']//*[text()='Телевизоры']")
    private WebElement TVsButton;

    //поле "Минимальная цена"
    @FindBy(xpath = "//input[@name='Цена от']")
    private WebElement minPriceField;

    //чекбокс выбора производителя - "LG"
    @FindBy(xpath = "//span[text()='LG']")
    private WebElement checkboxLG;

    //чекбокс выбора производителя - "Samsung"
    @FindBy(xpath = "//span[text()='Samsung']")
    private WebElement checkboxSamsung;

    //первый результат поиска
    @FindBy(xpath = "//div[@data-apiary-widget-id='/content/results']//article[1]//h3/a")
    private WebElement firstSearchResult;

    //клик по кнопке "Каталог"
    public void catalogButtonClick() {
        catalogButton.click();
    }

    //клик по кнопке "Электроника"
    public void electronicsButtonClick() {
        electronicsButton.click();
    }

    //клик по кнопке "Телевизоры"
    public void TVsButtonClick() {
        TVsButton.click();
    }

    //ввод значения в поле "Минимальная цена"
    public void inputMinPriceField(String minPrice) {
        minPriceField.sendKeys(minPrice);
    }

    //выбор чекбокса производителя "LG"
    public void clickCheckboxLG() {
        checkboxLG.click();
    }

    //выбор чекбокса производителя "Samsung"
    public void clickCheckboxSamsung() {
        checkboxSamsung.click();
    }

    //клик по первому результату поиска
    public void clickFirstSearchResult() {
        waitMaskDisappearance();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-apiary-widget-id='/content/results']//article[1]//h3/a")));
        firstSearchResult.click();

        //обработка перехода в новую вкладку
        ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
        String pageTitle = "Page";
        boolean myNewTabFound = false;
        for (String eachHandle : tabHandles) {
            driver.switchTo().window(eachHandle);
            if (driver.getTitle().equalsIgnoreCase(pageTitle)) {
                myNewTabFound = true;
            }
        }
    }

        //ожидание исчезновения маски обновления страницы
        public void waitMaskDisappearance () {
            WebDriverWait wait2 = new WebDriverWait(driver, 10);
            wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='_2LvbieS_AO _1oZmP3Lbj2']")));
        }
}