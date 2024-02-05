import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BankingApplicationTest {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venkadesh\\OneDrive\\Desktop\\Selenium\\chromedriver_win32.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Launch the banking application
        driver.get("https://www.examplebank.com");

        // Enter username and password
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("your_username");
        passwordField.sendKeys("your_password");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Verify successful login
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        String message = welcomeMessage.getText();
        if (message.equals("Welcome, your_username!")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }

        // Close the browser
        driver.quit();
    }
}
