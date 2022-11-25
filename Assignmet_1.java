package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignmet_1 {

	public static void main(String[] args) {
		
		/*
		 * 1. Launch the URL https://www.chittorgarh.com/ 
		 * 2. Click on stock market 
		 * 3.Click on NSE bulk Deals hint-(Table-2) 
		 * 4. Get all the Security names 
		 * 5.Ensure whether there are duplicate Security names
		 */	
		WebDriverManager.chromedriver().setup();  
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("https://www.chittorgarh.com/"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@id='navbtn_stockmarket']")).click();
		driver.findElement(By.tagName("flashcard-close")).click();
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
		
		
		List <WebElement> row = driver.findElements(By.xpath("//table[contains(@class,'table-striped')]//tr"));
		List<String> securityName = new ArrayList<String>();
		
		for(int i=1; i<row.size(); i++) {
			String result = driver.findElement(By.xpath("//table[contains(@class,'table-striped')]//tr["+i+"]//td[3]")).getText();
			securityName.add(result);			
		}
		
		int size = securityName.size();
		
		Set<String> setSecurity = new LinkedHashSet<String>(securityName);
		int setSize = setSecurity.size();
		
		if (size > setSize) {
			System.out.println("Dup is Removed in Security Names");
		}
		else {
			System.out.println("Dup is not removed");
		}
		
	}

}
