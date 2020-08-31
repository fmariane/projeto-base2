package com.base2.selenium.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.base2.selenium.driverutil.DriverFactory;

public class RunTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = DriverFactory.getBrowser();
        GoToPage.goToPage(driver);
    }

    @Test
    public void loginInterfaceTest(){
    	//calls login screen interface validation
    	boolean loginFieldsOk = LoginScreen.loginFieldsValidation(driver);
    			
    	if(loginFieldsOk == true) {
    		System.out.println("### FINALIZADA VALIDACAO DOS LABELS DOS CAMPOS DE LOGIN ###"+"\n");
    	}else {
    		System.out.println("### TELA DE LOGIN NAO ENCONTRADA ###"+"\n");
    	}
    }
    
    @Test
    public void loginTest(){
    	boolean loginFormFilled = LoginScreen.loginValidation(driver);
		
		System.out.println(loginFormFilled ? "### Login Validado ###" : "Class LoginScreen Says: -- NAO FOI POSSIVEL FAZER LOGIN --");
    }
    
  
    @After
    public void tearDown(){
        driver.quit();
    }
}
