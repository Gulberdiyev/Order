package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[]args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\murat\\Documents\\selenium dependecies\\drivers\\chromedriver.exe"); 
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
				
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
					
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+Keys.ENTER);
		
		//driver.findElement(By.id("ctl00_MainContent_login_button")).click();
				
		driver.findElement(By.linkText("Order")).click();
		
		//Random rand = new Random(); 
		//int  n = rand.nextInt(100) + 1;
		//String quantity = " " + n;
		
		char[] chars = "ABCDEFGHIGKLMNOPQRSTUVWXZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("" +(int) (Math.random()*100));
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("John "+ output + " Smith");

		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Any st");
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Anytown");
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("" +(int) (Math.random()*100));
		
		
		long first15 = (long) (Math.random()*100000000000000L);
		String cardnum = "" ;
		
		int cartype = 1 + (int) (Math.random()*3);
		String type = "";
		
		switch (cartype) {
		
		
		case 1: type = "ctl00_MainContent_fmwOrder_cardList_0";
		        cardnum = "4" +first15;
		        break;
		case 2: type = "ctl00_MainContent_fmwOrder_cardList_1";
		 		cardnum = "5" +first15;
		 		break;
		case 3: type = "ctl00_MainContent_fmwOrder_cardList_2";
				cardnum = "3" +first15/10;
				break;
		}
		
				
		driver.findElement(By.id(type)).click();		
		
		driver .findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardnum);
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("02/22");
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		driver.findElement(By.linkText("View all orders")).click();
		
		
		
		
		
	}
	
}
