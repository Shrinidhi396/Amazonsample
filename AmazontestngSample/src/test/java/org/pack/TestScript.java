package org.pack;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestScript extends BaseClass{
	
      static BaseClass b = new BaseClass();
      Amazonpage a = new Amazonpage();
      
      @Test(priority = 1)
      
      public static void BrowserType() {
    	  try {
    			b.getDriver(b.readExcell(1, 1));
    			
    			//Report - browser launched successfully
    			System.out.println("browser launched successfully");
			
		} catch (Exception e) {
			
			//Report - browser not launched successfully
			System.out.println("browser not launched successfully");
		}
      }
      @Test(priority=2)
      
      public void UrlLaunch() {
    	  try {
    			
				b.getUrl(b.readExcell(1, 0));
				b.winMax();
				
				//Report - Url launched successfully
				System.out.println("Url launched successfully");
			
		} catch (Exception e) {
			//Report - Url not Launched Successfully
			System.out.println("Url not Launched Successfully");
		}
      }
      @Test(priority=3)
      public void SearchPage() {
    	  try {
    		  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone15 pro max");
    		  driver.findElement(By.id("nav-search-submit-button")).click();
    		  //Report - search launched successfully
    		  System.out.println("search launched successfully");
			
		} catch (Exception e) {
			//Report - search not launched successfully
			System.out.println("search not launched successfully");
		}
      }
//      @Test(priority=4)
//      public void IphonePage() {
//    	  try {
//		 
//		
//    		  List<WebElement> Ratings = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
//    		  List<WebElement> IPhone = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
//			   for ( int i = 0;i< IPhone.size();i++) {
//				   String heading = IPhone.get(i).getText();
//				   String Rates = Ratings.get(i).getText();
//				   System.out.println("headings:"+heading+" "+"Rate:"+Rates);
//				 
//			   
//	        		}
//			} catch (Exception e) {
//				
//			}}
    	  @Test(priority=5)
    	  public void Nextpages() {
    		  try {
    			  int totalPagesToNavigate=10;
    			  for(int i=0;i< totalPagesToNavigate; i++ ) {
    	 List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
    	 List<WebElement> phoneNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
    			  
    			for(int j=0;j<phoneNames.size(); j++) {
    				String phoneName=phoneNames.get(j).getText();
    				String price=prices.get(j).getText();
    				System.out.println("phone Name:"+ phoneName + ",price: "+ price);
    			}
    			WebElement nextbutton = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
    			nextbutton.click();
    			Thread.sleep(2000);
	        		}  
    			  
			} catch (Exception e) {
				System.out.println("nextbutton launched successfully");
			}
			}
    		  }
      
      //span[@class='a-size-medium a-color-base a-text-normal']
        		 
        		 
        		 
        		 
        		 
        		 
        		 
        		 
        		 
        		 
		  
			   
      
      
