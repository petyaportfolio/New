package packageOne;
import com.sun.deploy.association.Action;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.List;
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
    public void mouseOver() {
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

    @Test
    public void dragAndDrop() {
        driver = new ChromeDriver();
        driver.get("http://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement destination = driver.findElement(By.xpath("//*[@id='droppable']"));

        //create object from ACTIONS class
        Actions dragAndDrop = new Actions(driver);
        dragAndDrop.dragAndDrop(source, destination).perform();

    }


    //verify Filter have to go to the HTML and verify if the result show in a table or div
    //then choose all of them and store them in a list
    @Test
    public void verifyTextInSearchResults() {

        driver = new ChromeDriver();
        driver.get("http://walmart.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement searchField = driver.findElement(By.xpath("//*[@id='global-search-input']"));
        searchField.sendKeys("red");
        searchField.submit();

        //store all data from results into a LIST element and make ITERATOR
        List<WebElement> allData = driver.findElements(By.xpath("//*[@id='searchProductResult']/div/div/div/div[2]"));
        Iterator<WebElement> iterator = allData.iterator();
        while (iterator.hasNext()) {
            String data = iterator.next().getText();
            if((data.toLowerCase().contains("red")) == false){
                System.out.println(data + " the line doesn't contain a match");
            } else {
                System.out.println("=============");
                System.out.println("THE TEXT CONTAINS RED");
                System.out.println(data);
                System.out.println("===============");
            }

            //We can use SoftAssert, but have to create an object of it
            //SoftAssert softAssert = new SoftAssert();
            //softAssert.assertTrue(data.toLowerCase().contains("red"));

            //or use hard Assert :
            //Assert.assertTrue(data.toLowerCase().contains("red"));
//            if (data.toLowerCase().contains("red")) {
//                Assert.assertTrue(true, data);
//            } else {
//                Assert.assertTrue(false, data);
//            }
        }

    }


        @Test
        public void verifyDisabledObject(){
            driver.get(theURLhere);
            String className = driver.findElement(By.xpath(xpathOfElement)).getAttribute("class");
            Assert.assertEquals(className, "IamDisabled");
}

        @Test
        public void verifyEnabledObject(){
            driver.get(theURLhere);
            String className = driver.findElement(By.xpath(xpathOfElement)).getAttribute("class");
            Assert.assertNotEquals(className, "IamDisabled");


















}

