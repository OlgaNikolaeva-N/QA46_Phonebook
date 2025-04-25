package com.phonebookHW.fw;

import com.phonebookHW.utilshw.MyListenerHW;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationMenagerHomeWork{
    String browser;
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(ApplicationMenagerHomeWork.class);
    UserHelperHomeWork user;
    ContactHelperHomeWork contact;
    HomePageHelperHomeWork home;

    public ApplicationMenagerHomeWork(String browser) {

        this.browser=browser;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Test start in Chrome browser");
        }else if (browser.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
            logger.info("Test start in Firefox browser");
        }else if (browser.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
            logger.info("Test start in Edge browser");
        }
        WebDriverListener listener = new MyListenerHW();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        driver.get("https://telranedu.web.app/home");
        logger.info("Current url-->"+driver.getCurrentUrl());
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

    public void setUser(UserHelperHomeWork user) {
        this.user = user;
    }

    public void setContact(ContactHelperHomeWork contact) {
        this.contact = contact;
    }

    public void setHome(HomePageHelperHomeWork home) {
        this.home = home;
    }
}
