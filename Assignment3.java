package week2.Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		1. Type your name
//		2. Append Country to this City
//		3. Verify if text box is disabled
//		4. Clear the typed text
//		5. Retrieve the typed text
//		6. Type email and Tab. Confirm control moved to next element
//		7. Type about yourself
//		8. Text Editor
//		9. Just Press Enter and confirm error message*
//		10. Click and Confirm Label Position Changes
//		11. Type your name and choose the third option
//		12. Click and Confirm Keyboard appears
//		13. Custom Toolbar
		
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/input.xhtml");
		
		WebElement name=driver.findElement(By.xpath("//input[@placeholder='Babu Manickam']"));
		name.clear();
		name.sendKeys("Venkatesh");
		
		WebElement appendCountry=driver.findElement(By.xpath("//input[@value='Chennai']"));
		appendCountry.clear();
		appendCountry.sendKeys("INDIA");
		
		boolean disable=driver.findElement(By.xpath("//input[@placeholder='Disabled']")).isEnabled();
		if(disable)
		{
			System.out.println("TextBox is Enabled");
		}
		else
		{
			System.out.println("TextBox is Disabled");
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Can you clear me, please?']")).clear();
		
		WebElement Retrieve=driver.findElement(By.xpath("//input[@value='My learning is superb so far.']"));
		String strRetrieve=Retrieve.getAttribute("value");
		System.out.println("Retrieved Text in TexBox"+strRetrieve);
		
		WebElement email=driver.findElement(By.xpath("//input[@placeholder='Your email and tab']"));
		email.clear();
		email.sendKeys("svenkats30@gmail.com");
		email.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		WebElement tabDisplay=driver.findElement(By.xpath("//textarea[@placeholder='About yourself']"));
		boolean tabDisplay1=tabDisplay.isDisplayed();
		if(tabDisplay1)
		{
			System.out.println("Control Moved to the Next Element in the DOM");
		}
		else
		{
			System.out.println("Control is not Moved to the Next Element in the DOM");
		}
		tabDisplay.sendKeys("I'm Venkatesh, Learning Selenium UI Automation Framework");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@data-gramm='false']/p")).sendKeys("Hi Team, This is Paragraph Tag.");
		
		driver.findElement(By.xpath("//input[@name='j_idt106:thisform:age']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		boolean errormsg=driver.findElement(By.xpath("//div[@class='col-12 mb-2 lg:col-4']")).isDisplayed();
		if(errormsg)
		{
		System.out.println("Error Message is Displayed");
		}
		else
		{
			System.out.println("Error Message is not Displayed");
		}
		Thread.sleep(2000);
		driver.navigate().back();
		WebElement labelPos=driver.findElement(By.xpath("//input[@name='j_idt106:float-input']"));
		labelPos.click();
		String strlabelPos=labelPos.getText();
		if(strlabelPos.isEmpty())
		{
			System.out.println("Label Position is Changed");
		}
		else
		{
			System.out.println("Label Position is Not Changed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Venkatesh");
		driver.findElement(By.xpath("//button[@aria-label='Show Options']")).click();
		Thread.sleep(2000);
		Select opt=new Select(driver.findElement(By.xpath("//select[@class='ui-helper-hidden-accessible']")));
		opt.selectByIndex(3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='j_idt106:j_idt122']")).click();
		boolean keyboard=driver.findElement(By.xpath("//div[@class='ui-widget ui-widget-content ui-corner-all ui-shadow keypad-popup ui-input-overlay']")).isDisplayed();
		if(keyboard)
		{
			System.out.println("Keyboard is Displayed");
			
		}
		else
		{
			System.out.println("Keyboard not Displayed");
		}
		Thread.sleep(2000);
		driver.close();
				
	}

}
