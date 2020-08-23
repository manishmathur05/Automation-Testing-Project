package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FIlter {
	
	WebDriver driver;
	
	@Given("user enters website") 
	public void user_enters_website() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\manish.mathur\\EllipsePhoton\\SeleniumFramework\\drivers\\geckodriver\\geckodriver.exe" );
		
	     driver = new FirefoxDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://freecrm.co.in/");
 	    Thread.sleep(3000);
		driver.findElement( By.xpath("//span[@class='icon icon-xs mdi-chart-bar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		Thread.sleep(2000);
		driver.findElement( By.xpath("//div[@class='ui fluid large blue submit button'][contains(.,'Login')]")).click();
		Thread.sleep(2000);
	    
	}

	@Then("user clicks on companies and filter") 
	public void user_clicks_on_companies_and_filter() throws InterruptedException{
	  
		driver.findElement(By.xpath("//a[@href='/companies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(.,'Show Filters')]")).click();
		Thread.sleep(2000);
		
	}

	@Then("user enters conditions of filter") 
	public void user_enters_conditions_of_filter() throws InterruptedException{
	  
		driver.findElement(By.xpath("(//i[@aria-hidden='true'])[18]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='option'][contains(.,'Name')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[contains(@aria-hidden,'true')])[19]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='option'][contains(.,'Contains')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='value']")).sendKeys("max");
		Thread.sleep(2000);
	}

	@Then("user apply filter method") 
	public void user_apply_filter_method() throws InterruptedException{
		
		driver.findElement(By.xpath("//i[@class='search small icon']")).click();
		Thread.sleep(2000);
		
	    
	}



}
