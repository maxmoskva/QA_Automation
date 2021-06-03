import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","And80");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/Maxx/Documents/QA_Automation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void firstTest(){


        WebElement element_init = waitFor("//*[contains(@text, 'Search Wikipedia')]", "Can't find: Search Wikipedia", 5);

                //driver.findElementByXPath("//*[contains(@text, 'Search Wikipedia')]");
        element_init.click();

        WebElement element_search = waitFor("//*[contains(@text, 'Search…')]", "Can't find: Search");

                //driver.findElementByXPath("//*[contains(@text, 'Search…')]");
        element_search.sendKeys("Java");

        waitFor("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']", "Can't find: Object-oriented programming language", 15);
        //System.out.println("First test run");
    }

    private WebElement waitFor (String xPath, String err_msg, long timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(err_msg + "\n");
        By by = By.xpath(xPath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitFor (String xPath, String err_msg){

        return waitFor(xPath, err_msg, 5);
    }
}
