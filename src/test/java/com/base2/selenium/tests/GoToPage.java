package com.base2.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class GoToPage {
	
	public static void goToPage(WebDriver driver){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//open website
		driver.navigate().to("http://mantis-prova.base2.com.br");
		driver.manage().window().maximize();
	}

}
