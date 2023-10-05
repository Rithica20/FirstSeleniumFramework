package utils;

import frameworkexception.CustomException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementUtil {
    WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {

        return driver.findElement(locator);
    }

    public void doSendKeys(By locator, String value) {
        if (value == null) {
            System.out.println("Invalid input value cannot be null");
            throw new CustomException("Value cannot be null");
        }
        getElement(locator).sendKeys(value);
    }

    public String doElementGetText(By locator) {

        return getElement(locator).getText();
    }
    public void doClick(By locator) {

        getElement(locator).click();
    }

    public Boolean checkElementIsDisplayed(By locator) {

        return getElement(locator).isDisplayed();
    }

    public String getElementAttribute(By locator, String attributename) {
        return getElement(locator).getAttribute(attributename);
    }

    public Boolean isElementDisabled(By locator) {

        return getElement(locator).isEnabled();
    }

    public String title() {

        return driver.getTitle();
    }

    public List<WebElement> getElements(By locator) {

        return driver.findElements(locator);
    }

    public int getSize(By locator) {

        return getElements(locator).size();
    }

    public List<String> getElementsImgList(By locator, String value) {
        List<WebElement> allImg = getElements(locator);
        List<String> allImgLinks = new ArrayList<>();
        for (WebElement e : allImg) {
            String allAttrValue = e.getAttribute(value);
            if (!allAttrValue.isEmpty()) {
                allImgLinks.add(allAttrValue);
            }
        }
        return allImgLinks;
    }

    public  List<String> getElementsTextList(By locator) {
        List<WebElement> totalList = getElements(locator);
        List<String> linkListText = new ArrayList<>();
        for (WebElement e : totalList) {
            String linkText = e.getText();
            if (!linkText.isEmpty()) {
                linkListText.add(linkText);
            }
        }
        return linkListText;
    }
    //*********** Select class utility ***************//
    public void selectFromDropDownByIndex(By locator,int index){
        Select select =  new Select(getElement(locator));
        if (index < 0){
            System.out.println("Index cannot be negative:");
            return; // this return statement will stop the execution of the program like custom exception
        }
        select.selectByIndex(index);
    }
    public void selectFromDropDownByValue(By locator,String value){

        if (value == null){
            System.out.println("value cannot be null");
            return;
        }
        Select select =  new Select(getElement(locator));
        select.selectByValue(value);
    }
    public void selectFromDropDownByText(By locator,String text){

        if(text == null){
            System.out.println("text cannot be null");
            return;
        }
        Select select =  new Select(getElement(locator));
        select.selectByVisibleText(text);
    }
    public int getCountOfAllOptionsInDropDown(By locator){
        Select select =  new Select(getElement(locator));
        List<WebElement> allOptions = select.getOptions();
        int size = allOptions.size();
        return size;
    }
    public List<String> getAllOptions(By locator){
        Select select =  new Select(getElement(locator));
        List<WebElement> allOptions = select.getOptions();
        List<String> textOptions = new ArrayList<>();
        for (WebElement e:allOptions){
            String text = e.getText();
            textOptions.add(text);
        }
        return textOptions;
    }
    public void selectDropdownWithoutTextMethod(By locator,String option) {
        Select select = new Select(getElement(locator));
        List<WebElement> allOptions = select.getOptions();
        List<String> textOptions = new ArrayList<>();
        for (int i = 0; i < allOptions.size(); i++) {
            if (allOptions.get(i).getText().contains(option)) {
                allOptions.get(i).click();
                System.out.println("clicked");
            }
        }
    }
    public void selectDropdownWithoutValueMethod(By locator,String value,String option) {
        Select select = new Select(getElement(locator));
        List<WebElement> allOptions = select.getOptions();
        for (int i = 0; i < allOptions.size(); i++) {
            if (allOptions.get(i).getAttribute(value).contains(option)) {
                allOptions.get(i).click();
                System.out.println("clicked");
            }
        }
    }

                //***    Alert uitilites    ***//

    public  void handlingSimpleAlert(By locator){
        getElement(locator).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public  void handlingConfirmAlert(By locator){
        getElement(locator).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public  void handlingPromptAlert(By locator,String text){
        getElement(locator).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

//    public void selectDropdownWithoutValue(By locator,String value,String option){
//        Select select =  new Select(getElement(locator));
//        List<WebElement> allOptions = select.getOptions();
//        List<String> textOptions = new ArrayList<>();
//        int count = 0;
//        for (WebElement e:allOptions){
//            e.getAttribute(value).contains(option);
//            allOptions.get(count).click();
//            System.out.println("clicked");
//        }
//    }


    //***********       Waits uitilites          ***************/

    /**
     * this method will check wheather the element is present of dom and
     * it will not check wheather it is visible on the webopage
     * @param time
     * @param locator
     * @return
     */
    public  WebElement presenceofElementLocated(int time, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * this method will check wheather the element is visible on the web page
     * @param time
     * @param locator
     * @return
     */

    public WebElement visibilityofElementLocated(int time,By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /**
     * This method will wait for simple alert and
     * it will get the text of the alert and
     * it will click ok button
     * @param timeout
     */
    public void waitForSimpleAlert(int timeout){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();;
    }
    /**
     * This method will wait for confirm alert and
     * it will get the text of the alert and
     * it will click cancel button
     * @param timeout
     */
    public void waitForConfirmAlert(int timeout){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.dismiss();
    }
    /**
     * This method will wait for prompt alert and
     * it will get the text of the alert and
     * it will send text to the input field
     * then clicks on ok button
     * @param timeout
     */
    public void waitForPromptAlert(int timeout,String text){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        System.out.println(alert.getText());
        alert.accept();
    }

    /**
     * This method will check whether all the list of elements is visible on the web page
     * @param time
     * @param locator
     * @return
     */
    public List<WebElement> visibilityofAllElementsLocated(int time, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * this method will check whether atleast one element is visible on the page
     * @param time
     * @param locator
     * @return
     */
    public List<WebElement> presenceOfAllElementsLocatedBy(int time, By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    /**
     * this method will check whether we can peform actions on web page
     * @param timeinsec
     * @param locator
     */
    public void elementToBeClickable(int timeinsec, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeinsec));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }
    public void titleIs(String title,int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        try {
            if (wait.until(ExpectedConditions.titleIs(title))) {
                System.out.println("title is correct");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("tile not found");
        }
    }
    public void titleContains(String title, int time){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        try {

            if (wait.until(ExpectedConditions.titleContains(title))) {
                System.out.println("fraction of title is correct");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("fraction of title does not found");
        }

    }
    public String urlContains(String urlFraction, int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
                System.out.println("url fraction is correct");
                return driver.getCurrentUrl();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("url fraction not found");
        }
        return null;
    }
    public void numberOfWindowsToBe(int time,int totalWindows){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        if (wait.until(ExpectedConditions.numberOfWindowsToBe(totalWindows))){
            System.out.println("all the "+totalWindows+" windows are opened");
        }
        else System.out.println(""+totalWindows+"windows is not opened");
    }
    public WebElement presenceOfElementLocatedWithFluentWait(int pollingTime, int waitTime, By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(waitTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class)
                .withMessage("waited till "+waitTime+" seconds element not found"+locator);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public WebElement visibilityOfElementLocatedWithFluentWait(int pollingTime, int waitTime, By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(waitTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class)
                .withMessage("waited till "+waitTime+" seconds element not found\"+locator");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitalertIsPresentWithFluentWait(int pollingTime, int waitTime){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(waitTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class)
                .withMessage("waited till "+waitTime+" seconds element not found");
        wait.until(ExpectedConditions.alertIsPresent());
    }
}


