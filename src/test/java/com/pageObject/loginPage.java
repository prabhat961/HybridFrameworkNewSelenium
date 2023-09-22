package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

        WebDriver ldriver;

        public loginPage(WebDriver rdriver){
            ldriver = rdriver;
            PageFactory.initElements(rdriver, this);
        }

    @FindBy(xpath = "//img[@alt='company-branding']")
            @CacheLookup
    WebElement loginPageLogo;

        @FindBy(xpath = "//input[@name='username']")
        @CacheLookup
    WebElement userNameBox;

        @FindBy(xpath = "//input[@name='password']")
        @CacheLookup
    WebElement passwordBox;

        @FindBy(xpath = "//button[@type = 'submit']")
        @CacheLookup
    WebElement loginBtn;


        public void logoTest(){
           loginPageLogo.isDisplayed();
        }

        public void setUsername(String uname){
            userNameBox.clear();
            userNameBox.sendKeys(uname);
        }

        public void setPassword(String pwd){
            passwordBox.clear();
            passwordBox.sendKeys(pwd);
        }

        public void clickToSubmit(){
            loginBtn.click();
        }
}
