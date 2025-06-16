package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class DreamSummaryPage {

	public DreamSummaryPage() {
        PageFactory.initElements(TestBase.driver, this);
    }

    public int getGoodDreamCount() {
        String text = TestBase.driver.findElement(By.xpath("//*[@id=\"dreamsTotal\"]/tbody/tr[1]")).getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));//   //*[@id="dreamsTotal"]/tbody/tr[1]
    }

    public int getBadDreamCount() {
        String text = TestBase.driver.findElement(By.xpath("//*[@id=\"dreamsTotal\"]/tbody/tr[2]")).getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public int getTotalDreamCount() {
        String text = TestBase.driver.findElement(By.xpath("//*[@id=\"dreamsTotal\"]/tbody/tr[3]")).getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public int getRecurringDreamCount() {
        String text = TestBase.driver.findElement(By.xpath("//*[@id=\"dreamsTotal\"]/tbody/tr[5]")).getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public boolean containsRecurringDream(String dreamName) {
        return TestBase.driver.getPageSource().contains(dreamName);
    }
}
