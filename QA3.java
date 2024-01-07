import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class QA3 {
    public static void main(String[] args) {
        // Specify the browser type (you can change it to "chrome" or "edge" as needed)
        String browserType = "firefox";

        // Open the browser and navigate to Flipkart
        WebDriver driver = getWebDriver(browserType);
        driver.get("https://flipkart.com");

        // Method 1: Find the count of links on the homepage
        int linkCount = countLinks(driver);
        System.out.println("Number of links on the homepage: " + linkCount);

        // Method 2: Print link text and URLs of all the links
        printLinkDetails(driver);

        // Close the browser
        driver.quit();
    }

    // Method to get the appropriate WebDriver based on the browser type
    private static WebDriver getWebDriver(String browserType) {
        if ("firefox".equalsIgnoreCase(browserType)) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Faheel\\Downloads\\geckodriver\\geckodriver.exe");
            return new FirefoxDriver();
        }
        // Add support for other browsers if needed (chrome, edge, etc.)
        throw new IllegalArgumentException("Unsupported browser type: " + browserType);
    }

    // Method to count the number of links on the page
    private static int countLinks(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        return links.size();
    }

    // Method to print link text and URLs of all the links on the page
    private static void printLinkDetails(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Link Text and URLs:");
        for (WebElement link : links) {
            String linkText = link.getText();
            String linkURL = link.getAttribute("href");
            System.out.println("Text: " + linkText + " | URL: " + linkURL);
        }
    }
}
