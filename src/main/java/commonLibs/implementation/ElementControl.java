package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementControl {

	WebDriver driver;
	public ElementControl(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}
	
	public void clear(WebElement element) {
		element.clear();
	}
	public void setText(WebElement element, String text) {
		element.sendKeys(text);
	}
	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	
 public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public String getTextFromAlert() {
		return driver.switchTo().alert().getText();
	}

	
	
}
