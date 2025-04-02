package QA46_HomeWork_Phonebook;

import com.phonebookHW.fw.ApplicationMenagerHomeWork;
import com.phonebookHW.models.ContactHomeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.List;

public class TestBaseHomeWork {


    protected static ApplicationMenagerHomeWork appHW = new ApplicationMenagerHomeWork
            (System.getProperty("browser", Browser.CHROME.browserName()));

    //@BeforeMethod
    @BeforeSuite
    public void setUp(){

        appHW.init();
    }

    //@AfterMethod
    @AfterSuite(enabled = false)
    public void TearDown(){

        appHW.stop();
    }


}
