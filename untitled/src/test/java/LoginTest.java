import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {


   @Test
   public void start() throws InterruptedException {
        //Locate chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //1. Open Chrome browser
        //Import Selenuimdriver
        WebDriver driver = new ChromeDriver();

        //2. Input your selenium Demo Page URL (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com/");

        Thread.sleep(1000);
        //3. Maximize the Chrome browser
        driver.manage().window().maximize();

        //4. Click the login button to sign-in
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div/a[1]")).click();


        //6. Register New User Email and Password
        Thread.sleep(5000);
        driver.findElement(By.id("session_email")).sendKeys("george43@mailinator.com");
        driver.findElement(By.id("session_password")).sendKeys("password@123");

        Thread.sleep(5000);
        //7. Click on the Login button to Sign-In
        driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/div/input")).click();

        Thread.sleep(5000);
        //9. Get text "Welcome to George43's Page
        driver.findElement(By.xpath("/html/body/div[2]/h1")).getText();

        //11. Click on the Logout button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

        //12. Wait global for page to fully loading
        Thread.sleep(5000);

        //Quit the browser
        driver.quit();


    }

}
