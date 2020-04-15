package seleniumassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelectMenu {
	

	@Test

	public  void main() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/selectmenu/");
		
  //     	Select options =new Select(WebElement);
//       	WebElement speed =  driver.findElement(By.xpath("//*[@id='speed']"));
//       	options.selectByIndex(4);
//		
//		// Select file =new Select(driver.findElement(By.xpath("//*[@id='files']")));
//    	WebElement file =  driver.findElement(By.xpath("//*[@id='files']"));
//    	options.selectByVisibleText("jQuery.js");
////		
		
		WebElement number = driver.findElement(By.xpath("//*[@name='number']"));
		new WebDriverWait(driver, 15).until(
		            ExpectedConditions.elementToBeClickable(number));
		number.click();

		Select select = new Select(number);
	//	select.selectByValue("N");
	//	Select number =new Select(driver.findElement(By.xpath("//*[@name='number']")));
	//	number.deselectByIndex(2);
		((Select) number).selectByIndex(3);
		
		
//		Select title =new Select(driver.findElement(By.xpath("//*[@id='salutation']")));
//		title.selectByVisibleText("Mrs.");
		
		
		
		
		
	}

	

}
