package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Paramatrization {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    public void browser_setup(String browser,String url) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            Thread.sleep(4000);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            Thread.sleep(4000);

        }
    }

        @Test(priority = 1)
    public void enter_login_credential() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");


    }
    @Test(priority = 2)
    public void click_on_login_button(){
        driver.findElement(By.tagName("button")).click();
    }

    @AfterClass
    public void quit_browser(){
        if(driver!=null){
            driver.quit();
        }
    }
}
