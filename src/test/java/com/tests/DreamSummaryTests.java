package com.tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.TestBase;
import com.pages.DreamSummaryPage;
import com.utility.LoggerUtil;
import com.utility.ScreenshotUtil;

public class DreamSummaryTests extends TestBase {

	private static final Logger logger = LoggerUtil.getLogger(DreamPortalHomeTests.class);
	DreamSummaryPage dreamsSummaryPg;
	
	@Test
    public void toValidateSummaryStatsAndRecurringDreams() {
 
        dreamsSummaryPg = new DreamSummaryPage();
        SoftAssert softAssert = new SoftAssert();

        // 1️. Validate Good Dreams = 6
        int good = dreamsSummaryPg.getGoodDreamCount();
        logger.info("Good dreams count: " + good);
        softAssert.assertEquals(good, 6, "Good dreams count mismatch!");
        if (good == 6) {
    		logger.info("Good dreams count is correct.");
    	} else {
    		logger.error("Good dreams count is incorrect. Expected 6, found " + good);
    	}

        // 2️. Validate Bad Dreams = 4
        int bad = dreamsSummaryPg.getBadDreamCount();
        logger.info("Bad dreams count: " + bad);
        softAssert.assertEquals(bad, 4, "Bad dreams count mismatch!");
        if (bad == 4) {
    		logger.info("Bad dreams count is correct.");
    	} else {
    		logger.error("Bad dreams count is incorrect. Expected 4, found " + bad);
    	}

        // 3️. Validate Total Dreams = 10
        int total = dreamsSummaryPg.getTotalDreamCount();
        logger.info("Total dreams count: " + total);
        softAssert.assertEquals(total, 10, "Total dreams count mismatch!");
        if (total == 10) {
    		logger.info("Total dreams count is correct.");
    	} else {
    		logger.error("Total dreams count is incorrect. Expected 10, found " + total);
    	}

        // 4️. Validate Recurring Dreams = 2
        int recurring = dreamsSummaryPg.getRecurringDreamCount();
        logger.info("Recurring dreams count: " + recurring);
        softAssert.assertEquals(recurring, 2, "Recurring dreams count mismatch!");
        if (recurring == 2) {
    		logger.info("Recurring dreams count is correct.");
    	} else {
    		logger.error("Recurring dreams count is incorrect. Expected 2, found " + recurring);
    	}

        // 5️. Check that recurring dreams include specific dream names
        boolean hasFlying = dreamsSummaryPg.containsRecurringDream("Flying over mountains");
        boolean hasMaze = dreamsSummaryPg.containsRecurringDream("Lost in maze");
        
        if (hasFlying) {
    		logger.info("'Flying over mountains' is listed as a recurring dream.");
    	} else {
    		logger.error("'Flying over mountains' is not found among recurring dreams.");
    	}

    	if (hasMaze) {
    		logger.info("'Lost in maze' is listed as a recurring dream.");
    	} else {
    		logger.error("'Lost in maze' is not found among recurring dreams.");
    	}

        
        ScreenshotUtil.takeScreenshot(TestBase.driver, "SummaryStatsAndRecurringDreams");
        logger.info("Screenshot captured: SummaryStatsAndRecurringDreams");

        softAssert.assertTrue(hasFlying, "'Flying over mountains' not found as recurring!");
        softAssert.assertTrue(hasMaze, "'Lost in maze' not found as recurring!");

        softAssert.assertAll();
        logger.info("Test Completed: Summary Stats and Recurring Dreams validated successfully.");
    }
}
