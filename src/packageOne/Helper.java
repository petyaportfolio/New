package packageOne;
import com.sun.deploy.association.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Helper {

    WebDriver driver;

//    @Test
//    public void howToSwitch() {
//
//        Set<String> windows = driver.getWindowHandles();
//        Iterator<String> iterator = windows.iterator();
//        String parentWindow = iterator.next();
//        String childWindow = iterator.next();
//    }

    @Test
    public void mouseOver(){
        driver = new ChromeDriver();
        driver.get("http://amazon.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement menu = driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]"));
        WebElement menu2 = driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[2]"));

        //create new object from ACTIONS class
        Actions hover = new Actions(driver);
       hover.moveToElement(menu).perform();
       hover.moveToElement(menu2).perform();

    }






















}

