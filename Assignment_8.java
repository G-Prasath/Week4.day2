package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_8 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement dragable = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
		Actions build = new Actions(driver);
		System.out.println("Before Dragable Locations : "+dragable.getLocation());
		build.dragAndDropBy(dragable, 100, 50).perform();
		System.out.println("After Drable Locations : "+dragable.getLocation());
		
		WebElement source = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement dest = driver.findElement(By.xpath("//span[text()='Droppable Target']"));
		build.dragAndDrop(source, dest).perform();		
		System.out.println("Dropable Success : "+dest.getText());
	}

}
