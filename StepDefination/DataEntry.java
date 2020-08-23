package StepDefination;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DataEntry {
	
	WebDriver driver;
	
	
	@Given("user will log in crm website")  
	public void user_will_log_in_crm_website() throws InterruptedException{
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

	@Then("user will click companies") 
	public void user_will_click_companies() throws InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[@href='/companies']")).click();
		Thread.sleep(2000);
	}

	@Then("user will click new") 
	public void user_will_click_new() throws InterruptedException{
		driver.findElement(By.xpath("//button[contains(.,'New')]")).click();
		Thread.sleep(2000);
	}

	@Then("user will enter the data") 
	public void user_will_enter_the_data() throws SQLException, InterruptedException{
		
		//connection to data base
	       Connection dbcon=null;
	       Statement stmt=null;

	        //Database credentials 
			String url="jdbc:mysql://localhost:3306/mobile";
			String username="root";
			String password="root";
			
			
			try {
				//Registering driver class
				Class.forName("com.mysql.jdbc.Driver");
				//creating connection
				dbcon=(Connection) DriverManager.getConnection(url,username,password);	
				System.out.println("Connection Check1");
			}
			catch(Exception e){
				System.out.println(e);
			}
		
	        //preparing query statement.
			String query="SELECT * FROM mobiledata";
			
			stmt=(Statement) dbcon.createStatement();
			
			ResultSet executeQuery = stmt.executeQuery(query);
			
			
			//Extract data from result set
			while(executeQuery.next()) {
			
				
				driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys(executeQuery.getString(1));
				Thread.sleep(1000);
				driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(executeQuery.getFloat(2)+","+executeQuery.getInt(3)+","+executeQuery.getInt(4));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(@class,'ui linkedin button')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@href='/companies']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(.,'New')]")).click();
				Thread.sleep(2000);
				
			}
			System.out.println("Connection Check2");
			
		System.out.println("All Data Entered");
	      }
		
	    
	

	@And("user will finally see the data") 
	public void user_will_finally_see_the_data(){
	   System.out.println("Data Entered");
	    
	}

}
