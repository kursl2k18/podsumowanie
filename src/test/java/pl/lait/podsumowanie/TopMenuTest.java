package pl.lait.podsumowanie;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenuTest {
	
	@Test
	public void topMenu() {
		WebDriver driver = Init.getDriver();
		driver.findElement(By.linkText("About")).click();
		Init.printScr(driver);
		driver.quit();
	}
	
	@Test
	public void topMenu2() {
		WebDriver driver = Init.getDriver();
		driver.findElement(By.linkText("Support")).click();
		Init.printScr(driver);
		driver.quit();
	}

}
