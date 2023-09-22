package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homePage {
    WebDriver ldriver;

    public homePage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(how = How.XPATH, using = "//img[@alt='client brand banner']")
    @CacheLookup
    WebElement homePageLogo;

    @FindBy(how = How.XPATH, using = " //input[@placeholder='Search']")
    @CacheLookup
    WebElement searchBar;

}
