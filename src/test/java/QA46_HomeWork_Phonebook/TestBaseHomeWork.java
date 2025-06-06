package QA46_HomeWork_Phonebook;

import com.phonebookHW.fw.ApplicationMenagerHomeWork;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBaseHomeWork {

    Logger logger = LoggerFactory.getLogger(TestBaseHomeWork.class);


    protected static ApplicationMenagerHomeWork appHW = new ApplicationMenagerHomeWork
            (System.getProperty("browser", Browser.CHROME.browserName()));

    @BeforeSuite(enabled = false)
    //@BeforeMethod
    public void setUp(){
        appHW.init();
    }

    @AfterSuite
    //@AfterMethod(enabled = false)
    public void tearDown(){

        appHW.stop();

    }
    @BeforeMethod
    public void startTest(Method method,Object[]p){

        logger.info("Start test"+ method.getName()+ Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()){
            logger.info("PASSED: " + result.getMethod().getMethodName());
        }
        else {
            logger.error("FAILED: "+ result.getMethod().getMethodName()+" Screensot path: "+appHW.getUser().takeScreenshotHW());
        }
        logger.info("Stop test");
        logger.info("**********************************************************");
    }

}
