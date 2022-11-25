package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Assignment_4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();  
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("https://testleaf.herokuapp.com/pages/table.html"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> row = driver.findElements(By.xpath("//table//tr"));
		System.out.println("No Of Rows : "+row.size());
		
		List<WebElement> col = driver.findElements(By.xpath("//table//tr//th"));
		System.out.println("No Of Colums : "+col.size());
		
		List<WebElement> Ele = driver.findElements(By.xpath("//table//tr[3]//td[2]"));
		System.out.println("Learn to interact with Elements : "+Ele.get(0).getText());
		
		driver.findElement(By.xpath("//table//tr[4]//td[3]//input")).click();
		
		
		
		
		
		
		
		
		
	}

}
