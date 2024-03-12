package Automation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        // Set the path to Chrome, Firefox, and IE drivers
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hema\\OneDrive\\Desktop\\SELENIUM\\chromedriver-win32\\chromedriver.exe");
        System.setProperty("webdriver.firefox.driver", "C:\\Users\\hema\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
        //System.setProperty("webdriver.ie.driver", "/path/to/IEDriverServer");

        // List of resolutions and devices
        String[] resolutions = {"1366x768", "1920x1080", "1536x864"};
        String[] browsers = {"Chrome", "Firefox", "IE"};

        // Loop through each resolution and browser
        for (String resolution : resolutions) {
            for (String browser : browsers) {
                WebDriver driver = null;

                try {
                    // Initialize WebDriver based on the browser
                    switch (browser) {
                        case "Chrome":
                            driver = new ChromeDriver();
                            break;
                        case "Firefox":
                            driver = new FirefoxDriver();
                            break;
                        case "IE":
                            driver = new InternetExplorerDriver();
                            break;
                    }

                    // Set window size based on resolution
                    String[] dimension = resolution.split("x");
                    int width = Integer.parseInt(dimension[0]);
                    int height = Integer.parseInt(dimension[1]);
                    driver.manage().window().setSize(new Dimension(width, height));

                    // Open the website
                    driver.get("https://demo.dealsdray.com/");

                    // Take screenshot of the entire page
                    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    String screenshotPath = "C:\\Users\\hema\\Videos" + browser + "/" + resolution + ".png";
                    FileUtils.copyFile(screenshotFile, new File(screenshotPath));
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // Quit the WebDriver instance
                    if (driver != null) {
                        driver.quit();
                    }
                }
            }
        }
    }
}



