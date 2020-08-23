package Flipkart;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class FlipkartTest {

	public static void main(String[] args) throws InterruptedException, IOException, SQLException, Exception {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.gecko.driver","C:\\Users\\manish.mathur\\EllipsePhoton\\SeleniumFramework\\drivers\\geckodriver\\geckodriver.exe" );
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://flipkart.com/");
		
		Actions actions = new Actions(driver);
		
		org.openqa.selenium.interactions.Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		
		sendEsc.perform();
		
		driver.findElement(By.className("_3Ep39l")).click();  //Login Button
		driver.findElement(By.xpath("//input[contains(@class,'_2zrpKA _1dBPDZ')]")).sendKeys("Your Email");
		      driver.findElement(By.xpath(" //input[@class='_2zrpKA _3v41xv _1dBPDZ']")).sendKeys("Password");
		Thread.sleep(2000);
		driver.findElement( By.xpath("//button[contains(@class,'_2AkmmA _1LctnI _7UHT_c')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath( "//span[contains(.,'Electronics')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath( "//a[@title='Asus']")).click();
		Thread.sleep(2000);
		 
		
		StringBuilder total_mobile_data = new StringBuilder();
		
		for(int i=0;i<9;i++)
		{
			String xprow="//*[@class='col col-7-12']/div";
			Thread.sleep(2000);
			 List<WebElement>listTotal =  driver.findElements(By.xpath(xprow));
			
			for (WebElement result:listTotal) {
            //System.out.println(result.getText()); 
             total_mobile_data.append(result.getText());
             total_mobile_data.append("   ");
            }
		
			Thread.sleep(2000);
		if(i<8)
		 {
		 Thread.sleep(1000);
	     driver.findElement(By.xpath("//a[@class='_3fVaIS']//span[contains(text(),'Next')]")).click();
		 }
		}
		System.out.println(total_mobile_data);
		 
		ArrayList<String> regrexlist = new ArrayList<String>();
		
		regrexlist.add("(Asus[A-Za-z0-9.,()_/ ]*)\\)?)"); 
		regrexlist.add("\\s{3}(\\d(.\\d)?)\\d");
		regrexlist.add("\\s{3}\\d(.\\d)?((\\d{0,2},)?(\\d{0,2},)?\\d{0,3})\\sRatings");
		regrexlist.add("(\\d*\\,?\\d*\\s)Reviews");
		
		
	
		
		
		String datainstring= total_mobile_data.toString();
		ArrayList<String> datarray=new ArrayList<String>();
		datarray.add(datainstring);
		
	
  		  
	    Pattern pattern = Pattern.compile("(Asus[A-Za-z0-9.,()_/ ]*)\\)?\\s{3}(\\d\\.\\d|\\d)(.*)\\sRatings\\s&\\s(.*)\\sReviews");
		Matcher matcher = pattern.matcher(datainstring);
		
		List<FlipkartPojo> pojolist=new ArrayList<FlipkartPojo>();
		
		while(matcher.find())
		{
			FlipkartPojo p = new FlipkartPojo();
			p.setModelName(matcher.group(1));
			p.setRating(Float.parseFloat(matcher.group(2).replaceAll("\\s","")));
			p.setRatingCount(Integer.parseInt(matcher.group(3).replaceAll(",","")));
			p.setReviewsCount(Integer.parseInt(matcher.group(4).replaceAll(",","")));
			
			
			pojolist.add(p);
		}
		
		
		//connection to data base
	       Connection dbcon=null;
	       PreparedStatement pstmt=null;

	        //Database credentials 
			String url="jdbc:mysql://localhost:3306/mobile";
			String username="root";
			String password="root";
			
			
			try {
				//Registering driver class
				Class.forName("com.mysql.jdbc.Driver");
				//creating connection
				dbcon=(Connection) DriverManager.getConnection(url,username,password);	
				
			}
			catch(Exception e){
				System.out.println(e);
			}
		
		//loading data to database.
		int affected = 0;
		
		Iterator i=pojolist.iterator();
		
		while(i.hasNext()) {
			
			FlipkartPojo pojo=(FlipkartPojo)i.next();
			
			//preparing query statement.
			String query="INSERT INTO mobiledata(`modelName`,`rating`,`reviewsCount`,`ratingCount`) VALUES(?,?,?,?)";
			pstmt=(PreparedStatement) dbcon.prepareStatement(query);
			//getting data using pojo getter.
			 pstmt.setString(1, pojo.getModelName());
			 pstmt.setFloat(2,pojo.getRating());
			 pstmt.setInt(3,pojo.getRatingCount());
			 pstmt.setInt(4, pojo.getReviewsCount());
			 
			 affected=pstmt.executeUpdate();
			 
	      }
		
	   

	

	}

	private static int replaceAll(String string, String string2) {
		// TODO Auto-generated method stub
		return 0;
	}}
