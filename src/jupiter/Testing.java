package jupiter;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.bouncycastle.crypto.modes.gcm.Tables8kGCMMultiplier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing {
	WebDriver driver = new ChromeDriver();
String WEB1="https://jupiter.cloud.planittesting.com/#/shop";
String webbRemove="https://jupiter.cloud.planittesting.com/#/cart";
	@BeforeTest
	public void sutup() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	@Test()
	public void AddAllItem() {
		driver.get(WEB1);
		WebElement ItemContenar= driver.findElement(By.className("ng-scope"));
		List<WebElement>allItem=driver.findElements(By.tagName("li"));
		for(int i=0;i<allItem.size();i++)
		{ WebElement addBatoun=driver.findElement(By.className("btn-success"));
			addBatoun.click();
			
			
		}
	}
	@Test(enabled = false)
	public void AddHighrAMOUNT() throws InterruptedException
	{double highestPrice = 0;
    WebElement highestPricedProduct = null;
		driver.get(WEB1);
		WebElement ItemContenar= driver.findElement(By.className("ng-scope"));
		List<WebElement>allItem=driver.findElements(By.tagName("li"));
		
		for(int i=0;i<allItem.size();i++)
		{String Price=driver.findElement(By.className("ng-binding")).getText().replace("$", "");;
		String PriceText=Price;
            double price = Double.parseDouble(PriceText);			
            if (price >= highestPrice) {
                highestPrice = price;
         highestPricedProduct =allItem.get(i);
           WebElement addBatoun=driver.findElement(By.className("btn-success"));
			addBatoun.click();
            System.out.println("Added the product with the highest price: $" + highestPrice);
}
		}
		
		
}	
@Test(enabled = false)
public 	void AddSecoundRwo() {
	driver.get(WEB1);
	WebElement ItemContenar= driver.findElement(By.className("ng-scope"));
	List<WebElement>allItem=driver.findElements(By.tagName("li")).subList(4, 8);

	for(int i=0;i<allItem.size();i++)
	{  
		WebElement addBatoun=driver.findElement(By.className("btn-success"));
		addBatoun.click();}
}
	
@Test(enabled = false)
public void removefirstandthirditem() throws InterruptedException
{driver.get(webbRemove);
Thread.sleep(3000);
List<WebElement>allItem=driver.findElements(By.cssSelector("div[class='ng-scope']"));
for(int i=0;i<allItem.size();i++)
{  
	WebElement remove1=driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(5)"));
	remove1.click();
	WebElement cnform=driver.findElement(By.cssSelector(".btn.btn-cancel.btn-danger"));
	cnform.click();
	WebElement remove2=driver.findElement(By.cssSelector("tbody tr:nth-child(3) td:nth-child(5)"));
	remove2.click();
	

}
}

	



	@AfterTest
	public void endtest()
	{}
}
