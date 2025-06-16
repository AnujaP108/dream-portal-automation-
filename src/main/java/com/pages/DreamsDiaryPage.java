package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class DreamsDiaryPage {

	private List<WebElement> dreamRows;

    public DreamsDiaryPage() {
        PageFactory.initElements(TestBase.driver, this);
    }

    public int getTotalDreamCount() {
        dreamRows = TestBase.driver.findElements(By.xpath("//table/tbody/tr"));
        return dreamRows.size();
    }
	
    public boolean areAllDreamTypesValid() {
        List<WebElement> typeCells = TestBase.driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        for (WebElement typeCell : typeCells) {
            String type = typeCell.getText().trim();
            if (!(type.equals("Good") || type.equals("Bad"))) {
                System.out.println("Invalid Dream Type: " + type);
                return false;
            }
        }
        return true;
    }
    
    public boolean areAllColumnsFilled() {
        dreamRows = TestBase.driver.findElements(By.xpath("//table/tbody/tr"));
        for (WebElement row : dreamRows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() < 3) {
                System.out.println("Row does not have 3 columns: " + row.getText());
                return false;
            }
            for (WebElement col : cols) {
                if (col.getText().trim().isEmpty()) {
                    System.out.println("Empty column found in row: " + row.getText());
                    return false;
                }
            }
        }
        return true;
    }
}
