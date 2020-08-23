package StepDefination;


import java.util.concurrent.TimeUnit;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CheckTotalMobile {
	
	WebDriver driver;
	
	@Given("login by user into website") 
	public void login_by_user_into_website() throws InterruptedException{
	    
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
	
	@Given("user alread inside") 
	public void user_alread_inside() throws InterruptedException{
     
		System.out.println("Inside Website");
	    
	}

	@Then("user navigate to last page") 
	public void user_navigate_to_last_page() throws InterruptedException{
		driver.findElement(By.xpath("//a[@href='/companies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body//div[@class='ui fluid container']//div[@class='ui fluid container']//a[12]")).click();
		Thread.sleep(4000);
	}

	@And("user findes nine mobile") 
	public void user_findes_nine_mobile(){
		 
		List<WebElement> allphones =driver.findElements(By.xpath("//td[contains(text(),'Asus')]"));
		int totalphones=allphones.size();
		String size=Integer.toString(totalphones);
		String expectedText="9";
		
		Assert.assertTrue("Successful",expectedText.equals(size));
		System.out.println("Mobile");
		
	    
	}
	
	@Given("user inside page") 
	public void user_inside_page() throws InterruptedException{
		System.out.println("Inside Website");
	}

	@Then("user goes to page") 
	public void user_goes_to_page() throws InterruptedException{
		driver.findElement(By.xpath("//a[@href='/companies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body//div[@class='ui fluid container']//div[@class='ui fluid container']//a[12]")).click();
		Thread.sleep(4000);
	    
	}

	@And("user findes ten mobiles") 
	public void user_findes_ten_mobiles(){
	  
		List<WebElement> allphones =driver.findElements(By.xpath("//td[contains(text(),'Asus')]"));
		int totalphones=allphones.size();
		String size=Integer.toString(totalphones);
		String expectedText="5";
		
		Assert.assertFalse("Successful",expectedText.equals(size));
	}


}
