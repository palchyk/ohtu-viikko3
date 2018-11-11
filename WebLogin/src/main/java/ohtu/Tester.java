package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");

        // tulostetaan sivu konsoliin
        // System.out.println(driver.getPageSource());
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));
        element.submit();
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource()+"\nEKA TESTI yllä!!!\n");
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        element = driver.findElement(By.linkText("login"));
        element.click();
        Random r = new Random();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));
        element.submit();
         System.out.println(driver.getPageSource()+"\nTOKA TESTI yllä!!!\n");
         element = driver.findElement(By.linkText("back to home"));
        element.click();
        element = driver.findElement(By.linkText("register new user"));
        element.click();
                     
        element = driver.findElement(By.name("username"));
        element.sendKeys("moikka"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("moimoi");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("moimoi");
        element = driver.findElement(By.name("signup"));
        element.submit();
        System.out.println(driver.getPageSource()+"\nKOLMAS TESTI yllä!!!\n");
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
        System.out.println(driver.getPageSource()+"\nNELJÄS TESTI yllä!!!\n");
        // ...
        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
