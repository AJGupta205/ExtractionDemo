package Extract01;


import org.openqa.selenium.By;  
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import junit.framework.Assert;
import utility01.*;
public class TC01 {

	static String release_date_wiki = "";
	static String release_date_imdb = "";
	static String release_country_wiki = "";
	static String release_country_imbd = "";
	
	@Test(priority = 0)
	
	public static void ExtractWIKI() {
		
		DriverUT.Setup("chrome","https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		
		//Release Date
		release_date_wiki = DriverUT.driver.findElement(By.xpath("//*[text()='17 December 2021']")).getText();
		
		//Release Country
		release_country_wiki = DriverUT.driver.findElement(By.xpath("//th[text()='Language']//preceding::td[1]")).getText();
		
		System.out.println(release_date_wiki + " on WIKI ");
		System.out.println(release_country_wiki + " on WIKI ");
		
	}

 
	@Test(priority = 1)
   public static void ExtractIMDB() {
		
		DriverUT.Setup("chrome","https://www.imdb.com/title/tt9389998/?ref_=nv_sr_srsg_0");
		
		
			//Release Date
			release_date_imdb = DriverUT.driver.findElement(By.xpath("//*[text()='Country of origin']//preceding::a[2]")).getText();
			
			//Release Country
			release_country_imbd= DriverUT.driver.findElement(By.xpath("//*[text()='Country of origin']//following::a[1]")).getText();
			
			System.out.println(release_date_imdb + " on IMDB");
			System.out.println(release_country_imbd  + " on IMDB");
		
	}
	@Test(priority = 2)
	public static void validation01() {
		
		//For Country validation
		Assert.assertEquals(release_country_wiki, release_country_imbd );
		}
		
	
	@Test(priority = 3)
	public static void validation02() {
		
		//For date Validation
		Assert.assertEquals(release_date_wiki, release_date_imdb );
	}

	
	@AfterMethod()
   public static void EndWith() {
		
		DriverUT.driver.quit();
		
	}
	
}
