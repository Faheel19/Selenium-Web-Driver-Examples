import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class QA4 {
    public static void main(String[] args) {
        // Set the system property for the FirefoxDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Faheel\\Downloads\\geckodriver\\geckodriver.exe");

        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Step 1: Browse to https://www.ebay.com/
            driver.get("https://www.ebay.com/");

            // Step 2: Enter a product in the search box (e.g., Apple Watches)
            WebElement searchBox = driver.findElement(By.name("_nkw"));
            searchBox.sendKeys("Apple Watches");

            // Step 3: Select category from categories dropdown (e.g., Electronics)
            Select categoryDropdown = new Select(driver.findElement(By.id("gh-cat")));
            categoryDropdown.selectByVisibleText("Electronics");

            // Step 4: Click the Search button
            WebElement searchButton = driver.findElement(By.id("gh-btn"));
            searchButton.click();

            // Wait for a few seconds to see the results (you can add explicit waits if needed)
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
