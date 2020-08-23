package StepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage {
	
	WebDriver driver;
	
	@Given("user is on login page") 
	public void user_is_on_login_page() throws InterruptedException {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\manish.mathur\\EllipsePhoton\\SeleniumFramework\\drivers\\geckodriver\\geckodriver.exe" );
		
	     driver = new FirefoxDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://freecrm.co.in/");
     	Thread.sleep(3000);
		driver.findElement( By.xpath("//span[@class='icon icon-xs mdi-chart-bar']")).click();
	    System.out.println("1");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password ) throws InterruptedException{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Thread.sleep(2000);
		
		
		//System.out.println("2");
	}

	@When("clicks on login button") 
	public void clicks_on_login_button() throws InterruptedException{
		driver.findElement( By.xpath("//div[@class='ui fluid large blue submit button'][contains(.,'Login')]")).click();
		Thread.sleep(2000);
		//System.out.println("3");
	}

	@Then("user is navigated to home page") 
	public void user_is_navigated_to_home_page(){
		String expectedText="Manish Mathur";
		String actualText=driver.findElement(By.xpath("//span[@class='user-display'][contains(.,'Manish  Mathur')]")).getText();
		Assert.assertTrue("Login  successful",expectedText.equals(actualText));
	}

	@Given("user is inside login page")
	public void user_is_inside_login_page() throws InterruptedException {
		user_is_on_login_page();
	}

	@When("user enter his (.*) and (.*)") 
	public void user_enter_his_and_manish(String name,String passw) throws InterruptedException{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passw);
		Thread.sleep(2000);
	}

	@When("user click on button") 
	public void user_click_on_button() throws InterruptedException{
		driver.findElement( By.xpath("//div[@class='ui fluid large blue submit button'][contains(.,'Login')]")).click();
		Thread.sleep(2000);
	}

	@Then("User is not allowed to logg in") 
	public void user_is_not_allowed_to_logg_in(){
		String expectedText="Login";
		String actualText=driver.findElement(By.xpath("//div[contains(@class,'ui fluid large blue submit button')]")).getText();
		Assert.assertTrue("Login  Not successful",expectedText.equals(actualText));
	}



}
