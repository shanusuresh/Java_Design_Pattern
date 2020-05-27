package com.learn.designpattern.tests.factory;

import com.learn.designpattern.tests.srp.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebDriverFactoryTest {

    private WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @Test
    public void openGoogle(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
