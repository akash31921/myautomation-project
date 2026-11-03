package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_test_practice {
    WebDriver driver;
    @BeforeClass
    public void browser_setup() throws InterruptedException {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(4000);

    }

    @Test(priority = 1)
    public void enter_login_credential(){
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


