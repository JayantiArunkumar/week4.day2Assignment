package week4.day2Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		ChromeDriver driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get(" https://www.amazon.in/");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder=new Actions(driver);
		
		//2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//3.Get the price of the first product
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		 System.out.println("The price is: "+price);
		
		//4. Print the number of customer ratings for the first displayed product
		 String cR = driver.findElement(By.xpath("//span[@class='a-size-base']")).getText();
		 System.out.println(cR);
		 
		 Thread.sleep(5000);
		//5. Mouse Hover on the stars
		 WebElement rating = driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom']"));
		 builder.moveToElement(rating);
		 
		//6. Get the percentage of ratings for the 5 star.
		 
		 String custRating = driver.findElement(By.xpath("//span[@class='a-icon-alt']")).getText();
		 System.out.println(custRating);
		//7. Click the first text link of the first image
		 
		 driver.findElement(By.xpath("//a[@class='a-link-normal s-link-style a-text-normal']")).click();
		 Set<String> ww = driver.getWindowHandles();
		 List<String>w1=new ArrayList<String>(ww);
		 String t = w1.get(1);
		 driver.switchTo().window(t);
		 
		//8. Take a screen shot of the product displayed
		 
		 File source = driver.getScreenshotAs(OutputType.FILE);
			File destination=new File("./images/Phone.png");
			FileUtils.copyFile(source, destination);
		//9. Click 'Add to Cart' button
			driver.findElement(By.id("add-to-cart-button")).click();
		//10. Get the cart subtotal and verify if it is correct.
			String cartTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
			System.out.println("Cart subTotal"+cartTotal);
			
			if(price.contains(cartTotal))
				System.out.println("The total is verified");
			else
				System.out.println("The total is incorrect");
			
		

	}

}
