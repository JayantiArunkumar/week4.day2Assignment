package week4.day2Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ERailSort {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("https://erail.in/");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
//		Uncheck the check box - sort on date
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
//		clear and type in the source station 
		WebElement e = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		e.clear();
		e.sendKeys("MS",Keys.ENTER);
		
		Thread.sleep(5000);
//		clear and type in the destination station
		WebElement e1 = driver.findElement(By.id("txtStationTo"));
		e1.clear();
		e1.sendKeys("MDU",Keys.ENTER);
		
//		Find all the train names using xpath and store it in a list
		List<WebElement> trainName = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));
		List<String>train=new ArrayList<String>();
		for (WebElement ele : trainName) {
			String text = ele.getText();
			train.add(text);
			System.out.println(text);
			
		}
		
//		Use Java Collections sort to sort it and then print it
		Collections.sort(train);
		System.out.println("Sorted Train:");
		System.out.println(train);
		
		
	}

}
