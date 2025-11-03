package com.lamdaTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootstrapBarPage extends basePage{
    private By startDownloadButton = By.id("dwnBtn");
    private By progressBarPercent = By.cssSelector(".counter");
    private By completedMsg = By.xpath("//p[contains(@class,'success')] ");
    public void clickStartDownloadButton(){
        click(startDownloadButton);

    }
    public String getprogressBarPercent(){
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(5));
        wait.until(ExceptedConditions.VisibilityOfElementLocated(progressBarPercent));
        return getText(progressBarPercent);
    }
    public String getCompletedMsg(){
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(5));
        wait.until(ExceptedConditions.VisibilityOfElementLocated(completedMsg));
    }

}
