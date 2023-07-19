//select valid clinic name in schedule page.
//Doctor name will be default in the dropdown
//click on Appointmentplus button
//Redirect to Appointment booking page

package org.schedule.testcase.firstpage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.schedule.SchedulePage;

import java.util.concurrent.TimeUnit;

public class TestCase2 extends SchedulePage {
    public TestCase2(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void selectClinicDropdown() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        layout_clinicSelect.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Assuming you want to select the option with text "Bodakdev"
        String desiredOptionText = "Developer West";

        for (WebElement option : tv_itemTitle) {
            if (option.getText().equals(desiredOptionText)) {
                option.click();
                break;
            }
        }
    }
}