package web.car.valuation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebuyanycarPage extends BasePageObject {

    private String pageUrl = "https://www.webuyanycar.com/";

    private By regInput = By.xpath("//input[@id='vehicleReg']");
    private By milageInput = By.xpath("//input[@id='Mileage']");
    private By getCarValuationButton = By.xpath ("//button[@id='btn-go']");


    public WebuyanycarPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open page with it's url */
    public void openPage(){
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    /** Get Car Valuation Result Page by clicking on Get my car valuation button on webuyanycar home page */
    public YourDetailsPage getCarValuationResults(String carReg, String carMileage){
        log.info("Entering the Car Registration Number: " + carReg);
        type(carReg, regInput);

        log.info("Entering the Car Mileage");
        type(carMileage, milageInput);

        log.info("Clicking Get my car valuation button");
        click(getCarValuationButton);

        return new YourDetailsPage(driver, log);
    }
}
