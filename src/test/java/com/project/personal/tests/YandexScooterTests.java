package com.project.personal.tests;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import com.project.personal.pages.*;

@RunWith(Parameterized.class)
public class YandexScooterTests {

    @Rule
    public DriverFactory factory = new DriverFactory();

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String telephone;
    private final String comment;
    private final String rentalPeriod;
    private final String orderDate;
    private final String scooterColor;
    private final boolean isHeaderButton;

    public YandexScooterTests(String firstName, String lastName, String address, String metroStation,
                              String telephone, String comment, String rentalPeriod, String orderDate,
                              String scooterColor, boolean isHeaderButton) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.comment = comment;
        this.rentalPeriod = rentalPeriod;
        this.orderDate = orderDate;
        this.scooterColor = scooterColor;
        this.isHeaderButton = isHeaderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {
                        "Иван",
                        "Иванов",
                        "Москва, Ленинский проспект, 35",
                        "Ленинский проспект",
                        "89259998877",
                        "Позвонить при доставке",
                        "сутки",
                        "25.10.2025",
                        "black",
                        true
                },
                {
                        "Мария",
                        "Петрова",
                        "Москва, Сокольническая площадь, 9",
                        "Сокольники",
                        "89167776655",
                        "Оставить у двери",
                        "трое суток",
                        "27.10.2025",
                        "grey",
                        false
                }
        };
    }

    @Test
    public void testPositiveScooterOrderingScenario() {
        WebDriver driver = factory.getDriver();

        OrderPage orderPage = new OrderPage(driver);
        ClientRegistrationPage clientRegistrationPage = new ClientRegistrationPage(driver);
        RentPage rentPage = new RentPage(driver);
        CheckOrderPage checkOrderPage = new CheckOrderPage(driver);


        orderPage.openMainPage();
        orderPage.clickOnOrderButton(isHeaderButton);
        clientRegistrationPage.fillClientInfo(firstName, lastName, address, metroStation, telephone);
        clientRegistrationPage.clickOnNextButton();
        rentPage.fillRentInfo(orderDate, rentalPeriod, scooterColor, comment);
        rentPage.confirmOrder();

        checkOrderPage.checkOrderIsCreated();
    }

    @After
    public void tearDown() {
        factory.getDriver().quit();
    }
}
