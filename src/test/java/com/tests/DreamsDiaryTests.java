package com.tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.TestBase;
import com.pages.DreamsDiaryPage;
import com.utility.LoggerUtil;
import com.utility.ScreenshotUtil;

public class DreamsDiaryTests extends TestBase {
	
	private static final Logger logger = LoggerUtil.getLogger(DreamPortalHomeTests.class);

	DreamsDiaryPage diaryPage;

	@Test
	public void toValidateDreamLogTableData() {
		
		logger.info("Test Started: Validate Dream Log Table - Data");

		diaryPage = new DreamsDiaryPage();
		SoftAssert softAssert = new SoftAssert();

		// 1️. Check if there are exactly 10 dream entries
		int count = diaryPage.getTotalDreamCount();
		logger.info("Total dream entries found: " + count);
		softAssert.assertEquals(count, 10, "Dream entries should be exactly 10.");

		// 2️. Validate dream types are only Good or Bad
		boolean validTypes = diaryPage.areAllDreamTypesValid();
		logger.info("Dream types are only Good or Bad: " + validTypes);
		softAssert.assertTrue(validTypes, "Invalid dream types found. Should only be 'Good' or 'Bad'.");

		// 3️. Validate each row has all 3 columns filled
		boolean allColumnsFilled = diaryPage.areAllColumnsFilled();
		logger.info("Each row has all 3 columns filled: " + allColumnsFilled);
		
		ScreenshotUtil.takeScreenshot(TestBase.driver, "DreamLogTableData");
		
		softAssert.assertTrue(allColumnsFilled, "Some rows have empty columns or missing data.");
		softAssert.assertAll();
		logger.info("Test Completed: Dream Log Table data validated.");
	}
}
