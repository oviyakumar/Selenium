package seleniumassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Droppable {
	@Test

	public static void main() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://demoqa.com/droppable/");					
         
			//Element which needs to drag.    		
	        	WebElement From=driver.findElement(By.xpath("//*[@id='draggable']"));	
	         
	         //Element on which need to drop.		
	         WebElement To=driver.findElement(By.xpath("//*[@id='droppable']"));					
	         		
	         //Using Action class for drag and drop.		
	         Actions act=new Actions(driver);					

		//Dragged and dropped.		
	         act.dragAndDrop(From, To).build().perform();	
	         
	        String dragText= driver.findElement(By.xpath("//*[@id='draggable']")).getText();
	        System.out.println(dragText);
	        Assert.assertEquals(dragText, "Drag me to my target");
	        String dropText= driver.findElement(By.xpath("//*[@id='droppable']")).getText();
	        System.out.println(dropText);
	        Assert.assertEquals(dropText, "Dropped!");
		}		
		 
		 
		

	}

