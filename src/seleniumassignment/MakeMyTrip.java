package seleniumassignment;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;


public class MakeMyTrip {

	@Test
	public static void main() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
    	//System.setProperty("webdriver.gecko.driver","C:/Users/VIP/Downloads/geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();	
		//WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		// Opening makemytrip.com
		driver.get("https://www.makemytrip.com/");
		//Thread.sleep(3000);//waiting for the page to load
		//validating whether we are navigated to crct site or not
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());//Printing site title
		//Validating, Flights option is selected by default or not
		if(driver.findElement(By.xpath("//li[@class='menu_Flights']/a")).getAttribute("class").contains("active"))
		{
			System.out.println("Flights is selected by default");
		}
		else
		{
			System.out.println("Flights is not selected by default. Please select flights");
			driver.findElement(By.xpath("//li[@class='menu_Flights']/a")).click();
		}
		//Validating, One way trip is selected by default or not
		if(!driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).isSelected())//some times isselected method is not working properly so used negation
		{
			System.out.println("One way trip is selected by default");
		}
		else
		{
			System.out.println("One way trip is not selected by default. Please select one way trip");
			driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();
			
		}
		//driver.findElement(By.id("fromCity")).click()
		//String s=driver.findElement(By.id("fromCity")).getAttribute("value");
		//System.out.println(s);
		
		//Selecting chennai as fromcity
		System.out.println("***Selecting chennai as fromcity***");
		String fromcity="chennai";
		driver.findElement(By.id("fromCity")).sendKeys("chen");
		//Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys(Keys.DOWN);
		//Thread.sleep(2000);
		String value=driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).getAttribute("value");
		MakeMyTrip.selectingDropdown(value,fromcity,driver);
		String fromcit=driver.findElement(By.id("fromCity")).getAttribute("value");
		System.out.println("From City is selected as "+fromcit);
		
		//Selecting Mumbai as To city
		System.out.println("***Selecting Mumbai as To city***");
		String toCity="mumbai";
		driver.findElement(By.id("toCity")).sendKeys("mum");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys(Keys.DOWN);
		String value2=driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).getAttribute("value");
		MakeMyTrip.selectingDropdown(value2,toCity,driver);
		String toCit=driver.findElement(By.id("toCity")).getAttribute("value");
		System.out.println("To City is selected as "+toCit);
		//Selecting departure date as 23rd Aug 2020
		driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click();
		WebElement dDate=driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Caption']/div"));
		String month=dDate.getText();
		//driver.findElement(By.xpath("//div[@class='DayPicker-NavBar']//span[@aria-label='Next Month']")).click();
		//selecting August month
		while(!month.contains("August"))
		{
			driver.findElement(By.xpath("//div[@class='DayPicker-NavBar']//span[@aria-label='Next Month']")).click();
			month=dDate.getText();
		}
		List<WebElement> day=driver.findElements(By.xpath("//div[@class='DayPicker-Month'][1]//div[3]//div[@class='DayPicker-Day']/div"));
		int count=day.size();
		//System.out.println(month);
		//System.out.println(count);
		//selecting 23rd day of august
		String text=null;
		for (int i = 0; i < count; i++) {
			 text =day.get(i).getText();
			if (text.equalsIgnoreCase("23")) {
				day.get(i).click();
				break;
			}
			}
		System.out.println("Departure date is selected as "+text+" "+month);//printing departure date
		String depeDate= text+" "+month;
		String Date=depeDate.substring(0,6);
		//Validating return date option is disabled for one way trip
		//when return date is enabled the last index value of space is 42
		//when return date is disabled the last index value of space is 41
		String retur=driver.findElement(By.xpath("//div[@class='fsw_inner ']//div[4]")).getAttribute("class");
		int index1=retur.lastIndexOf(" ");//returns last index of 'space' char value  
		//System.out.println(index1);
		if(index1==41)
		{
			System.out.println("OneWay trip is selected, So return date is disabled");
		}
		else
		{
			System.out.println("Return date is enabled");
		}
		
		driver.findElement(By.cssSelector("[class='fsw_inputBox flightTravllers inactiveWidget ']")).click();
		//selecting five adults
		List<WebElement> adult=driver.findElements(By.xpath("//*[text()='ADULTS (12y +)']/following-sibling::ul[1]/li"));
		int ad=adult.size();
		String adultValue=null;
		for(int i=0;i<ad;i++)
		{
			adultValue=adult.get(i).getAttribute("data-cy");
			if(adultValue.equalsIgnoreCase("adults-5"))
			{
				adult.get(i).click();
				break;
			}
		}
		System.out.println(adultValue+" is selected");// printing selected values of adults
		//Validation of travel class is selected by default or not
		String eco=driver.findElement(By.xpath("//*[text()='CHOOSE TRAVEL CLASS']/following-sibling::ul/li[1]")).getAttribute("class");
		if(eco.equalsIgnoreCase("Selected"))
		{
			System.out.println("Economy/Premium Economy is selected by default");
		}
		else
		{
			System.out.println("Economy/Premium Economy is not selected by default");
		}
		//Clicking on apply button after selecting passenger details
		driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
		String splFare=driver.findElement(By.xpath("//ul[@class='specialFare']/li[1]")).getAttribute("class");
		//Validating, Regular fare is selected by default or not
		if(splFare.contains("activeItem"))
		{
			System.out.println("Regular fare is selected by default");
		}
		else
		{
			System.out.println("Regular fare is not selected by default");

		}
		//Clicking on search to find flights
		driver.findElement(By.xpath("//p[@data-cy='submit']//a")).click();
		//Thread.sleep(3000);
		List<WebElement> price=driver.findElements(By.xpath("//div[@class='fli-list one-way']//span[@class='actual-price']"));
		int fare1=9999;
		for(int i=0;i<price.size();i++)
		{
			String p=price.get(i).getText().replaceAll("[^a-zA-Z0-9]", "");
			//System.out.println(p);
			int fare2=Integer.parseInt(p);
			if(fare2<fare1)
			{
				fare1=fare2;
			}
			
		}
		List<WebElement> book=driver.findElements(By.xpath("//div[@class='pull-left make_relative']"));
		for(int i=0;i<book.size();i++)
		{
			String p=price.get(i).getText().replaceAll("[^a-zA-Z0-9]", "");
			int fare2=Integer.parseInt(p);
			if(fare2==fare1)
			{
				book.get(i).click();// selects the first flight in low price
				break;
			}

		}
		//Thread.sleep(5000);
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parentWin=id.next();
		String childWin=id.next();
		driver.switchTo().window(childWin);
		//review page validation
		String deptCity=driver.findElement(By.xpath("//p[@class='dept-city']//span")).getText();
		String arrivCity=driver.findElement(By.xpath("//p[@class='arrival-city']//span")).getText();
		String deptDate=driver.findElement(By.xpath("//p[@class='dept-city']/preceding-sibling::p[@class='font14 append_bottom3 LatoBold']")).getText();
		String noOfAdult=driver.findElement(By.xpath("//span[@class='fareSmry-field']")).getText();
		String nOfad=noOfAdult.replaceAll("[^a-zA-Z0-9]", "").substring(0, 7).toLowerCase();
		//System.out.println(deptCity);
		System.out.println("//***Review Page Validation***//");
		MakeMyTrip.validation(deptCity, fromcit);
		//System.out.println(arrivCity);
		MakeMyTrip.validation(arrivCity, toCit);
		//System.out.println(deptDate);
		MakeMyTrip.validation(deptDate, Date);
		String advalue=adultValue.replaceAll("[^a-zA-Z0-9]", "");
		//System.out.println(advalue);
		MakeMyTrip.validation(nOfad, advalue);
		driver.quit();
		
	}
	//Method for selecting from and to cities
	public static void selectingDropdown(String found, String Expected, WebDriver driver)
	{
		while(!found.equalsIgnoreCase(Expected))
		{
			driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys(Keys.DOWN);
			 found=driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).getAttribute("value");
			
		}
		driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys(Keys.ENTER);
	}
	//Review page validation
	public static void validation(String found, String Expected)
	{
		if(found.contains(Expected))
		{
			System.out.println(found+" - Exepcted Value found");
		}
		else
		{
			System.out.println(found+" - Unexpected value found");
		}
	}	
}
