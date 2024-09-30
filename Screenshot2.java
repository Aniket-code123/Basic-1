package cnow;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot2 {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://admin.staging.culturenow.org/peoples");  //for opening the sandbox cms
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();  //clicking on the send button
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='name@address.com']")).sendKeys("admin@culturenow.org"); //clicking on the username & entering the user name
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilename);
		
		
		File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot, new File(".//screenshot" +screenshotfilename + ".png"));
		
		
		

	}

}
