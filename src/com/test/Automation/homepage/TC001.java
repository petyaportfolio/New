package com.test.Automation.homepage;

import com.Automation.actions.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001 {
    WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void setUp (){
    driver = new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void verifyLoginWithInvalidCredentials (){
        homePage = new HomePage(driver);
        homePage.loginToApplication("test@gmail.com", "");
        Assert.assertEquals(homePage.getInvalidLoginText(),"Password is required.");
    }

    @AfterTest
    public void endTest (){

        driver.close();
    }




}



