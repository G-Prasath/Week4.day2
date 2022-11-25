package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_5 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions hover = new Actions(driver);
		hover.moveToElement(brand).perform();
		
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("(//a[contains(@href,'/brands/loreal-paris/c/')])[1]")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),' Colour Protect Shampoo')]")).click();
		Set <String> WH = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(WH);
		driver.switchTo().window(lst.get(1));
		
		WebElement select = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select se = new Select(select);
		se.selectByIndex(1);
		
		String price = driver.findElement(By.xpath("(//span[text()='₹170'])[1]")).getText();
		System.out.println("Price : "+price);
		
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		
		
		driver.switchTo().frame(0);
			String grand_price = driver.findElement(By.xpath("(//span[@color='#001325'])[2]")).getText();
			System.out.println("Grand Price : "+grand_price);
			driver.findElement(By.xpath("//span[text()='Proceed']")).click();
			driver.switchTo().defaultContent();
			
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		driver.findElement(By.xpath("(//img[@alt='Image'])[7]")).click();
		
		String final_chk = driver.findElement(By.xpath("(//p[@color='rgba(0,19,37,0.64)'])[3]")).getText();
		
		if(grand_price.contains(final_chk)) {
			System.out.println("Same Price : "+final_chk);
		}
		else{
			System.out.println("Not same");
		}
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
	}

}
