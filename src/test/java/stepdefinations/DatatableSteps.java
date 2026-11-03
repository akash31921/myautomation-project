package stepdefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class DatatableSteps {
    WebDriver driver;
    WebDriverWait wait;
    String user;
    String pass;
    @Given("Goto the website loginpage")
    public void gotoTheWebsiteLoginpage() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @When("enter correct credentials")
    public void enter_correct_credentials(DataTable data) {
        List<Map<String, String>> table = data.asMaps(String.class, String.class);

        for(Map<String,String> db:table){
           user = db.get("username");
           pass = db.get("password");
            System.out.println(user);
        }

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(pass);


    }
    @When("click on the login button on homepage")
    public void clickOnTheLoginButtonOnHomepage() {
        driver.findElement(By.tagName("button")).click();


    }
    @Then("login successful on homepage")
    public void loginSuccessfulOnHomepage() {
        String loginpageurl=driver.getCurrentUrl();
        Assert.assertNotEquals(loginpageurl,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }
    @Then("profile picture displayed on homepage")
    public void profilePictureDisplayedOnHomepage() {
        System.out.println("displayed");


    }


}


