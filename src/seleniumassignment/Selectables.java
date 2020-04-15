package seleniumassignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class Selectables {

	public void main() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://demoqa.com/selectable/");
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("//*[contains(text(),'Item 1')]")).click();
		 
		 List<WebElement> Item = driver.findElements(By.xpath("//*[contains(text(),'Item')]"));
		 
		 System.out.println(Item.size());
		 for (WebElement webElement : Item) {
	            String name = (webElement).getText();
	            System.out.println(name);
	        }
		 
		//String Item1= driver.findElement(By.xpath("//*[contains(text(),'Item 1')]")).getText();
		//System.out.println(Item1);
		
		 
	}

}
