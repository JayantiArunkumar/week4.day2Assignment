package week4.day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("https://jqueryui.com/sortable");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder=new Actions(driver);
		
		driver.switchTo().frame(0);
		/*WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		//WebElement item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));*/
		WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']//li[1]"));
		WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']//li[2]"));
		WebElement item3 = driver.findElement(By.xpath("//ul[@id='sortable']//li[3]"));
		WebElement item4 = driver.findElement(By.xpath("//ul[@id='sortable']//li[4]"));
		WebElement item5 = driver.findElement(By.xpath("//ul[@id='sortable']//li[5]"));
		WebElement item6 = driver.findElement(By.xpath("//ul[@id='sortable']//li[6]"));
		WebElement item7 = driver.findElement(By.xpath("//ul[@id='sortable']//li[7]"));
		
		builder.dragAndDrop(item7, item1).dragAndDrop(item6, item1).dragAndDrop(item5, item1).dragAndDrop(item4, item1).dragAndDrop(item3, item1).dragAndDrop(item2, item1).perform();
		
		//builder.clickAndHold(item1).moveToElement(item5).release().perform();
		//driver.close();
		
	}

}
