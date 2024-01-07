import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class QA6 {
    public static void main(String[] args) {
        // Set the system property for the FirefoxDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Faheel\\Downloads\\geckodriver\\geckodriver.exe");

        // Create a new instance of the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Step 1: Navigate to http://jqueryui.com/droppable/
            driver.get("http://jqueryui.com/droppable/");

            // Switch to the iframe containing the draggable elements
            driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

            // Step 2: Perform drag and drop operation from source to target
            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droppable"));
            new Actions(driver).dragAndDrop(source, target).perform();

            // Step 3: Verify the color property of the target after drag and drop
            String actualColor = target.getCssValue("background-color");
            String expectedColor = "rgba(70, 130, 180, 1)"; // Adjust this value based on the expected color
            assert actualColor.equals(expectedColor) : "Color property doesn't match.";

            // Step 4: Verify the text change of the target after drag and drop
            String actualText = target.getText();
            String expectedText = "Dropped!";
            assert actualText.equals(expectedText) : "Text doesn't match.";

        } finally {
            // Switch back to the default content
            driver.switchTo().defaultContent();

            // Close the browser
            driver.quit();
        }
    }
}
