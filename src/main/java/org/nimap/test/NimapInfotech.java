package org.nimap.test;

import java.time.Duration;

import javax.xml.xpath.XPath;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class NimapInfotech {

    public String baseUrl = "https://testffc.nimapinfotech.com/";
    public WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            { "gitepravin1511@gmail.com", "Gite@11223344" }
            
        };
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder=\"Email Id / Mobile No\"]"))
              .sendKeys(username);

        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"))
              .sendKeys(password);

        Thread.sleep(3000);

        // Enter the captcha manually message using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String message = "Please enter the CAPTCHA manually";
        String script = "var messageDiv = document.createElement('div');" +
                        "messageDiv.innerHTML = '<h2>" + message + "</h2>';" +
                        "messageDiv.setAttribute('id', 'messageDiv');" +
                        "messageDiv.style.position = 'fixed';" +
                        "messageDiv.style.top = '10px';" +
                        "messageDiv.style.right = '10px';" +
                        "messageDiv.style.backgroundColor = 'yellow';" +
                        "messageDiv.style.padding = '10px';" +
                        "messageDiv.style.border = '1px solid black';" +
                        "messageDiv.style.zIndex = '10000';" +
                        "document.body.appendChild(messageDiv);" +
                        "setTimeout(function() {" +
                        "  var element = document.getElementById('messageDiv');" +
                        "  if (element) {" +
                        "    element.parentNode.removeChild(element);" +
                        "  }" +
                        "}, 20000);"; 
        js.executeScript(script);


        Thread.sleep(20000); 

        driver.findElement(By.xpath("//button[text()=\"Sign In\"]")).click();
        
        Thread.sleep(Duration.ofSeconds(8));
        
        //driver.findElement(By.xpath("//span[text()=\"Punch In\"]")).click();
        //Thread.sleep(Duration.ofSeconds(3));
        
        driver.findElement(By.xpath("//div[@class=\"kt-aside-menu-wrapper kt-grid__item kt-grid__item--fluid\"]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        
        driver.findElement(By.xpath("//span[text()=\"My Customers\"]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        
        driver.findElement(By.xpath("//span[text()=\" New Customer \"]")).click();
        
        driver.findElement(By.xpath("//input[@placeholder=\"Lead/Customer Name*\"]")).sendKeys("Pravin Gite");
        
        driver.findElement(By.xpath("//input[@placeholder=\"Ref No.\"]")).sendKeys("Pravingite123123");
        
        driver.findElement(By.xpath("//input[@placeholder=\"Contact Person Name\"]")).sendKeys("Pravin Gite");
        
        driver.findElement(By.xpath("//input[@placeholder=\"Mobile Number\"]")).sendKeys("8806484472");
        
        driver.findElement(By.xpath("//input[@placeholder=\"Telephone Number\"]")).sendKeys("24242424");
        
        driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys(username);
        
        driver.findElement(By.xpath("//input[@placeholder=\"Contact Person Designation\"]")).sendKeys("Pune");
        Thread.sleep(Duration.ofSeconds(3));
        
       driver.findElement(By.xpath("//input[@placeholder=\"Address\"]")).click();
       Thread.sleep(Duration.ofSeconds(3));
        
        driver.findElement(By.xpath("//span[text()=\"Done\"]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        
        driver.findElement(By.xpath("//h5[text()='Customer Address']/following-sibling::div[2]//*[text()=\"Country\"][1]")).click();
        
        driver.findElement(By.xpath("//div[@id=\"cdk-overlay-4\" and @class=\"cdk-overlay-pane\"]//*[@placeholder=\"Search\"]")).sendKeys("India");
        
        driver.findElement(By.xpath("//span[@class=\"mat-option-text\" and text()=\" India \"]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        
        driver.findElement(By.xpath("//h5[text()='Customer Address']/following-sibling::div[2]//*[text()=\"State\"][1]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        
        driver.findElement(By.xpath("//div[@id=\"cdk-overlay-5\" and @class=\"cdk-overlay-pane\"]//*[@placeholder=\"Search\"]")).sendKeys("Maharashtra");
        Thread.sleep(Duration.ofSeconds(2));
        
        driver.findElement(By.xpath("//span[@class=\"mat-option-text\" and text()=\" Maharashtra \"]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        
        driver.findElement(By.xpath("//h5[text()='Customer Address']/following-sibling::div[2]//span[text()='City'][1]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        
    
        driver.findElement(By.xpath("//div[@id=\"cdk-overlay-6\" and @class=\"cdk-overlay-pane\"]//*[@placeholder=\"Search\"]")).sendKeys("Pune");
        Thread.sleep(Duration.ofSeconds(2));
        
        driver.findElement(By.xpath("//span[@class=\"mat-option-text\" and text()=\" Pune \"]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        
        driver.findElement(By.xpath("//h5[text()='Customer Address']/following-sibling::div[2]//span[text()=\"Locality\"][1]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        
    
        driver.findElement(By.xpath("//div[@class=\"cdk-overlay-pane\"]//*[@placeholder=\"Search\"]")).sendKeys("AUNDH");
        Thread.sleep(Duration.ofSeconds(2));
        
        driver.findElement(By.xpath("//span[@class=\"mat-option-text\" and text()=\" AUNDH  \"]")).click();
        Thread.sleep(Duration.ofSeconds(2));
        
       driver.findElement(By.xpath("//input[@placeholder=\"Pincode\"]")).sendKeys("411044");
       
       driver.findElement(By.xpath("//span[text()=\"Customer Type\"][1]")).click();
       Thread.sleep(Duration.ofSeconds(2));
       
       driver.findElement(By.xpath("//span[@class=\"mat-option-text\" and text()=\"Retailer / Sub Dealer \"]")).click();
       Thread.sleep(Duration.ofSeconds(2));
       
      driver.findElement(By.xpath("//span[text()=\" Save \"]")).click();
       
    }
}
        
