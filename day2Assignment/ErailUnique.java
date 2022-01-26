package week4.day2Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("https://erail.in/");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Click the 'sort on date' checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
//		clear and type in the from station text field
		WebElement e = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		e.clear();
		e.sendKeys("MS",Keys.ENTER);
		
//		clear and type in the to station text field
		WebElement e1 = driver.findElement(By.id("txtStationTo"));
		e1.clear();
		e1.sendKeys("MDU",Keys.ENTER);
		
//		Add a java sleep for 2 seconds
		Thread.sleep(2000);
		
//		Store all the train names in a list
		
		List<WebElement> trainName = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));
		List<String>train=new ArrayList<String>();
		for (WebElement ele : trainName) {
			String text = ele.getText();
			train.add(text);
			System.out.println(text);
			
		}
//		Get the size of it
		int size = train.size();
		System.out.println("No of Trains: "+size);
		
//		Add the list into a new Set
		Set<String>uniqueTrain=new LinkedHashSet<String>(train);
		
//		And print the size of it
		int size2 = uniqueTrain.size();
		System.out.println("No of unique Trains: "+size2);

	}

}
