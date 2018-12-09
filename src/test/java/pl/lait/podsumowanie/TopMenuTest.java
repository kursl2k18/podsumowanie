package pl.lait.podsumowanie;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenuTest extends Common{
	
	@Test
	public void topMenu() {
		//wywołaj metodę z klasy Common - go to main page - otwiera przeglądarkę i przechodzi do seleniumhq.org
		goToMainPage();
		//wywołaj metodę z klasy Common - sprawdzającą tytuł strony
		checkPageTitleAndStopTestIfWrong("Selenium - Web Browser Automation");
		//wywołaj metodę z klasy Common - linkClick()
		linkClick("About");
		linkClick("Support");
		linkClick("Documentation");
		linkClick("Download");
		linkClick("Projects");
		//wywołaj metodę z klasy Common - findInputByname - zwraca webBelement więc można "po kropce" wywołać click/sendKeys itp
		findInputByName("q").sendKeys("szukany tekst"); //wpisujemy tekst ale nie klikamy "submit" - tekst jest widoczny w okienku
		
		/*
		 * sprawdzanie czy element znaleziony na stronie zawiera określony tekst
		 */
		
		//1. umieszczam w zmiennej xPath z poszukiwanym elementem
		String h2xpath = "//*[@id=\"mainContent\"]/h2";
		//2. szukam elementu na stronie po XPATH
		String h2text = driver.findElement(By.xpath(h2xpath)).getText();
		//3. wyświetlam tekst ze znalezionego elementu
		System.out.println("#####"+h2text);
		//4. jeśli znaleziony element zawiera tekst "Selenium Projects"
		//to wyświetlam tekst "Znaleziono poprawny...."
		if(h2text.equals("Selenium Projects")) {
			System.out.println("Znaleziono popawny "
					+ "komunikat na stronie");
		}
		
		driver.quit();
	}
	
	
	// 
	@Test
	public void topMenu2() {
		//1. otworz stronę
		WebDriver driver = Init.getDriver();
		//2. pobierz tytuł strony
		String title = driver.getTitle();
		//3. wyświetl tytuł strony
		System.out.println(title);
		//4. kliknij w link "Support"
		driver.findElement(By.linkText("Support")).click();
		//5. zrób printScreen
		Init.printScr(driver);
		//6. pobierz tytuł strony po przejściu na zakładkę "Support"
		title = driver.getTitle();
		//7. wyświetl nowy tytuł strony
		System.out.println(title);
		//8. sprawdź czy tytuł strony jest równy "Getting Help" - jeśli nie - przerwij test
		assertTrue("Page title is wrong!", title.equals("Getting Help"));
		//9. zamknij przeglądarkę
		driver.quit();
	}
	
	@Test
	public void topMenu2wrongTitle() {
		//cały test jest identyczny jak poprzedni do linijki assertTrue...
		WebDriver driver = Init.getDriver();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.linkText("Support")).click();
		//Init.printScr(driver);
		
		title = driver.getTitle();
		
		System.out.println(title);
		//sprawdź czy tytuł strony to "Some wrong page title" - jeśli jest inny - przerwij test
		assertTrue("Page title is wrong!", title.equals("Some wrong page title"));

		driver.quit();
	}
	
	

}
