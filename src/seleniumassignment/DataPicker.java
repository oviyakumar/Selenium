package seleniumassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataPicker {
	@Test

	public static void main() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/datepicker/");
		
		WebElement dateBox = driver.findElement(By.xpath("//input[@id='datepicker']"));
		dateBox.sendKeys("04/26/1996");
		System.out.println("Happy Happy Birthday");
		
		Thread.sleep(3000);
		driver.close();



	}

}
