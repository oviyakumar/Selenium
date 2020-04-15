package seleniumassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ControlGroup {

	@Test
	public  void main() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/controlgroup/");
		
		WebElement radio= driver.findElement(By.xpath("//*[@id='transmission-standard']"));
		radio.click();
		
//		Select select = new Select(driver.findElement(By.xpath("//*[@id='car-type']"))); 
//		select.selectByVisibleText("Midsize car"); 
	}

}
