package com.lambdaTest.tests;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import com.google.common.annotations.VisibleForTesting;

public class progressBarTest extends baseTest {
    SoftAssert s = new SoftAsset();
    bootstrapBarPage  progressBar= new bootstrapBarPage();
    @Test
    public void testProgressBarPercent(){
     progressBar =home.clickBootstrapBarPage();
        progressBar.clickStartDownloadButton();
        String actMsg = progressBar.getCompletedMsg();
        String actPercent = progressBar.getprogressBarPercent();
        String ExpectedMag = "Download completed!";
        String ExpectedPercent = "1000%";
        s.assertEquals(actMsg,ExpectedMag,"\n the msg is not completed");
        s.assertEquals(actPercent,ExpectedPercent,"\n not downloaded");
        s.assertAll();


    }
}
