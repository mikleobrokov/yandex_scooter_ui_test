package com.project.personal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private final WebDriver driver;

    private final By cookieButton = By.xpath(".//button[text()='да все привыкли']");
    private final By orderHeaderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    private final By orderMainButton = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        closeCookieBanner();
    }

    public void clickOnOrderButton(boolean isHeaderButton) {
        By orderButton = isHeaderButton ? orderHeaderButton : orderMainButton;
        driver.findElement(orderButton).click();
    }

    private void closeCookieBanner() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
    }
}
