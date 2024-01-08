import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class QA2 {
    public static void main(String[] args) {
        // Set the system property for FirefoxDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Faheel\\Downloads\\geckodriver\\geckodriver.exe");

        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Step 1: Navigate to "http://www.fb.com"
            driver.get("http://www.fb.com");

            // Verify that the page is redirected to "https://www.facebook.com/"
            String expectedUrl = "https://www.facebook.com/";
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.contains(expectedUrl)) {
                System.out.println("PASS: Page is redirected to the expected URL.");
            } else {
                System.out.println("FAIL: Page is not redirected to the expected URL.");
                System.out.println("Actual URL: " + actualUrl);
            }

            // Step 2: Verify that there is a "Create New Account" link on the page
            By createAccountLink = By.linkText("Create new account");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait up to 5 seconds

            try {
                WebElement createAccountElement = wait.until(ExpectedConditions.presenceOfElementLocated(createAccountLink));
                if (createAccountElement.isDisplayed()) {
                    System.out.println("PASS: 'Create New Account' link is present on the page.");
                    // Click the "Create New Account" button
                    createAccountElement.click();
                } else {
                    System.out.println("FAIL: 'Create New Account' link is not present on the page.");
                }
            } catch (Exception e) {
                System.out.println("FAIL: Unable to locate 'Create New Account' link.");
                e.printStackTrace();
            }

            driver.findElement(By.name("firstname")).sendKeys("John");
    		driver.findElement(By.name("lastname")).sendKeys("Doe");
    		driver.findElement(By.name("reg_email__")).sendKeys("qa@test.com");
    		driver.findElement(By.name("reg_passwd__")).sendKeys("test");
    		
    		Select selDate = new Select(driver.findElement(By.id("day")));
    		Select selMonth = new Select(driver.findElement(By.id("month")));
    		Select selYear = new Select(driver.findElement(By.id("year")));
    		
    		selDate.selectByVisibleText("07");
    		selMonth.selectByVisibleText("Jun");
    		selYear.selectByVisibleText("1969");

        } finally {
            // Close the browser
            driver.quit();
        }
    }     
    }


