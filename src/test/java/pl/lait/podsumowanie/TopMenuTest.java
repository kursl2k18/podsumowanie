package pl.lait.podsumowanie;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenuTest extends Common{
	
	@Test
	public void topMenu() {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		goToMainPage();
		
		//Init.printScr(driver, "TopMenuTest", testName);
		//driver.findElement(By.linkText("About")).click();
		linkClick("About");
		Init.printScr(driver, "TopMenuTest", testName);
		//Init.printScr(driver);
		driver.quit();
	}
	
	@Test
	public void topMenu2() {
		WebDriver driver = Init.getDriver();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.linkText("Support")).click();
		Init.printScr(driver);
		
		title = driver.getTitle();
		
		System.out.println(title);
		
		assertTrue("Page title is wrong!", title.equals("Getting Help"));

		driver.quit();
	}
	
	@Test
	public void topMenu2wrongTitle() {
		WebDriver driver = Init.getDriver();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.linkText("Support")).click();
		Init.printScr(driver);
		
		title = driver.getTitle();
		
		System.out.println(title);
		
		assertTrue("Page title is wrong!", title.equals("Some wrong page title"));

		driver.quit();
	}
	
	

}
