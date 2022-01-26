package week4.day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Appear {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("http://www.leafground.com/pages/appear.html");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement ele1 = driver.findElement(By.xpath("//button[@id='btn']"));
		
		wait.until(ExpectedConditions.visibilityOf(ele1));
		String text = driver.findElement(By.xpath("//button[@id='btn']/b")).getText();
		System.out.println(text);
		
		
		
		
		
	}

}
