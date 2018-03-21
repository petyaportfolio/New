package packageOne;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class MyClass {

  @Test
        public void alertMethod (){
            WebDriver driver = new ChromeDriver();
            driver.get("http://demo.guru99.com/test/delete_customer.php");

            WebElement input = driver.findElement(By.name("cusid"));
            input.sendKeys("Petya");

            WebElement button = driver.findElement(By.name("submit"));
            button.click();

            driver.switchTo().alert().accept();
            System.out.println(driver.switchTo().alert().getText());
        }
}
