package week4.day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("https://jqueryui.com/resizable");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder=new Actions(driver);
		driver.switchTo().frame(0);
		//WebElement ele = driver.findElement(By.xpath("//div[@id='resizable']"));
		WebElement ele1 = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
		builder.dragAndDropBy(ele1, 100,200).perform();
		
		
		
	}

}
