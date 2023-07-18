package org.applogintest.cases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.applogin.testcase.TestCase2;
import org.desiredcapabilities.DesireCap;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestCase2Test {

    public AppiumDriver driver;

    @Test
    public void main() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = DesireCap.desire();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        TestCase2 obj = new TestCase2((AndroidDriver) driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        obj.testCase();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        obj.toastMassageValidation();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
