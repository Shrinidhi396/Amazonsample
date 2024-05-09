package org.pack;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazonpage extends BaseClass{
	 
	public Amazonpage() {
		PageFactory.initElements(driver, this);	
	}
	@FindBy(id="twotabsearchtextbox")
	public WebElement Search;
	public WebElement getSearch() {
		return Search;
	}
	@FindBy(id="nav-search-submit-button")
	public WebElement button;
	public WebElement getbutton() {
		return button;
	}
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	public WebElement IPhoneName;
	public WebElement getIphoneName() {
		return IPhoneName;
	}
	@FindBy(xpath="nav-search-submit-button")
	public WebElement Nextpage;
	public WebElement getNextpage() {
		return Nextpage;
	}
	
	
	

}
