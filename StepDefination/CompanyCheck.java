package StepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CompanyCheck {
	
	WebDriver driver;
	
	@Given("user is logged on website") 
	public void user_is_logged_on_website() throws InterruptedException{
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

	@And("user will navigate to menu") 
	public void user_will_navigate_to_menu(){
		String expectedText="Companies";
		String actualText=driver.findElement(By.xpath("//a[@href='/companies']")).getText();
		Assert.assertTrue("Successful",expectedText.equals(actualText));
	   
	}

	@Then("user will look for company in menu") 
	public void user_will_look_for_company_in_menu(){
		
	    System.out.println("Companies is present in main menu");
	}


}
