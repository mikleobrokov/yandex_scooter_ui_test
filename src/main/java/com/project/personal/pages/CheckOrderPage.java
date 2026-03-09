package com.project.personal.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOrderPage {

    private final WebDriver driver;

    private final By orderStatusButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");


    public CheckOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOrderIsCreated() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement statusButton = wait.until(ExpectedConditions.visibilityOfElementLocated(orderStatusButton));
        Assert.assertTrue("Кнопка 'Посмотреть статус' не отображается", statusButton.isDisplayed());

    }
}