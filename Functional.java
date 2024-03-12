package Automation;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Functional {
    public static void main(String[] args) throws IOException {
        
       
    	System.setProperty("webdriver.firefox.driver","C:\\Users\\hema\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
	

        // Create a new instance of firefoxDriver
       
    	FirefoxDriver driver=new FirefoxDriver();
        

        // Navigate to the web application
        driver.get("https://demo.dealsdray.com/");

        // Enter username and password
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("prexo.mis@dealsdray.com");
        
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("prexo.mis@dealsdray.com");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for the page to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        WebElement order=driver.findElement(By.xpath("//span[text()='chevron_right']"));
        order.click();
        
              
        
       WebElement orders=driver.findElement(By.xpath("//span[text()='Orders']"));
       orders.click();
       
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       
       WebElement bulkorders=driver.findElement(By.xpath("//button[contains(@class,'css-vwfva9')]"));
       bulkorders.click();
      
       
        
        

        // Upload XLS file
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("Downloads\\demo-data.xlsx");

        // Wait for the file to upload
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Capture screenshot of the final output
        driver.manage().window().maximize();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\hema\\Videos\\entirewebpage.png");
        
       
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}


