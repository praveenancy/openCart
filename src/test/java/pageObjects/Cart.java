package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Cart extends BasePage{
	
	public Cart(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//*[@class = 'accordion-toggle'])[2]") WebElement estimate;
	@FindBy(xpath="//*[@id=\"input-country\"]//option") List<WebElement> countrys;
	@FindBy(xpath="//*[@id='input-zone']") WebElement eState;
	@FindBy(id = "input-postcode") WebElement code;
	@FindBy(xpath="//*[text()='Get Quotes']") WebElement quoteButton;
	
	
	public void tapOnEstimates()
	{
		estimate.click();
	}
	
	public  void selectCountry(String country) 
	{
		
		for(WebElement e:countrys)
		{
			if(e.getText().contains(country))
			{
				e.click();
			}
			
		}
		
	}
	
	public void selectState(String state)
	{
		Select select = new Select(eState);
		select.selectByContainsVisibleText(state);
	}
	
	public void setPostCode(String pinCode)
	{
		
		code.sendKeys(pinCode);
	}
	
	public void tapOnGetQuotes()
	{
		quoteButton.click();
	}
	

}
