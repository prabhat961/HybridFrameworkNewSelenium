package com.TestCase;

import com.Utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class baseClass {

    ReadConfig rc = new ReadConfig();
    public String baseURL = rc.getApplicationURL();
    public String userName = rc.getUsername();
    public String password = rc.getPassword();

    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String br) {
        logger = Logger.getLogger("orangrHRMAutomation");
        PropertyConfigurator.configure("log4j.properties");
//                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
//                ChromeOptions co = new ChromeOptions();
//                co.setBinary(System.getProperty("user.dir")+"\\Browser\\chrome.exe");
//                driver = new ChromeDriver(co);
        //  System.setProperty("webdriver.chrome.driver","E:/Software/Drivers/Browser Drivers/chromedriver.exe");
//                ChromeOptions co = new ChromeOptions();
//                co.setBinary("E:/Software/Drivers/chrome-win64/chrome-win64/chrome.exe");
        if (br.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (br.equals("Firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(baseURL);
        logger.info("URL entered");
    }

    @AfterClass
    public void teerDown() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
}
