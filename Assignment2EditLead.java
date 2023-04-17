package week2.Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
*/
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElement(By.id("username")).sendKeys("DemoCsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Venkatesh");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		String title=driver.getTitle();
		
		if(title.contains("View Lead | opentaps CRM"))
		{
		System.out.println(title+" Title is Verified and it was correct");
		}
		else
		{
			System.out.println(title+" Title is Verified and it was not Correct ");
		}
		driver.findElement(By.linkText("Edit")).click();
		WebElement update=driver.findElement(By.id("updateLeadForm_companyName"));
		//String OldCompanyName=update.getText();
		update.clear();
		String NewCompanyName="EY";
		update.sendKeys(NewCompanyName);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Venkatesh");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String updated=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-companyName']/a")).getText();
		if(NewCompanyName.equals(updated))
		{
		System.out.println("New Company Name "+updated+" Updated Successfully ");
		}
		else
		{
			System.out.println("New Company Name "+updated+" was not Updated Successfully ");
		}
		Thread.sleep(3000);
		driver.close();
		
	}

}
