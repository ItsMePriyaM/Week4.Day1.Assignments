package week4.day1.Assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("http://www.leafground.com/pages/table.html");
//Get the count of the number of columns 
List<WebElement> columns = driver.findElements(By.tagName("th"));
System.out.println("The number of columns available is "+columns.size());
//Get the count of the rows
List<WebElement> rows = driver.findElements(By.tagName("tr"));
System.out.println("The Number of rows is : "+rows.size());

// Get the Progress of Learn to interact with Elements 
String progress = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]")).getText();
System.out.println("The Progress learn to interact with Elements is :" +progress);

//Click the vital task for the least progress
//Step 1 Collect all the Percentage
List<WebElement> allPercentage = driver.findElements(By.xpath("//td[2]"));
List<Integer> li=new ArrayList<Integer>();

//To Find the Lowest Progress
for(WebElement e:allPercentage)
{
	String vals=e.getText();
	Integer valInt=Integer.parseInt(vals.replace("%", ""));
	
	li.add(valInt);
}
int minval=0;
for(int i=0;i<li.size();i++)
{
	for(int j=1;j<li.size();j++)
	{
		if(li.get(i)<li.get(j))
		{
			minval=li.get(i);
		}
	}
}

System.out.println(minval);
//To Click the lowest progress
driver.findElement(By.xpath("//td[contains(text(),'"+minval+"')]/following::input[1]")).click();


	}

}
