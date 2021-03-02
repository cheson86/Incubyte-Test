package com.incubyte.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.incubyte.resources.Base;

public class InboxPage {

	public WebDriver driver;

	public InboxPage(WebDriver driver) {
		this.driver = driver;
	}

	By composeButton = By.cssSelector("div[class='T-I T-I-KE L3']");

	public WebElement composeButton() {
		return driver.findElement(composeButton);
	}

	By recepientEmailId = By.xpath("//*[@name='to']");

	public WebElement enterRecepientEmailId() {
		return driver.findElement(recepientEmailId);
	}

	By subjectBox = By.cssSelector("input[name='subjectbox']");

	public WebElement getSubjectBox() {
		return driver.findElement(subjectBox);
	}

	By messageBox = By.xpath("//div[@class='Am Al editable LW-avf tS-tW']");

	public WebElement getMessageBox() {
		return driver.findElement(messageBox);
	}

	By sendButton = By.xpath("//div[text()='Send']");

	public WebElement sendButton() {
		return driver.findElement(sendButton);
	}

	By attachment = By.cssSelector("div[class='a1 aaA aMZ']");

	public void addAttachment(String path) throws IOException, InterruptedException {
		driver.findElement(attachment).click();
		Runtime.getRuntime().exec(path);
		Thread.sleep(6000);
	}
	
	/*
	 * public void addInvalidAttachment(String path) throws IOException,
	 * InterruptedException { driver.findElement(attachment).click();
	 * Runtime.getRuntime().exec(path); Thread.sleep(6000); }
	 */

	By sentPopUp = By.cssSelector(".vh");

	public WebElement getSentPopUp() {
		return driver.findElement(sentPopUp);
	}

	By searchMail = By.cssSelector("input[class='gb_ff']");

	public WebElement getSearchMail() {
		return driver.findElement(searchMail);
	}
	
	By invalidPopUp = By.xpath("//span[contains(text(),'Blocked for security')]");

	public WebElement getInvalidPopUp() {
		return driver.findElement(invalidPopUp);
	}
	
	
	By accountIcon = By.cssSelector("img[class='gb_Da gbii']");
	By signOut = By.cssSelector("#gb_71");

	public WebElement getSignOut() {
		driver.findElement(accountIcon).click();
		return driver.findElement(signOut);
	}

}
