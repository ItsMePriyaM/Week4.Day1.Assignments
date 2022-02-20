package week4.day1.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("http://www.leafground.com/pages/disapper.html");

WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
WebElement invisbutton = driver.findElement(By.id("btn"));
wait.until(ExpectedConditions.invisibilityOf(invisbutton));
String disappeartext = driver.findElement(By.xpath("//div[@id='show']//following::strong")).getText();
if(disappeartext.equals("I know you can do it! Button is disappeared!"))
{
	System.out.println("The Element disappeared and text is displayed as expected");
}
else
{
	System.out.println("The button is yet to disappear and text is yet to appear ");
}

driver.navigate().to("http://www.leafground.com/pages/appear.html");

WebElement newbutton = driver.findElement(By.xpath("//button[@id='btn']/b"));
wait.until(ExpectedConditions.visibilityOf(newbutton));
System.out.println("The reappeared button is : "+newbutton.getText());

driver.navigate().to("http://www.leafground.com/pages/TextChange.html");
wait.until(ExpectedConditions.textToBe(By.id("btn"), "Click ME!"));
driver.findElement(By.xpath("//button[text()='Click ME!']")).click();
Alert alert = driver.switchTo().alert();
if(alert.getText().equals("Click ME!")) {
	System.out.println("Click ME! is visible");
}
alert.accept();
driver.close();
	}

}
