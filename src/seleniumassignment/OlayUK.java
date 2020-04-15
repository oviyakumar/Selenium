package seleniumassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OlayUK {

	@Test
	public  void main() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 
		
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		 
		 driver.get("https://www.olay.co.uk/en-gb");
		 
		 // Method to register 
		 driver.findElement(By.xpath("//a[@href='/en-gb/createprofilepage'][1]")).click();
		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[emails][0][address]']")).click();
		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[emails][0][address]']")).sendKeys("oviyakumar08@yahoo.com");
		 
		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[password][password]']")).click();
		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[password][password]']")).sendKeys("Ovikumar18");
		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[password][confirm]']")).click();
		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[password][confirm]']")).sendKeys("Ovikumar18");
		 
		 
		 Select date=new Select(driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][day]']")));
		 date.selectByVisibleText("18");
		 Select month=new Select(driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][month]']")));
		 month.selectByVisibleText("5");
		 Select year=new Select(driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_consumer[birthdate][year]']")));
		 year.selectByVisibleText("1996");
		 
		 
		 driver.findElement(By.xpath("//*[@id='onetrust-reject-all-handler']")).click();
		 driver.findElement(By.xpath("//*[@id='phdesktopbody_0_submit']")).click();
		 
		String alreadyRegistered = driver.findElement(By.xpath("//*[@id='phdesktopbody_0_ErrorMessage']")).getText();
		 System.out.println(alreadyRegistered);
		 
		 //Method to Sign in
		 driver.findElement(By.xpath("//*[@id='phdesktopbody_0_SiteLink']")).click();
		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_username']")).click();
		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_username']")).sendKeys("oviyakumar08@yahoo.com");
		 
		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_password']")).click();
		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_password']")).sendKeys("Ovikumar18");
		 driver.findElement(By.xpath("//*[@id='phdesktopbody_0_SIGN IN']")).click();
	}

}
