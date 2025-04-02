package com.phonebookHW.fw;

import com.phonebook.fw.ContactHelper;
import com.phonebook.fw.HomePageHelper;
import com.phonebook.fw.UserHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationMenagerHomeWork {
    String browser;
    WebDriver driver;
    UserHelperHW user;
    ContactHelperHW contact;
    HomePageHelperHW home;
    public ApplicationMenagerHomeWork(String browser) {

        this.browser = browser;
    }

    public void setUser(UserHelperHW user) {

        this.user = user;
    }

    public void setContact(ContactHelperHW contact) {

        this.contact = contact;
    }

    public void setHome(HomePageHelperHW home) {

        this.home = home;
    }

    public UserHelperHW getUser() {
        return user;
    }

    public ContactHelperHW getContact() {
        return contact;
    }

    public HomePageHelperHW getHome() {
        return home;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        user = new UserHelperHW(driver);
        contact = new ContactHelperHW(driver);
        home = new HomePageHelperHW(driver);
    }
    public void stop() {
        driver.quit();
    }



}
