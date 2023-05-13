package com.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disabled-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://ssc.nic.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
