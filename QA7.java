import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QA7 {
    public static void main(String[] args) {
        // Set the system property for the FirefoxDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Faheel\\Downloads\\geckodriver\\geckodriver.exe");

        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Step 1: Navigate to https://www.gmail.com
            driver.get("https://www.gmail.com");

            // Step 2: Enter a valid Email Id or Phone Number and click Next button
            WebElement emailInput = driver.findElement(By.id("identifierId"));
            emailInput.sendKeys("your-email@gmail.com");
            driver.findElement(By.id("identifierNext")).click();

            // Step 3: Enter Password and click "Sign in" button
            WebElement passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("your-password");
            driver.findElement(By.id("passwordNext")).click();

         
            // Step 4: Click compose button
            driver.findElement(By.xpath("//div[text()='Compose']")).click();

            // Step 5: Verify that a new mail window is opened
            // You can add an assertion here to check if the new mail window is opened

            // Step 6: Enter Email Id, subject, and text in body
            driver.findElement(By.name("to")).sendKeys("qatesting@vitsconsulting.com");
            driver.findElement(By.name("subjectbox")).sendKeys("QA Automation Test Mail");
            driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("This is a test email sent using Selenium.");

            // Step 7: Click send button
            driver.findElement(By.xpath("//div[text()='Send']")).click();

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

