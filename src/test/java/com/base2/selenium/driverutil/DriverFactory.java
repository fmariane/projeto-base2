package com.base2.selenium.driverutil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver getBrowser() {

        WebDriver _driver = null;
        String _browserName = System.getProperty("browser", DriverType.CHROME.toString()).toUpperCase();
        DriverType _driverType = DriverType.valueOf(_browserName);

        switch (_driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                _driver = new ChromeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                _driver = new ChromeDriver();
                break;
        }
        _driver.manage().window().maximize();
        _driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return _driver;
    }
}
