package week2.Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) {
		 //Click on Create New Account button
		// Step 7: Enter the first name
		// Step 8: Enter the last name
		// Step 9: Enter the mobile number
		// Step 10: Enterthe password
		// Step 11: Handle all the three drop downs
		// Step 12: Select the radio button "Female" 
		
		 ChromeDriver driver=new ChromeDriver();
			
				
			driver.get(" https://en-gb.facebook.com/");
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.linkText("Create new account")).click();
			driver.findElement(By.name("firstname")).sendKeys("Venkatesh");
			driver.findElement(By.name("lastname")).sendKeys("S");
			driver.findElement(By.name("reg_email__")).sendKeys("7397455283");
			driver.findElement(By.id("password_step_input")).sendKeys("Mine_test30");
			Select opt=new Select(driver.findElement(By.id("day")));
			opt.selectByVisibleText("12");
			Select opt1=new Select(driver.findElement(By.id("month")));
			opt1.selectByVisibleText("Oct");
			Select opt2=new Select(driver.findElement(By.id("year")));
			opt2.selectByVisibleText("1992");
			driver.findElement(By.xpath("(//label[text()='Female']/following::input)[2]")).click();
			driver.findElement(By.name("websubmit")).click();
			
			
			
			
					
			
	}

}
