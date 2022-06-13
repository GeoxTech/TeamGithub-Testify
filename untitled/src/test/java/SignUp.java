import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignUp {

    @Test
    public void start() throws InterruptedException {
        //Locate chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //1. Open Chrome browser
        //Import Selenuim Webdriver
        WebDriver driver = new ChromeDriver();

        //2. Input your selenium Demo Page URL (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com/");

        Thread.sleep(1000);
        //3. Maximize the Chrome browser
        driver.manage().window().maximize();

        //4. Click the Sign-up button to sign-up
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();

        //5. Wait global for page to fully loading
        Thread.sleep(5000);


        //6. Register New User Email and Password

        driver.findElement(By.id("user_username")).sendKeys("george45");
        driver.findElement(By.id("user_email")).sendKeys("george45@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("password@123");

        Thread.sleep(5000);
        //7. Click on the Login button to Sign-In
        driver.findElement(By.id("submit")).click();

        Thread.sleep(5000);
        //8. Click on User1 article after signed in
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();

        //9. Get text "Welcome to User1's Page
        driver.findElement(By.xpath("/html/body/div[2]/h1")).getText();

        Thread.sleep(5000);
        //10. Kindly locate and click on the Learn XPath link
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();

        Thread.sleep(5000);
        //11. Click on the Logout button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

        //12. Wait global for page to fully loading
        Thread.sleep(5000);


        //Quit the browser
        driver.quit();
    }

}
