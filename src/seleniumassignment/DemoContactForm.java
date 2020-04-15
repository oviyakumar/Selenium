package seleniumassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class DemoContactForm {

	public void main() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://demoqa.com/html-contact-form/");
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("//*[@class='firstname']")).click();
		 driver.findElement(By.xpath("//*[@class='firstname']")).sendKeys("Oviya");
		 driver.findElement(By.xpath("//*[@id='lname']")).click();
		 driver.findElement(By.xpath("//*[@id='lname']")).sendKeys("K");
		 driver.findElement(By.xpath("//*[@name='country']")).click();
		 driver.findElement(By.xpath("//*[@name='country']")).sendKeys("Chennai");
		 driver.findElement(By.xpath("//*[@id='subject']")).click();
		 driver.findElement(By.xpath("//*[@id='subject']")).sendKeys("I Want to submit my entry");
		 /// driver.findElement(By.linkText("Google Link")).click();

		 
		 
		  String link1 = Keys.chord(Keys.CONTROL,Keys.ENTER); 
		  driver.findElement(By.linkText("Google Link")).sendKeys(link1);
		  driver.findElement(By.linkText("Google Link is here")).sendKeys(link1);
		  
		  
		  driver.findElement(By.xpath("//*[@type='submit']")).click();
		//.findElement(By.xpath("//*[@type='submit']")).switchtonewtab();
		//*[@id='subject']
		//*[@id='lname']
		
	}

}
