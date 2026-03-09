package com.project.personal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClientRegistrationPage {

    private final WebDriver driver;

    private final By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By metroDropdown = By.xpath(".//div[@class='select-search__select']");

    public ClientRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillClientInfo(String firstName, String lastName, String address, String metroStation, String telephone) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        selectMetroStation(metroStation);
        enterTelephone(telephone);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    public void selectMetroStation(String metroStationName) {
        driver.findElement(metroStationField).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(metroDropdown));

        By stationLocator = By.xpath(".//div[text()='" + metroStationName + "']");
        driver.findElement(stationLocator).click();
    }

    public void enterTelephone(String telephone) {
        driver.findElement(telephoneField).clear();
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    public void clickOnNextButton() {
        driver.findElement(nextButton).click();
    }
}
