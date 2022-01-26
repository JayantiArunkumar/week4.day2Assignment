package week4.day2Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sorttable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("http://www.leafground.com/pages/sorttable.html");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		List<String>name=new ArrayList<String>();
		for (WebElement train : ele) {
			String text = train.getText();
			name.add(text);
			
		}
		System.out.println(name);
		driver.findElement(By.xpath("//table[@id='table_id']//th[2]")).click();
		
		List<WebElement> ele1 = driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		List<String>nameSorted=new ArrayList<String>();
		for (WebElement train1 : ele1) {
			String text1 = train1.getText();
			nameSorted.add(text1);
			
		}
		System.out.println(nameSorted);
		
		
	}

}
