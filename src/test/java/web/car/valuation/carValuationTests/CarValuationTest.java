package web.car.valuation.carValuationTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import web.car.valuation.base.TestUtilities;
import web.car.valuation.pages.WebuyanycarPage;
import web.car.valuation.pages.YourDetailsPage;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class CarValuationTest extends TestUtilities {

    YourDetailsPage detailsPage;

    @DataProvider(name = "data-provider")
    public Object[][] fetchRegList(){
    List<String> regList = TestUtilities.ReadFile();

    Object[][] listOfReg = new Object[regList.size()][1];
        for (int i = 0; i < regList.size(); i++) {
            listOfReg[i][0] = regList.get(i);
        }
    return listOfReg;
    }


    @Given("The car registration number is available")
    public void carRegIsAvailable() {
        log.info("Starting car valuation test");
    }

    @Test(dataProvider = "data-provider")
    @Then("I open website and search on reg")
    public void searchOnReg(String reg) {
        // open main page
        WebuyanycarPage homePage = new WebuyanycarPage(driver, log);
        homePage.openPage();

        // Enter car reg and mileage to get car detailed valuation
        detailsPage = homePage.getCarValuationResults(reg,
                "32000");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(detailsPage.getPageUrl()));
    }

    @Then("I expect to get {string}, {string}, {string}, {int} of the car")
    public void verifyCarDetails(String variant_reg, String make, String model, Integer year) {
    // Verifications - New page url is expected to load
        try{
            Assert.assertEquals(detailsPage.getUrlForCurrentPage(),detailsPage.getPageUrl());
            log.info("Assertion Passed: Checking the page with car details (URL) is loaded successfully");
        }catch (AssertionError e){
            log.info(e.getMessage());
            throw e;
        }

        // Fetching the new page source
        String pageSource = detailsPage.getPageSource();

        // Verification that details page contains expected text in source - Checking for Registration
        log.info("Checking for car reg on the details page");
        Assert.assertTrue(pageSource.contains(variant_reg), "Details page source doesn't contain expected car reg");

        // Verification that details page contains expected text in source - Checking for Make
        log.info("Checking for Make of car on the details page");
        Assert.assertTrue(pageSource.contains(make), "Details page source doesn't contain expected car make");

        // Verification that details page contains expected text in source - Checking for Model
        log.info("Checking for Model of car on the details page");
        Assert.assertTrue(pageSource.contains(model), "Details page source doesn't contain expected car model");

        // Verification that details page contains expected text in source - Checking for Year
        log.info("Checking for Year of car on the details page");
        Assert.assertTrue(pageSource.contains(String.valueOf(year)), "Details page source doesn't contain expected car year");

    }
}
