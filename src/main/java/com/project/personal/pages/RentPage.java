package com.project.personal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentPage {

    private final WebDriver driver;

    private final By orderDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private final By rentalPeriodOneDay = By.xpath(".//div[text()='сутки']");
    private final By rentalPeriodThreeDays = By.xpath(".//div[text()='трое суток']");
    private final By orderDateFirst = By.xpath(".//div[@aria-label='Choose суббота, 25-е октября 2025 г.']");
    private final By orderDateSecond = By.xpath(".//div[@aria-label='Choose понедельник, 27-е октября 2025 г.']");
    private final By scooterColorBlack = By.xpath(".//input[@id='black']");
    private final By scooterColorGrey = By.xpath(".//input[@id='grey']");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRentInfo(String orderDate, String rentalPeriod, String scooterColor, String comment) {
        selectOrderDate(orderDate);
        selectRentalPeriod(rentalPeriod);
        selectScooterColor(scooterColor);
        enterComment(comment);
    }

    public void selectOrderDate(String date) {
        driver.findElement(orderDateField).click();


        By dateLocator;
        if ("25.10.2025".equals(date)) {
            dateLocator = orderDateFirst;
        } else {
            dateLocator = orderDateSecond;
        }

        driver.findElement(dateLocator).click();
    }

    public void selectRentalPeriod(String period) {
        driver.findElement(rentalPeriodField).click();


        By periodLocator;
        if ("сутки".equals(period)) {
            periodLocator = rentalPeriodOneDay;
        } else {
            periodLocator = rentalPeriodThreeDays;
        }

        driver.findElement(periodLocator).click();
    }

    public void selectScooterColor(String color) {

        By colorLocator;
        if ("black".equals(color)) {
            colorLocator = scooterColorBlack;
        } else {
            colorLocator = scooterColorGrey;
        }

        driver.findElement(colorLocator).click();
    }

    public void enterComment(String comment) {
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOnOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickOnYesButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }

    public void confirmOrder() {
        clickOnOrderButton();
        clickOnYesButton();
    }
}
