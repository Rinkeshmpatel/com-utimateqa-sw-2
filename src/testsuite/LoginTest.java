package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest extends BaseTest {

    String basUrl = "https://courses.ultimateqa.com/";

    @Before

    public void setUp(){

        openBrowser(basUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        //* click on the ‘Sign In’ link
        WebElement ClickSignLink = driver.findElement(By.xpath("//li[@class=\"header__nav-item header__nav-sign-in\"]"));
                ClickSignLink.click();


        //* Verify the text ‘Welcome Back!’
        WebElement VerifyTest = driver.findElement(By.tagName("h1"));
        VerifyTest.getText();


    }

    @Test
    public void verifyTheErrorMessage(){

        //* click on the ‘Sign In’ link

        WebElement ClickSignLink= driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        ClickSignLink.click();

        //* Enter invalid username
        WebElement EnterIUsername = driver.findElement(By.xpath("//input[@id=\"user[email]\"]"));
        EnterIUsername.sendKeys("Qa@.com");



        //* Enter invalid password
        WebElement EnterIPassword = driver.findElement(By.xpath("//input[@id='user[password]']"));
        EnterIPassword.sendKeys("Test123456");



        //* Click on Login button
        WebElement ClickLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        ClickLogin.click();


        //* Verify the error message ‘Invalid email or password.’
        WebElement VerifyError = driver.findElement(By.xpath("//div[@id='notice']"));
        VerifyError.getText();


    }
    @After
    public void tearDown(){

        // closeBrowser();
    }

}