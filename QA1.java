import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QA1 {
    public static void main(String[] args) {
        // Set the system property for FirefoxDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Faheel\\Downloads\\geckodriver\\geckodriver.exe");

        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Open Firefox browser and maximize the window
            driver.manage().window().maximize();

            // Step 1: Navigate to "https://vitscc.com/"
            driver.get("https://vitscc.com/");

            // Step 2: Verify the title and print PASS or FAIL
            String expectedTitle = "VITS Consulting Corp@ - VITS CONSULTING";
            String actualTitle = driver.getTitle();

            if (actualTitle.equals(expectedTitle)) {
                System.out.println("PASS: Title matches expected value. Title: " + actualTitle);
            } else {
                System.out.println("FAIL: Title does not match expected value. Title: " + actualTitle);
            }

            // Step 3: Navigate to "https://www.facebook.com"
            driver.get("https://www.facebook.com");

            // Step 4: Navigate back to the VITS HR website
            driver.navigate().back();

            // Step 5: Print the URL of the current page
            System.out.println("Current URL: " + driver.getCurrentUrl());

            // Step 6: Navigate forward
            driver.navigate().forward();

            // Step 7: Reload the page
            driver.navigate().refresh();

            // Step 8: Close the browser
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
