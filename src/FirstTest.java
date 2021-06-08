import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
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

        waitClickBy(By.xpath("//*[contains(@text, 'Search Wikipedia')]"), "Can't find: Search Wikipedia", 5);
        waitSendBy(By.xpath("//*[contains(@text, 'Search…')]"), "Java", "Can't find: Search", 5);
        waitForBy(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"), "Can't find: Object-oriented programming language", 15);
    }

    @Test
    public void xTest(){

        waitClickBy(By.id("org.wikipedia:id/search_container"), "Can't find: Search Wikipedia", 5);
        waitSendBy(By.xpath("//*[contains(@text, 'Search…')]"), "Java", "Can't find: Search", 5);
        waitClear(By.id("org.wikipedia:id/search_src_text"),"Can't find text",15);
        waitClickBy(By.id("org.wikipedia:id/search_close_btn"), "Can't find X", 5);
        waitNotYet(By.id("org.wikipedia:id/search_close_btn"), "Can't find X", 5);
    }

//    @Test
//    public void article(){
//        waitClickBy(By.xpath("//*[contains(@text, 'Search Wikipedia')]"), "Can't find: Search Wikipedia", 5);
//        waitSendBy(By.xpath("//*[contains(@text, 'Search…')]"), "Java", "Can't find: Search", 5);
//        waitClickBy(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"), "Can't find: Object-oriented programming language", 5);
//        assertElementHasText(By.id("org.wikipedia:id/view_page_title_text"), "Can't find article",15);
//    }

    @Test
    public void testEx2(){
        waitClickBy(By.xpath("//*[contains(@text, 'Search Wikipedia')]"), "Can't find: Search Wikipedia", 5);
        assertElementHasText(By.xpath("//*[contains(@text, 'Search…')]"), "Can't find Search...",15);
    }

    private WebElement waitForBy (By by, String err_msg, long timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(err_msg + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForBy (By by, String err_msg){

        return waitForBy(by, err_msg, 5);
    }

    private  WebElement waitClickBy(By by, String err_msg, long timeOut){

        WebElement element = waitForBy(by, err_msg, timeOut);
        element.click();
        return element;
    }

    private  WebElement waitSendBy(By by, String value, String err_msg, long timeOut){

        WebElement element = waitForBy(by, err_msg, timeOut);
        element.sendKeys(value);
        return element;
    }

    private boolean waitNotYet (By by, String err_msg, long timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
                wait.withMessage(err_msg + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitClear(By by, String err_msg, long timeOut){
        WebElement element = waitForBy(by, err_msg, timeOut);
        element.clear();
        return element;
    }

    private WebElement assertElementHasText(By by, String err_msg, long timeOut){
        WebElement element = waitForBy(by, err_msg, timeOut);
        String article_title = element.getAttribute("text");
        Assert.assertEquals("We see it", "Search…", article_title);
        return element;
    }
}
