package QA46_HomeWork_Phonebook;

import com.phonebookHW.fw.ApplicationMenagerHomeWork;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBaseHomeWork {


    protected static ApplicationMenagerHomeWork appHW = new ApplicationMenagerHomeWork
            (System.getProperty("browser", Browser.CHROME.browserName()));

    @AfterSuite
    //@BeforeMethod
    public void setUp(){
        appHW.init();
    }

    @BeforeSuite(enabled = false)
    //@AfterMethod(enabled = false)
    public void tearDown(){

        appHW.stop();
    }

}
