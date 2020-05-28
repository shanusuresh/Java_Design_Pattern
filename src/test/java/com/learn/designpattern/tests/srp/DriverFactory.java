package com.learn.designpattern.tests.srp;

import com.learn.designpattern.tests.factory.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<DriverType,Supplier<WebDriver>> driverMap = new HashMap<>();

    //chrome driver supplier
    private static final Supplier<WebDriver> chromeDriverSupplier =()->{
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    };

    //firefox driver supplier
    private static final Supplier<WebDriver> firefoxDriverSupplier = () ->{
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
        return new FirefoxDriver();
    };

    //add all the drivers into a map
    static{
        driverMap.put(DriverType.CHROME,chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX,firefoxDriverSupplier);
    }

    //return a new driver from the map
    public static final WebDriver getDriver(DriverType type){
        return driverMap.get(type).get();
    }
}
