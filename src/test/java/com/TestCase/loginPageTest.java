package com.TestCase;

import com.pageObject.loginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class loginPageTest extends baseClass{

@Test
    public void loginTest() throws IOException {

    loginPage lp = new loginPage(driver);
    lp.setUsername(userName);
    logger.info("username Entered");
    lp.setPassword(password);
    logger.info("Password Entered");
    lp.clickToSubmit();
    logger.info("Submit button clicked");
    //driver.switchTo().alert().accept();

    if(driver.getTitle().equals("OrangeHRM")){
        Assert.assertTrue(true);
        logger.info("Test case passed");

    }
    else{
        captureScreen(driver,"loginTest");
        Assert.assertTrue(false);
        logger.info("Login test failed");

    }
}

}
