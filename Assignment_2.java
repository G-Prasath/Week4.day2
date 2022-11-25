package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_2 {

	public static void main(String[] args) {
		/*
		 * 1. Launch the URL https://html.com/tags/table/ 
		 * 2. Get the count of number of rows 
		 * 3. Get the count of number of columns
		 */
		
		WebDriverManager.chromedriver().setup();  
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("https://html.com/tags/table/"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> Row1 = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
		System.out.println("Table Count of Rows : "+Row1.size());
		List<WebElement> Col1 = driver.findElements(By.xpath("//table[@class='attributes-list']//tr//th"));
		System.out.println("Table Count of column : "+Col1.size());

	}

}
