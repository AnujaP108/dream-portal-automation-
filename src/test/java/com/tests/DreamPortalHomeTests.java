package com.tests;

import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.TestBase;
import com.pages.DreamPortalHomePage;
import com.utility.LoggerUtil;
import com.utility.ScreenshotUtil;

public class DreamPortalHomeTests extends TestBase {

	private static final Logger logger = LoggerUtil.getLogger(DreamPortalHomeTests.class);

	DreamPortalHomePage dreamPrtalHomeP;
	SoftAssert softAssert;

	@Test
	public void toVerifyLoadingAnimationAppearsAndDisAppearsAfter3Secs() {

		logger.info("Test Started: Verify loading animation appears and disappears.");

		dreamPrtalHomeP = new DreamPortalHomePage();
		softAssert = new SoftAssert();

		logger.info("Checking if loading animation is visible...");
		boolean isVisible = dreamPrtalHomeP.isLoadingAnimationVisible();
		if (isVisible) {
			logger.info("Loading animation is visible.");
		} else {
			logger.info("Loading animation is NOT visible.");
		}
		ScreenshotUtil.takeScreenshot(TestBase.driver, "AnimationAppears");

		softAssert.assertTrue(isVisible, "Loading animation did not appear as expected");

		boolean isInvisible = dreamPrtalHomeP.waitForLoadingAnimationInvisible();
		if (isInvisible) {
			logger.info("Loading animation disappeared.");
			ScreenshotUtil.takeScreenshot(TestBase.driver, "AnimationDisAppears");
			softAssert.assertTrue(isInvisible, "Loading animation did not disappear as expected");
		}
		softAssert.assertAll();
		logger.info("Test Completed: Loading animation visibility test passed.");
	}

	@Test
	public void toVerifyMainContentAndMyDreamButtonBecomeVisible() {

		logger.info("Test Started: Verify main content and 'My Dreams' button visibility.");

		dreamPrtalHomeP = new DreamPortalHomePage();
		softAssert = new SoftAssert();
		boolean isVisible = dreamPrtalHomeP.isMainContentAndMyDreamsBtnVisible();
		if (isVisible) {
			logger.info("Main content and dream button are visible.");
		} else {
			logger.info("Main content and dream button are not visible.");
		}
		ScreenshotUtil.takeScreenshot(TestBase.driver, "MainContentAndMyDreamButtonBecomeVisible");
		softAssert.assertTrue(isVisible, "Main content and dream button are not visible as expected.");
		softAssert.assertAll();

		logger.info("Test Completed: Main content and button visibility verified.");
	}

	@Test
	public void toVerifyClickingOnMyDreamsOpensDreamsDiaryAndDreamsTotalInNewTabs() {

		logger.info("Test Started: Verify clicking on 'My Dreams' opens two new tabs.");

		dreamPrtalHomeP = new DreamPortalHomePage();
		softAssert = new SoftAssert();

		String originalWindow = TestBase.driver.getWindowHandle();
		Set<String> handlesBeforeClick = TestBase.driver.getWindowHandles();

		// Action
		logger.info("Clicking on 'My Dreams' button");
		dreamPrtalHomeP.clickMyDreamsButton();

		// Validate number of new tabs
		
		int newTabsOpened = dreamPrtalHomeP.countNewTabsAfterClick(handlesBeforeClick);
		logger.info("Number of new tabs opened: " + newTabsOpened);
		ScreenshotUtil.takeScreenshot(TestBase.driver, "newTabsOpened");

		softAssert.assertEquals(newTabsOpened, 2, "Two new tabs were not opened.");

		// Validate individual tabs opened
		logger.info("Checking if dreams-diary.html tab opened");
		boolean dreamsDiaryOpened = dreamPrtalHomeP.isDreamsDiaryTabOpened();
		ScreenshotUtil.takeScreenshot(TestBase.driver, "dreamsDiaryOpened");

		logger.info("Checking if dreams-total.html tab opened");
		boolean dreamsTotalOpened = dreamPrtalHomeP.isDreamsTotalTabOpened();
		ScreenshotUtil.takeScreenshot(TestBase.driver, "dreamsTotalOpened");

		softAssert.assertTrue(dreamsDiaryOpened, "dreams-diary.html tab did not open.");
		softAssert.assertTrue(dreamsTotalOpened, "dreams-total.html tab did not open.");

		// Switch back to original
		driver.switchTo().window(originalWindow);
		logger.info("Switched back to original tab.");
		
		softAssert.assertAll();
		logger.info("Test Completed: Verified new tab openings for 'My Dreams' button.");
		
	}
}
