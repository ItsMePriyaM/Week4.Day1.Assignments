package week4.day1.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.get("http://www.leafground.com/pages/sorttable.html");

//Check if the sorting functionality working in the table for name
//Step 1: Collect the names 
List<WebElement> names1 = driver.findElements(By.xpath("//table[@id='table_id']/tbody/tr/td[2]"));
List<String> li1=new ArrayList<String>();
//add the names into the list
for(WebElement e:names1)
{
	String unsortedname=e.getText();
	li1.add(unsortedname);
}
//Sort the list
//Collections.sort(li1);
System.out.println(li1);
//Click the name 
driver.findElement(By.xpath("//table[@id='table_id']//th[2]")).click();
//Collect the names 
List<WebElement> names2 = driver.findElements(By.xpath("//table[@id='table_id']/tbody/tr/td[2]"));
List<String> li2=new ArrayList<String>();
//Add the names to another list
for(WebElement n2:names2)
{
	String sortedname=n2.getText();
	li2.add(sortedname);
}
System.out.println(li2);
File source = driver.getScreenshotAs(OutputType.FILE);
File dest=new File("./src/main/resources/snaps/Img001.jpg");
FileUtils.copyFile(source, dest);
//Compare both list
if(li1.equals(li2)==true)
{
	System.out.println("The Sort functionality in Name is working ");
}
else
{
	System.out.println("The Sort functionality in name is not working");
}

	}
}
