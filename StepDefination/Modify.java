package StepDefination;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Modify {
	
	WebDriver driver;
	
	@Given("user login") 
	public void user_login() throws InterruptedException{
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

	@Given("user has already logged in") 
	public void user_has_already_logged_in(){
	    System.out.println("Inside Webpage");
	}

	@Then("user clicks on company and goes to last page") 
	public void user_clicks_on_company_and_goes_to_last_page() throws InterruptedException{
	    
		driver.findElement(By.xpath("//a[@href='/companies']")).click();
		Thread.sleep(2000);
		
	
	}

	@Then("user modifies the values") 
	public void user_modifies_the_values() throws InterruptedException{
	    
		driver.findElement(By.xpath("//body//div[@class='ui fluid container']//div[@class='ui fluid container']//a[12]")).click();
		Thread.sleep(4000);
		List<WebElement> phones=driver.findElements(By.xpath("//i[@class='edit icon']"));
		Thread.sleep(2000);
		
		
	
		System.out.println(phones.size());
		Iterator<WebElement> i=phones.iterator();
		int counter=0;
		while(i.hasNext() && counter<5)
		{
		driver.findElement(By.xpath("//i[@class='edit icon']")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ui right corner labeled input']//input[@name='name']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ui right corner labeled input']//input[@name='name']")).sendKeys("IPHONE");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Companies')]")).click();  
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body//div[@class='ui fluid container']//div[@class='ui fluid container']//a[12]")).click();
		counter++;
		}
		Thread.sleep(3000);
	}

	@Then("user finds modified values")  
	public void user_finds_modified_values() throws InterruptedException{
		
		driver.findElement(By.xpath("//a[@class='item active'][contains(.,'1')]")).click();
		Thread.sleep(2000);
		String expectedText="IPHONE";
		String actualText=driver.findElement(By.xpath("(//td[contains(.,'IPHONE')])[1]")).getText();
		Thread.sleep(2000);
		Assert.assertTrue("Successful",expectedText.equals(actualText));
		
	}

	@Given("already logged in webpage") 
	public void already_logged_in_webpage(){
	   
	}

	@Then("user clicks on company and goes to end") 
	public void user_clicks_on_company_and_goes_to_end() throws InterruptedException{
		
		driver.findElement(By.xpath("//a[@href='/companies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body//div[@class='ui fluid container']//div[@class='ui fluid container']//a[12]")).click();
		Thread.sleep(4000);
	    
	}

	@Then("user does not find modified values") 
	public void user_does_not_find_modified_values() throws InterruptedException{
	   
		String expectedText="IPHONE";
		String actualText=driver.findElement(By.xpath("//td[contains(.,'Asus Zenfone Max Pro M1 (Blue, 64 GB)')]")).getText();
		Thread.sleep(2000);
		Assert.assertFalse("Not Modified",expectedText.equals(actualText));
		System.out.println("User Not find modified value");
		
	}

}
