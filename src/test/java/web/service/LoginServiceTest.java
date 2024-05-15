package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver before each test
        System.setProperty("webdriver.chrome.driver", 
                "C:/chromedriver-win64/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        
        driver = new ChromeDriver();
        System.out.println("WebDriver initialized: " + driver);
    }

    @After
    public void tearDown() {
        // Clean up WebDriver after each test
        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver quit.");
        }
    }
    

    @Test
    public void testValidLogin() {
        // Navigate to the login page
        driver.navigate().to("file:///D:/Deakin%20MIT%20Semester%203/SIT707%20-%20Software%20Quality%20and%20Testing/Tasks/Task%208.1P/login.html");

        // Fill in the form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("ahsan");

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("ahsan_pass");

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("19900101");

        // Submit the form
        driver.findElement(By.tagName("form")).submit();

        // Wait for the response
        sleep(5);

        // Assert login status
        Assert.assertEquals("Login Status: success", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void testValidLoginWithDifferentDOBFormat() {
        // Navigate to the login page
        driver.navigate().to("file:///D:/Deakin%20MIT%20Semester%203/SIT707%20-%20Software%20Quality%20and%20Testing/Tasks/Task%208.1P/login.html");

        // Fill in the form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("ahsan");

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("ahsan_pass");

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("19900101"); // different DOB format

        // Submit the form
        driver.findElement(By.tagName("form")).submit();

        // Wait for the response
        sleep(5);

        // Assert login status
        Assert.assertEquals("Login Status: success", driver.findElement(By.tagName("h2")).getText());
    }
    
    @Test
    public void testValidLoginWithUppercaseUsername() {
        // Navigate to the login page
        driver.navigate().to("file:///D:/Deakin%20MIT%20Semester%203/SIT707%20-%20Software%20Quality%20and%20Testing/Tasks/Task%208.1P/login.html");

        // Fill in the form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("AHsan"); // uppercase username

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("ahsan_pass");

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-01");

        // Submit the form
        driver.findElement(By.tagName("form")).submit();

        // Wait for the response
        sleep(5);

        // Assert login status
        Assert.assertEquals("Login Status: success", driver.findElement(By.tagName("h2")).getText());
    }
    
    @Test
    public void testValidLoginWithSpacesInUsername() {
        // Navigate to the login page
        driver.navigate().to("file:///D:/Deakin%20MIT%20Semester%203/SIT707%20-%20Software%20Quality%20and%20Testing/Tasks/Task%208.1P/login.html");

        // Fill in the form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("ah san"); // spaces in username

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("ahsan_pass");

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-01");

        // Submit the form
        driver.findElement(By.tagName("form")).submit();

        // Wait for the response
        sleep(5);

        // Assert login status
        Assert.assertEquals("Login Status: success", driver.findElement(By.tagName("h2")).getText());
    }
    
    
    
    @Test
    public void testInvalidUsername() {
        // Navigate to the login page
        driver.navigate().to("file:///D:/Deakin%20MIT%20Semester%203/SIT707%20-%20Software%20Quality%20and%20Testing/Tasks/Task%208.1P/login.html");

        // Fill in the form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("invalid_user");

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("ahsan_pass");

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-01");

        // Submit the form
        driver.findElement(By.tagName("form")).submit();

        // Wait for the response
        sleep(5);

        // Assert login status
        Assert.assertEquals("Login Status: fail", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void testInvalidPassword() {
        // Navigate to the login page
        driver.navigate().to("file:///D:/Deakin%20MIT%20Semester%203/SIT707%20-%20Software%20Quality%20and%20Testing/Tasks/Task%208.1P/login.html");

        // Fill in the form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("ahsan");

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("invalid_pass");

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-01");

        // Submit the form
        driver.findElement(By.tagName("form")).submit();

        // Wait for the response
        sleep(5);

        // Assert login status
        Assert.assertEquals("Login Status: fail", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void testInvalidDOB() {
        // Navigate to the login page
        driver.navigate().to("file:///D:/Deakin%20MIT%20Semester%203/SIT707%20-%20Software%20Quality%20and%20Testing/Tasks/Task%208.1P/login.html");

        // Fill in the form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("ahsan");

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("ahsan_pass");

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-02");

        // Submit the form
        driver.findElement(By.tagName("form")).submit();

        // Wait for the response
        sleep(5);

        // Assert login status
        Assert.assertEquals("Login Status: fail", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void testEmptyUsername() {
        // Navigate to the login page
        driver.navigate().to("file:///D:/Deakin%20MIT%20Semester%203/SIT707%20-%20Software%20Quality%20and%20Testing/Tasks/Task%208.1P/login.html");

        // Fill in the form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("");

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("ahsan_pass");

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-01");

        // Submit the form
        driver.findElement(By.tagName("form")).submit();

        // Wait for the response
        sleep(5);

        // Assert login status
        Assert.assertEquals("Login Status: fail", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void testEmptyPassword() {
        // Navigate to the login page
        driver.navigate().to("file:///D:/Deakin%20MIT%20Semester%203/SIT707%20-%20Software%20Quality%20and%20Testing/Tasks/Task%208.1P/login.html");

        // Fill in the form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("ahsan");

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("");

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-01");

        // Submit the form
        driver.findElement(By.tagName("form")).submit();

        // Wait for the response
        sleep(5);

        // Assert login status
Assert.assertEquals("Login Status: fail", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void testEmptyDOB() {
        // Navigate to the login page
        driver.navigate().to("file:///D:/Deakin%20MIT%20Semester%203/SIT707%20-%20Software%20Quality%20and%20Testing/Tasks/Task%208.1P/login.html");

        // Fill in the form
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("ahsan");

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("ahsan_pass");

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("");

        // Submit the form
        driver.findElement(By.tagName("form")).submit();

        // Wait for the response
        sleep(5);

        // Assert login status
        Assert.assertEquals("Login Status: fail", driver.findElement(By.tagName("h2")).getText());
    }

    private void sleep(long seconds) {
        // Helper method to pause execution for a specified duration
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}