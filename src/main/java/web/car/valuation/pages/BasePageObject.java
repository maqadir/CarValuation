package web.car.valuation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    /** Open page with given URL */
    protected void openUrl(String url){
        driver.get(url);
        handleCookiesPopup();
    }

    /** Find element using given locator */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /** Click on element with given locator when its visible */
    protected void click(By locator){
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    /** Type given text into the element with given locator*/
    protected void type(String text, By locator){
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    /** Get URL of current page from browser */
    public String getUrlForCurrentPage(){
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle(){
        return driver.getTitle();
    }

    public String getCurrentPageSource(){
        return driver.getPageSource();
    }
    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     */
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds :30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible
     * on the page
     */
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] :null));
                break;
            } catch (StaleElementReferenceException e){

            }
            attempts ++;
        }
    }

    public void handleCookiesPopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]")));

            // Click the Accept or Dismiss button
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("No cookie popup appeared or unable to interact with it.");
        }
    }

}