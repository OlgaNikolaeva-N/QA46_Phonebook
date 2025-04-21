package com.phonebook.fw;

import com.phonebook.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationMenager {
    String browser;
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(ApplicationMenager.class);
    UserHelper user;
    ContactHelper contact;
    HomePageHelper home;

    public ApplicationMenager(String browser) {

        this.browser = browser;
    }


    public UserHelper getUser() {
        return user;
    }

    public void setUser(UserHelper user) {
        this.user = user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public void setContact(ContactHelper contact) {
        this.contact = contact;
    }

    public HomePageHelper getHome() {
        return home;
    }

    public void setHome(HomePageHelper home) {
        this.home = home;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            logger.info("Test start in Chrome browser");
        }else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            logger.info("Test start in Firefox browser");
        }else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            logger.info("Test start in Edge browser");
        }
        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.get("https://telranedu.web.app/home");
        logger.info("Current url-->"+driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        home = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

}
