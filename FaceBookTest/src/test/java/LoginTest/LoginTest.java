package LoginTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginTest {

    //Import Selenuimdriver
    private WebDriver driver;

    @Test
    public void start() throws InterruptedException {
        //Locate chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //1. Open Chrome browser
        driver = new ChromeDriver();

        //2. Input your selenium Demo Page URL (https://facebook.com/)
        driver.get("https://facebook.com/");

        //5. Maximize the Chrome browser
        driver.manage().window().maximize();

        //4. Wait global for page to fully loading
        Thread.sleep(10000);


        //@AfterTest

            //Quit the browser
            driver.quit();


        }
}