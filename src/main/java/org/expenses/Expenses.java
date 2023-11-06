package org.expenses;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.desiredcapabilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Expenses extends BaseDriver {
    ExtentTest test;
    @AndroidFindBy(id = "com.clove.clover.uat:id/tv_home_expense")
    public AndroidElement expense;
    @AndroidFindBy(id = "com.clove.clover.uat:id/tv_selectedItem")
    public AndroidElement cliniclist;
    @AndroidFindBy(id = "com.clove.clover.uat:id/tv_itemTitle")
    public List<WebElement> clinics;
    @AndroidFindBy(id = "com.clove.clover.uat:id/iv_next")
    public AndroidElement nextbutton;
    @AndroidFindBy(id = "com.clove.clover.uat:id/tv_next")
    public AndroidElement explore;
    @AndroidFindBy(id = "com.clove.clover.uat:id/rl_next")
    public AndroidElement next;
    @AndroidFindBy(id = "com.clove.clover.uat:id/tv_noRecords")
    private AndroidElement noRecords;

    @AndroidFindBy(id = "com.clove.clover.uat:id/iv_action_dots")
    private List<AndroidElement> actionDots;
    @AndroidFindBy(id = "com.clove.clover.uat:id/tv_itemdetail")
    private AndroidElement itemDetail;

    public Expenses(AndroidDriver driver, ExtentTest test) {
        super(driver);
        this.test = test;
    }

    public void expensesClick() {

        try {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            expense.click();
            test.log(Status.PASS, "Click on Expense menu button. Working");
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Expense button. Not Working");
        }

    }

    public void setClinic() {

        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            cliniclist.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            // Assuming you want to select the option with text "Bodakdev"
            String desiredOptionText = "Developer West";

            for (WebElement option : clinics) {
                if (option.getText().equals(desiredOptionText)) {
                    option.click();
                    break;
                }
            }
            test.log(Status.PASS, "Click on Clinic selected from dropdown. Working");
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Clinic selected from dropdown. Not Working");
        }

    }

    public void nextButton() {
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            nextbutton.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            explore.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            next.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            explore.click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            test.log(Status.PASS, "Click on Explore button. Working");

        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Explore button. Not Working");
        }
    }


    public void setNoRecords() {
        try {
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            Assert.assertEquals(noRecords.getText(), "No records found!");
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            test.log(Status.PASS, "Check No Records text display. Working");
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            test.log(Status.FAIL, "Check No Records text display. Not Working");
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        }
    }

    public void setActionDots() {
        try {
            if (actionDots.size() == 0) {
                test.log(Status.PASS, noRecords.getText());
            } else {
                test.log(Status.PASS, "There is no of Items = " + actionDots.size());
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Items Listing Not working");
        }
    }


    public void scrollTo() {
        FluentWait<AndroidDriver<AndroidElement>> wait = new FluentWait<>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS);

        boolean elementFound = false;
        while (!elementFound) {
            try {
                // Wait for the presence of all elements with text "abcd"
                List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.clove.clover.uat:id/tv_itemdetail")));

                for (WebElement element : elements) {
                    if (element.getText().equals("ABCDEFG")) {
                        // Check if the element is visible before clicking
                        if (element.isDisplayed()) {
                            element.click();
                            elementFound = true;
                            break;
                        } else {
                            // Scroll the page if the element is not visible
                            driver.executeScript("window.scrollBy(0, 100)");
                        }
                    }
                }
            } catch (NoSuchElementException e) {
                // Continue scrolling if the element is not found
                driver.executeScript("window.scrollBy(0, 100)");
            }
        }

    }
}
