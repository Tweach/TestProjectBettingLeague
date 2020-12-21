package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardProductPage {
    public WebDriver driver;

    public CardProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //имя производителя "Samsung" или "LG"
    @FindBy(xpath = "//*[@data-apiary-widget-id='/content/productCardTitle']//h1[contains(text(), 'Samsung') or contains(text(), 'LG')]")
    private WebElement brandNameSamsungOrLG;

    //цена соответствует параметрам поиска
    @FindBy(xpath = "//*[@data-zone-name='cpa-offer']//*[@data-autotest-value>='20']")
    private WebElement priceEquals20000OrMore;

    //проверка имени производителя "Samsung" или "LG"
    public void checkBrandNameSamsungOrLG () {
        brandNameSamsungOrLG.isEnabled();
    }

    //проверка соответствия цены 20000 или более
    public void checkPriceEquals20000OrMore () {
        priceEquals20000OrMore.isEnabled();
    }
}