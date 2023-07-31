package org.applogintest.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.applogin.testcase.TestCase4;
import org.desiredcapabilities.DesireCap;
import org.extentreport.ExtentManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestCase4Test {

    public AppiumDriver driver;

    public ExtentReports extent;
    public ExtentTest test;

    @BeforeClass
    public void driverLaunch() throws MalformedURLException {
        extent = ExtentManager.getInstance();
        DesiredCapabilities caps = DesireCap.desire();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void main() {
        test = extent.createTest("Test case 4", "Description of test case 4");
        TestCase4 obj = new TestCase4((AndroidDriver) driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        obj.testCase();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        obj.toastMassageValidation();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        test.pass("Test case passed Successfully");
    }

    @AfterClass
    public void driverClose() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.quit();
        extent.flush();
    }
}
