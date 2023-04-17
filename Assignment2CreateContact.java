package week2.Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2CreateContact {

	public static void main(String[] args) throws InterruptedException {

		
		 ChromeDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("http://leaftaps.com/opentaps/control/main");
			driver.findElement(By.id("username")).sendKeys("DemoCsr");
			WebElement webpass=driver.findElement(By.id("password"));
			webpass.sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.linkText("Create Contact")).click();
			driver.findElement(By.id("firstNameField")).sendKeys("Venkatesh");
			driver.findElement(By.id("lastNameField")).sendKeys("S");
			driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Venkatesh");
			driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("S");
			driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Testing");
			driver.findElement(By.id("createContactForm_description")).sendKeys("Selenium UI Automation Testing");
			driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("svenkats30@gmail.com");
			Select opt=new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
			opt.selectByVisibleText("New York");
			driver.findElement(By.name("submitButton")).click();
			driver.findElement(By.linkText("Edit")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("updateContactForm_description")).clear();
			Thread.sleep(5000);
			driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Testing Purpose");
			driver.findElement(By.xpath("//input[@name='submitButton']")).click();
			String title=driver.getTitle();
			System.out.println("Title of webpage: "+title);
				
			}

}
