package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DeletingData {
	
	WebDriver driver;
	
	@Given("user will log in") 
	public void user_will_log_in() throws InterruptedException{
	    
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

	@Then("user will select data") 
	public void user_will_select_data() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@href='/companies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])")).click();
		Thread.sleep(2000);
	}

	@And("user will delete the data") 
	public void user_will_delete_the_data() throws InterruptedException {
		
		driver.findElement(By.xpath("(//i[contains(@class,'dropdown icon')])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='option'][contains(.,'Delete')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='checkmark icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='ui button'][contains(.,'Delete')]")).click();
		Thread.sleep(2000);
	    
	}

}
