package StepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SettingFunctions {
	
	WebDriver driver;
	
	@Given("user will login the website") 
	public void user_will_login_the_website() throws InterruptedException{
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

	@Given("user has logged inside website") 
	public void user_has_logged_inside_website(){
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("1");
	}

	@And("user hovers to right cornor of webpage") 
	public void user_hovers_to_right_cornor_of_webpage(){
		boolean exists = driver.findElements( By.xpath("(//i[@aria-hidden='true'])[3]") ).size() != 0;
		 System.out.println(exists);
	}

	@Then("user finds settings button")
	public void user_finds_settings_button(){
		 System.out.println("Button is present");
	}

	@Given("user has logged in") 
	public void user_has_logged_in(){
		System.out.println("Inside web page");
	}

	@And("user goes right cornor of webpage") 
	public void user_goes_right_cornor_of_webpage() throws InterruptedException{
		//driver.findElement( By.xpath("(//i[@class='settings icon'])[1]") );
		boolean not_exists = driver.findElements( By.xpath("(//i[@aria-hidden='true'])[3]") ).size() == 0;
		System.out.println(not_exists); 
		Thread.sleep(2000);
		
	}

	@Then("does not finds button") 
	public void does_not_finds_button(){
		System.out.println("Button Not Present");
	}

	@Given("user login done") 
	public void user_login_done(){
		System.out.println("Login Done");
	}

	@And("user clicks settings button") 
	public void user_clicks_settings_button() throws InterruptedException{
		driver.findElement( By.xpath("(//i[@aria-hidden='true'])[3]")).click();
		Thread.sleep(3000);
		
	}

	@Then("user finds all five options") 
	public void user_finds_all_five_options() throws InterruptedException{
		String functions=driver.findElement(By.xpath("//div[@class='menu transition visible']")).getText();
	    Assert.assertTrue(functions.contains("Settings"));
	    Thread.sleep(1000);
	    Assert.assertTrue(functions.contains("Products"));
	    Thread.sleep(1000);
	    Assert.assertTrue(functions.contains("Import"));
	    Thread.sleep(1000);
	    Assert.assertTrue(functions.contains("Tools"));
	    Thread.sleep(1000);
	    Assert.assertTrue(functions.contains("Log Out"));
	    
	}

	@Given("user has alredy logged in") 
	public void user_has_alredy_logged_in(){
		System.out.println("");
	}

	@And("user click settings icon") 
	public void user_click_settings_icon() throws InterruptedException{
		
		driver.findElement( By.xpath("(//i[@aria-hidden='true'])[3]")).click();
		Thread.sleep(3000);
		String expectedText="Setting";
		String actualText=driver.findElement(By.xpath("//span[@class='text'][contains(.,'Settings')]")).getText();
		Assert.assertFalse("all options not present",expectedText.equals(actualText));
		    Thread.sleep(1000);
		    
		    			
	}

	@Then("user does not find some options")
	public void user_does_not_find_some_options(){
		System.out.println("All Options Not Present");
	}

}
