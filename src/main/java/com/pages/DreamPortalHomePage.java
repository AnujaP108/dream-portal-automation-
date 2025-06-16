package com.pages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.base.TestBase;

public class DreamPortalHomePage {

	@FindBy(xpath = "//div[@class='loading-animation']")
	private WebElement loadingAnimation; 

	@FindBy(xpath = "//div[@class='loading-animation hidden']")
	private WebElement loadingAnimationInvisible;

	@FindBy(id = "mainContent")
	private WebElement mainContent;

	@FindBy(id = "dreamButton")
	private WebElement myDreamsButton;

	public DreamPortalHomePage() {
		PageFactory.initElements(TestBase.driver, this);
	}

	public boolean isLoadingAnimationVisible() {
		return loadingAnimation.isDisplayed();
	}

	public boolean waitForLoadingAnimationInvisible() {
		new WebDriverWait(TestBase.driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.invisibilityOf(loadingAnimationInvisible));
		return true;
	}

	public boolean isMainContentAndMyDreamsBtnVisible() {
		if (mainContent.isDisplayed() && myDreamsButton.isDisplayed()) {
			System.out.println("Main content and 'My Dreams' button are visible.");
		}
		return true;
	}

	public void clickMyDreamsButton() {
		WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(myDreamsButton));
		myDreamsButton.click();
	}

	public boolean isDreamsDiaryTabOpened() {
		for (String handle : TestBase.driver.getWindowHandles()) {
			TestBase.driver.switchTo().window(handle);
			if (TestBase.driver.getCurrentUrl().contains("dreams-diary")) {
				System.out.println("dreams-diary.html tab opened.");
				return true;
			}
		}
		return false;
	}

	public boolean isDreamsTotalTabOpened() {
		for (String handle : TestBase.driver.getWindowHandles()) {
			TestBase.driver.switchTo().window(handle);
			if (TestBase.driver.getCurrentUrl().contains("dreams-total")) {
				System.out.println("dreams-total.html tab opened.");
				return true;
			}
		}
		return false;
	}

	public int countNewTabsAfterClick(Set<String> oldHandles) {
		Set<String> newHandles = TestBase.driver.getWindowHandles();
		return newHandles.size() - oldHandles.size();
	}
}
