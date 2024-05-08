package MiniProject;

import java.util.List;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MobileSearch {
	
	public static void main(String args[]) {
	
	WebDriver driver = null;
	Scanner sc = new Scanner(System.in);
	System.out.println("Choose the browser(Chrome/Firefox) : ");
	String browser = sc.next();
	
	if(browser.equals("Chrome"))
		driver = new ChromeDriver();
	else if(browser.equals("Firefox"))
		driver = new FirefoxDriver();
	else
		System.out.println("Choose correct browser option");
	
	
	//Navigate to the URL "https://www.amazon.in"
	String baseUrl="https://www.amazon.in";
	driver.get(baseUrl);
	
	//Maximize the Window
	driver.manage().window().maximize();
	
	System.out.println("The URL of Web Application is : " + driver.getCurrentUrl());
	System.out.println("The Title of Web Application is : " + driver.getTitle());
	
	
	//Locate the Search textbox and enter the input and click on search button
	WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
	searchTextBox.sendKeys("mobile smartphones under 30000");
	System.out.println("The search text is : "+ searchTextBox.getAttribute("value"));
	
	WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
	searchButton.click();
	
	//Search Result Message
	String searchResult = driver.findElement(By.className("sg-col-inner")).getText();
	System.out.println("The Application displays the follow message : " + searchResult);
	
	
	//Locate the "Sort By" list box and click on it	
	WebElement listBox = driver.findElement(By.className("a-dropdown-label"));
	listBox.click();
	System.out.println("The List Box is "+ listBox.getText());
	
	//Locate the options of Select class of list box
	WebElement sortBy = driver.findElement(By.xpath("//*[@id=\"s-result-sort-select\"]"));
	System.out.println("The options of List Box are : "+ sortBy.getText());
	Select option = new Select(sortBy);
	
	//Find total count of options in list box
	List<WebElement> list = option.getOptions();
	System.out.println("The count of List Box options is "+ list.size());
	
	
	//Locate and select Newest Arrival option
	WebElement opt = driver.findElement(By.id("s-result-sort-select_4"));
	System.out.println("Choose the option : " + opt.getText());
	opt.click();
	
	//Verify that the Newest Arrivals option got selected correctly or not
	if(opt.isEnabled()) {
		System.out.println("The Newest Arrivals option is selected correctly");
	}
	else {
		System.out.println("The Newest Arrivals option not selected correctly");
	}

	driver.quit();
}

}
