package com.base2.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginScreen { 
	
	public static boolean loginFieldsValidation(WebDriver browser) {
		
		
		//cssSelectors on login screen, will be used in field validations.
		//if the structure of the website changes, these values must be updated --
		final String TABLELOGINSELECTOR = "body > div:nth-child(5) > form > table > tbody > tr:nth-child(1) > td.form-title";
		final String LABELUSERNAMESELECTOR = "body > div:nth-child(5) > form > table > tbody > tr:nth-child(2) > td.category";
		final String LABELPASSWORDSELECTOR = "body > div:nth-child(5) > form > table > tbody > tr:nth-child(3) > td.category";
		final String LABELREMEMBERSELECTOR = "body > div:nth-child(5) > form > table > tbody > tr:nth-child(4) > td.category";
		//couldnt find this elemente using cssSelector, hence used xpath
		final String LABELSECURESELECTOR = "/html/body/div[3]/form/table/tbody/tr[5]/td[1]";
	
		//Login interface validation
		String loginTable = "";
		String labelUsername = "";
		String labelPassword = "";
		String labelRemember = "";
		String labelSecureSession = "";
				
		loginTable = browser.findElement(By.cssSelector(TABLELOGINSELECTOR)).getText();
		labelUsername = browser.findElement(By.cssSelector(LABELUSERNAMESELECTOR)).getText();
		labelPassword = browser.findElement(By.cssSelector(LABELPASSWORDSELECTOR)).getText();
		labelRemember = browser.findElement(By.cssSelector(LABELREMEMBERSELECTOR)).getText();
		labelSecureSession = browser.findElement(By.xpath(LABELSECURESELECTOR)).getText();
		
		//label login
		if(loginTable.equals("Login")) {
			
			System.out.println("### INICIANDO VALIDACAO DOS LABELS DOS CAMPOS DE LOGIN ###");
			//label username
			System.out.println(labelUsername.equals("Username") ? "Label Username OK!" : "Label Username NAO ENCONTRADA");
			
			//label password
			System.out.println(labelPassword.equals("Password") ? "Label Password OK!" : "Label Password NAO ENCONTRADA");
			
			//label Remember
			System.out.println(labelRemember.equals("Remember my login in this browser") ? "Label Remember OK!" : "Label Remember NAO ENCONTRADA");
			
			//label secure session
			System.out.println(labelSecureSession.equals("Secure Session") ? "Label Secure Session OK!" : "Label Secure Session NAO ENCONTRADA");
			
			return true;
			
		}else {
			System.out.println("-- campos de login nao encontrados --");
			
			return false;
		}
		
	}
	
	public static boolean loginValidation(WebDriver browser) {
		
		
		//xpath of login fields to fill on login screen, will be used for filling in data
		final String USERNAMEBOX = "/html/body/div[3]/form/table/tbody/tr[2]/td[2]/input";
		final String PASSWORDBOX = "/html/body/div[3]/form/table/tbody/tr[3]/td[2]/input";
		final String LOGINBUTTON = "/html/body/div[3]/form/table/tbody/tr[6]/td/input";
		final String LOGINFAILED = "/html/body/div[2]/font";
		
		WebElement loginField = browser.findElement(By.xpath(USERNAMEBOX));
		loginField.sendKeys("mariane.fernandes");
		
		WebElement passwordField = browser.findElement(By.xpath(PASSWORDBOX));
		passwordField.sendKeys("12345");
		
		WebElement loginButton = browser.findElement(By.xpath(LOGINBUTTON));
		
		if(loginButton.isEnabled()) {
			loginButton.click();
			
			//Waits for load after clicking
			browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			String loginFail = null;
			
			//Verifies if login failed and shows message received
			try {
				loginFail = browser.findElement(By.xpath(LOGINFAILED)).getText();
				System.out.println(" -- NAO FOI POSSIVEL FAZER LOGIN. Mensagem recebida: "+loginFail);
				
				return false;
				
			}catch (NoSuchElementException e) { //exception imported from openqa.selenium
				System.out.println("### Login Feito ###");
			}
			
		}else {
			System.out.println("-- BOTAO DE LOGIN DESABILITADO --");
			return false;
		}
		
		return true;
	}
}
