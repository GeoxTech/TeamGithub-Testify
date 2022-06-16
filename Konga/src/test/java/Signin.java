import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Signin {

    //Import the Selenium WebDriver
    private WebDriver driver;


            @BeforeTest
            public void start() throws InterruptedException {
                //Locate chromedriver
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

                //1. Open Chrome browser
                //Import Selenuim Webdriver
                driver = new ChromeDriver();

                //2. Input your selenium Demo Page URL (https://www.konga.com/)
                driver.get("https://www.konga.com/");
                //@Test1
                if (driver.getCurrentUrl().contains("https://www.konga.com/"))
                    //Pass
                    System.out.println("Correct Webpage");
                else
                    //Fail
                    System.out.println("Wrong Webpage");

                Thread.sleep(1000);
                //3. Maximize the Chrome browser
                driver.manage().window().maximize();

                // Get the Page title
                System.out.println(driver.getTitle());

                //4. Click the Login /Sign-up button to sign-in
                driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
                //Test@2 Verify that Users inputs the right url and his on the right Webpage
                String expectedUrl = "https://www.konga.com/account/login?return_url=/";
                String actualUrl = driver.getCurrentUrl();
                if (actualUrl.contains(expectedUrl))
                    //Pass
                    System.out.println("Correct Webpage");
                else
                    //Fail
                    System.out.println("Wrong Webpage");

                //5. Wait global for page to fully loading
                Thread.sleep(5000);
            }



            @Test
            public void signIn() throws InterruptedException {
                //6. Register New User Email and Password

                //driver.findElement(By.id("username")).sendKeys("georg61");
                driver.findElement(By.id("username")).sendKeys("george62@mailinator.com");
                driver.findElement(By.id("password")).sendKeys("password@123");

                Thread.sleep(5000);
                //7. Click on the Login button to Sign-In
                driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();

                //Pass
                System.out.println("User logged in successfully");

                Thread.sleep(5000);

            }

    @Test (priority = 1)
    public void logout() throws InterruptedException {
        //11. Click on the My Account button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();

        //Verify that when a User Logs out it directs them back to the homepage
        System.out.println(driver.getTitle());


        Thread.sleep(5000);
        // Then Click on the Logout button to sign-up
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
    }

            @AfterTest
            public void closeBrowser () {
                //Quit the browser
                driver.quit();

            }



}
