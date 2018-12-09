package pl.lait.podsumowanie;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Common {
	
	static WebDriver driver;
	
	public static void goToMainPage() {
		driver = Init.getDriver();
	}
	
	public static void linkClick(String linkText) {
		try {
			driver.findElement(By.linkText(linkText)).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Init.printScr(driver);
			assertTrue("Nie znalazłem linku: " +
			linkText, false);
		}
	}

}
