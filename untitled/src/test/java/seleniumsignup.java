import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleniumsignup {

    //Import the Selenium WebDriver
    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {
        //Locate chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //1. Open Chrome browser
        //Import Selenuim Webdriver
        driver = new ChromeDriver();

        //2. Input your selenium Demo Page URL (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com/");
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");

        Thread.sleep(1000);
        //3. Maximize the Chrome browser
        driver.manage().window().maximize();

        //4. Click the Sign-up button to sign-up
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Test@2 Verify that Users inputs the right url and his on the right Webpage
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
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
        public void signUp() throws InterruptedException {
            //6. Register New User Email and Password

            driver.findElement(By.id("user_username")).sendKeys("georg58");
            driver.findElement(By.id("user_email")).sendKeys("george58@mailinator.com");
            driver.findElement(By.id("user_password")).sendKeys("password@123");

            Thread.sleep(5000);
            //7. Click on the Login button to Sign-In
            driver.findElement(By.id("submit")).click();


        }

        @Test (priority = 1)
        public void clickUser() throws InterruptedException {
            Thread.sleep(5000);
            //8. Click on User1 article after signed in
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();


            //9. Get text "Welcome to User1's Page
            driver.findElement(By.xpath("/html/body/div[2]/h1")).getText();

            //@Test9 Confirm page title
            String expectedpageUrl ="https://selenium-blog.herokuapp.com/users/1";
            String actualPageurl = driver.getCurrentUrl();
            if (actualPageurl.contains(expectedpageUrl))
                //Pass
                System.out.println("Correct Useer1 Url");
            else
                //Fail
                System.out.println("Wrong User1 Url");

        }

        @Test (priority = 2)
        public void verifyelement() throws InterruptedException {
            Thread.sleep(5000);
            //10. Kindly locate and click on the Learn XPath link
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            Thread.sleep(5000);

            String expectedUrl = "https://selenium-blog.herokuapp.com/articles/59";
            String actualUrl = driver.getCurrentUrl();
            if (expectedUrl.contains(actualUrl))
                //Pass
                System.out.println("Learning XpathUrl Passed");
            else
                //Fail
                System.out.println("Learning XpathUrl Failed");

        }
        @Test (priority = 3)
        public void logout() {
            //11. Click on the Logout button
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

            //@Test10 Verify that when a User Logs out it directs them back to the homepage
            String expectedTitle = "AlphaBlog";
            String actualTitle = driver.getTitle();
            if (expectedTitle.contains(actualTitle))
                //Pass
                System.out.println("Correct Webpage Title");
            else
                //Fail
                System.out.println("Wrong Webpage Title");

            // Re-Click the Sign-up button to sign-up
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        }

        @Test (priority = 4)
        public void negativesignUp() throws InterruptedException {

            //12. Wait global for page to fully loading
            Thread.sleep(5000);

            //6. Verify that Users cannot sign register with less than 3 character


            driver.findElement(By.id("user_username")).sendKeys("ge");
            driver.findElement(By.id("user_email")).sendKeys("george50@mailinator.com");
            driver.findElement(By.id("user_password")).sendKeys("password@123");

            Thread.sleep(5000);
            //7. Click on the Login button to Sign-In
            driver.findElement(By.id("submit")).click();

        }

        @AfterTest
        public void closeBrowser () {
            //Quit the browser
            driver.quit();

        }

    }


