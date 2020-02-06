package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObj {
	
	
	
	
	WebDriver driver;
	
	public HomePageObj(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath="//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")
	public	WebElement sour;

	@FindBy(xpath="//td[@class='mapbg']//div[@class='search_options_menucontent']//ul//descendant::a[@href='#']")

	
	public  List<WebElement>  Sourele;
	
	
	@FindBy(xpath="//div[@id='ui-datepicker-div']/div/div//div/span")
	public WebElement month;
	

	@FindBy(xpath="//*[@id='dropdownGroup1']//ul//descendant::a[@href='#']")
	public List <WebElement> destination;
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-e']")
	public WebElement monthnxt ;
	
	@FindBy(xpath="//div[@id='divpaxinfo']")
	public WebElement passenger;
	
@FindBy(xpath="//a[@class='ui-state-default']")
public  List <WebElement> date;
	
	@FindBy(id=("ctl00_mainContent_ddl_Adult"))
	public WebElement selectdrp;
	
	public WebElement Sour() {
		return sour;
	}
	
	public List<WebElement> Sourele() {
		return Sourele;
	}
	
	
	public List<WebElement> destination(){
		return destination;
	}
	
	public WebElement Month() {
		return month;
		
	}
public WebElement MonthNxt()
{
	return monthnxt;
}


public  List <WebElement> Date(){
	return date;
}

public WebElement Passgenger()
{
	return passenger;
}

}