package com.step_it.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWebDriverManager {
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        if (driver == null) startDriver();
        return driver;
    }

    public static void startDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        EventFiringWebDriver driverWithEvents = new EventFiringWebDriver(driver);
//        driverWithEvents.register(new CustomEventListener());
//        driver = driverWithEvents;
        new WebDriverWait(driver, Duration.ofSeconds(5));

        Listener listener = new Listener();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(listener);
        driver = decorator.decorate(driver);

    }
    public static void quitDriver(){
        getDriver().quit();
    }
}
