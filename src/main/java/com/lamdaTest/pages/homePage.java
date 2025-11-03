package com.lamdaTest.pages;

import org.openqa.selenium.By;

public class homePage extends basePage{
    private By bootstrapProgressBar =  By.linkText("Bootstrap Progress bar");
    public BootstrapBarPage clickBootstrapBarPage(){
        click(bootstrapProgressBar);
        return new BootstrapBarPage();
    }

}
