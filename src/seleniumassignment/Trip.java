package seleniumassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Trip {

	public static  void selectingDropdown(String found, String Expected, WebDriver driver) {
		
		while(!found.equalsIgnoreCase(Expected))
		{
			driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys(Keys.DOWN);
			 found=driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).getAttribute("value");
			
		}
		driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys(Keys.ENTER);
	}
		// TODO Auto-generated method stub

	}


