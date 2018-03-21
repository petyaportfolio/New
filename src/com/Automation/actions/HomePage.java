package com.Automation.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy (xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    WebElement signIn;
    @FindBy (xpath = "//*[@id='email']")
    WebElement loginEmailAddress;
    @FindBy (xpath = "//*[@id='passwd']")
    WebElement loginPassword;
    @FindBy (xpath = "//*[@id='SubmitLogin']")
    WebElement submitButton;
    @FindBy (xpath = "//*[@id='center_column']/div[1]/ol/li")
    WebElement authenticationFailed;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication (String emailAddress, String password){

    signIn.click();
    loginEmailAddress.sendKeys(emailAddress);
    loginPassword.sendKeys(password);
    submitButton.click();
}

    public String getInvalidLoginText () {
        return authenticationFailed.getText();
    }





}
