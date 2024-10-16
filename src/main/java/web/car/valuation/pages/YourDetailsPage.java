package web.car.valuation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourDetailsPage extends BasePageObject{

    private String pageUrl = "https://www.webuyanycar.com/vehicle/details";

    /**
    private By pageTitle = By.xpath("//h1[@id='questions-title']");
    private By reg = By.xpath("//div[contains(@class, 'details-vrm')");
    private By manufacturer = By.xpath("//*[@id=\"wbac-app-container\"]/div/div/vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[1]/div[2]");
    private By model = By.xpath("//*[@id=\"wbac-app-container\"]/div/div/vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[2]/div[2]");
    private By year = By.xpath("//*[@id=\"wbac-app-container\"]/div/div/vehicle-questions/div/section[1]/div/div[1]/div/div[3]/div/vehicle-details/div[3]/div[2]/div[3]/div[2]");
    **/

    public YourDetailsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Get URL variable from PageObject */
    public String getPageUrl(){
        return pageUrl;
    }

    /** Get Page Source from PageObject */
    public String getPageSource(){
        return getCurrentPageSource();
    }

}
