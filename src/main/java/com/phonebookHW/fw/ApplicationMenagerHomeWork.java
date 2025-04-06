package com.phonebookHW.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationMenagerHomeWork{
    String browser;
    WebDriver driver;
    UserHelperHomeWork user;
    ContactHelperHomeWork contact;
    HomePageHelperHomeWork home;

    public ApplicationMenagerHomeWork(String browser) {
        this.browser=browser;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
        }
        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelperHomeWork(driver);
        contact = new ContactHelperHomeWork(driver);
        home = new HomePageHelperHomeWork(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelperHomeWork getUser() {
        return user;
    }

    public ContactHelperHomeWork getContact() {
        return contact;
    }

    public HomePageHelperHomeWork getHome() {
        return home;
    }

}
