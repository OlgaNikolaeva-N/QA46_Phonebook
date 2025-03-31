package com.phonebook.tests;

import com.phonebook.fw.ApplicationMenager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationMenager app = new ApplicationMenager(System.getProperty("browser", Browser.CHROME.browserName()));
    //@BeforeMethod
    @BeforeSuite
    public void setUp(){
        app.init();
    }

    //@AfterMethod
    @AfterSuite(enabled = false)
    public void tearDown(){
        app.stop();
    }


}

