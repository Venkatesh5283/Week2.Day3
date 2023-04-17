package week2.Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2DeleteLead {

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
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.xpath("(//em[@class='x-tab-left'])[2]")).click();
			driver.findElement(By.name("phoneNumber")).sendKeys("7397455283");
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			WebElement leadID=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)"));
			//(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)
			//WebElement leadID=driver.findElement(By.linkText("//a[text='linktext']"));
			String str=leadID.getText();
			//leadID.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Delete")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.name("//label[text()='Lead ID:']/following::input")).sendKeys(str);
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();					
		
						
			String Norecords= driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
			
			if(Norecords.contains("No records"))
			{
				System.out.println("The message shown is\n"+Norecords+"\nThe file has been deleted successfully");
			}
			
			Thread.sleep(5000);
			driver.close();
	}

}
