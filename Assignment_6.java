package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_6 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		String FP = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Mobile Price : "+FP);
		FP = FP.replaceAll("[^a-zA-Z0-9]", "");
		
		String Rating = driver.findElement(By.xpath("(//a//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("No of People Ratings : "+Rating);
		
		driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star-small a-star-small-3-5')])[1]")).click();
		String star_rate = driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base a-text-beside-button')]")).getText();
		System.out.println("Global Rating : "+star_rate);
		
		driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base a-text-normal')])[1]")).click();
		
		Set <String> WH = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(WH);
		driver.switchTo().window(lst.get(1));
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest =new File("./snap/frame.png");
		FileUtils.copyFile(source, dest);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(8000);
		String grandTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText().replaceAll("[^0-9]", "").substring(0, 5);
		
		if(FP.contains(grandTotal)) {
			System.out.println("Finally Same Price : "+grandTotal);
		}
		else {
			System.out.println("Not Same Price");
		}	
		
	}

}
