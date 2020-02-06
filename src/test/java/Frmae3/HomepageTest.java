package Frmae3;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.HomePageObj;

import resource.DriverBaseClass;

public class HomepageTest extends DriverBaseClass {
	HomePageObj sour;
	public static Logger log = LogManager.getLogger(DriverBaseClass.class.getName());

	@BeforeTest
	public void IniliDriver() throws IOException {
		driver = initriver();
		log.info("driver initializ");
	}

	@Test(priority = 1)
	public void Source() throws IOException {

		sour = new HomePageObj(driver);

		sour.Sour().click();
		int all = sour.Sourele().size();
		System.out.println(all);

		for (int i = 1; i <= all; i++) {

			if (sour.Sourele.get(i).getText().contains(pro.getProperty("Source"))) {
				sour.Sourele().get(i).click();
				Assert.assertEquals(sour.Sourele.get(i).getText(), pro.getProperty("Source"));
			}

		}

	}

	@Test(priority = 2)
	public void Destination() {
		sour = new HomePageObj(driver);

		int alldes = sour.destination().size();
		System.out.println(alldes);
		for (int j = 1; j < alldes; j++) {

			if (sour.destination().get(j).getText().contains(pro.getProperty("Desti"))) {
				sour.destination().get(j).click();

			}
		}
	}

	@Test(priority = 3)
	public void MonthYear() throws InterruptedException {
		
		int m=1;
		while(!sour.Month().getText().contains("November 2020"))
		{
			m++;
			sour.monthnxt.click();
			String mon=driver.findElement(By.cssSelector("div[class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText();
			//System.out.println(mon);
			if(m>9) 
			{
				break;
				}
		
		}
		Thread.sleep(2000);
	
		int alldate=sour.Date().size();
		
	   for(int d=0; d<alldate; d++)
	   {
		   
		   System.out.println(sour.Date().get(d).getText());
		   if(sour.Date().get(d).getText().contains(pro.getProperty("Date"))){
			   sour.Date().get(d).click();
			   
		   }
	      
	   
	   }
	
	}
		
@Test(priority = 4)
public void Passgenger()
{
      sour.Passgenger().click();
      
      Select  sel= new Select(sour.selectdrp);
     
      sour.selectdrp.click();
      
}
		
		
		
	
	
	@AfterTest(enabled=false)
	public void teardown() {

		driver.close();

		driver = null;

	}
}
