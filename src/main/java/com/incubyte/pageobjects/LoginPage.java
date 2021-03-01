package com.incubyte.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.cssSelector("input[type='email']");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	By password = By.xpath("//input[@name='password']");

	public  WebElement getPassword() {
		 return  driver.findElement(password);
	}

	
	By submit = By.cssSelector("div[class ='VfPpkd-RLmnJb']");

	public WebElement submitEmail() {
		return driver.findElement(submit);
	}

	By submitPassword = By.xpath("//div[@class ='VfPpkd-RLmnJb']");

	public WebElement submitPassword() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(submitPassword));
		return driver.findElement(submitPassword);
	}

	public void clickNext() {
		boolean staleElement = true;

		while (staleElement) {

			try {

				driver.findElement(submitPassword).click();

				staleElement = false;

			} catch (StaleElementReferenceException e) {

				staleElement = true;

			}

		}

	

	}

	public InboxPage getDriver() {
		InboxPage inboxPage = new InboxPage(driver);
		return inboxPage;
	}

}
