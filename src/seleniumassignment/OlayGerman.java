package seleniumassignment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OlayGerman {

	@Test
	public  void main() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://www.olaz.de/de-de");
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		 
		 driver.findElement(By.xpath("//a[@href='/de-de/loginpage']")).click();
		 
		 WebElement emailTextBx =driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_username']"));
		 emailTextBx .click();  
		 Random randomGenerator = new Random();  
		 int randomInt = randomGenerator.nextInt(1000);  
		 emailTextBx.sendKeys("username"+ randomInt +"@gmail.com");  
		 
		 WebElement emailpasswordBx =driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_password']"));
		 emailpasswordBx.click();
		 int randomPass=randomGenerator.nextInt(100);
		 emailpasswordBx.sendKeys("Ovikumar"+ randomPass);
		 driver.findElement(By.xpath("//*[@id='phdesktopbody_0_ANMELDEN']")).click();
		 
		String errorMessage=driver.findElement(By.xpath("//*[@id='phdesktopbody_0_Message']")).getText();
		System.out.println(errorMessage);
		
		driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
		
		driver.findElement(By.xpath("//*[@id='phdesktopbody_0_RegisterLink']")).click();
		
		driver.findElement(By.xpath("//*[@id='phdesktopbody_0_imgfemale']")).click();
		driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_consumer[firstname]']")).click();
		driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_consumer[firstname]")).sendKeys("Oviya");
		driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_consumer[lastname]']")).click();
        driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_consumer[lastname]']")).sendKeys("Kumar");
		WebElement userNameBx =driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[emails][0][address]']"));
		userNameBx.click();
		int randomAddress = randomGenerator.nextInt(1000);  
		userNameBx.sendKeys("username"+ randomAddress +"@gmail.com");  
		
		String emailAddress = driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[emails][0][address]']")).getText();
		System.out.println("Registered EmailAddress is" + emailAddress);
		
		
		WebElement passwordBx =driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[password][password]']"));
		passwordBx.click();
		int randompassword = randomGenerator.nextInt(100);  
		userNameBx.sendKeys("Oviyakumar"+ randompassword);  
		
		String Password = driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[password][password]']")).getText();
		System.out.println("Registered Password is" + Password);
		driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[password][confirm]']")).sendKeys(Password);
		
		
		
		driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_username']")).sendKeys("oviyakumar08@yahoo.com");
//		 
//		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_grs_account[emails][0][address]']")).click();
//		 driver.findElement(By.xpath("//*[@name='phdesktopbody_0$phdesktopbody_0_password']")).sendKeys("Ovikumar18");
//		 driver.findElement(By.xpath("//*[@id='phdesktopbody_0_ANMELDEN']")).click();
	}

}
