package week4.day2Assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("http://www.leafground.com/pages/TextChange.html");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement ele = driver.findElement(By.id("btn"));
		wait.until(ExpectedConditions.textToBePresentInElement(ele, "Click ME!"));
		String text = ele.getText();
		ele.click();
		Alert alert=driver.switchTo().alert();
		String text1=alert.getText();
		alert.accept();
		
		if(text.equals(text1))
			System.out.println("Verified clickMe! text appears");
		else
			System.out.println("Unverified");

	}

}
