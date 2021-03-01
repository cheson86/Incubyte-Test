package com.incubyte.stepdefinitions;

import java.util.Properties;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.incubyte.pageobjects.InboxPage;
import com.incubyte.pageobjects.LoginPage;
import com.incubyte.resources.Base;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefinition {

	private static WebDriver driver;

	private Base base;

	public StepDefinition(Base base) {
		this.base = base;
	}

	@Given("^Navigate to gmail login page$")
	public void navigate_to_gmail_login_page() throws Throwable {

		driver = base.initializeDriver();

		driver.get(base.properties.getProperty("url"));

	}

	InboxPage inboxPage;

	@Given("^User is on inbox page$")
	public void user_is_on_inbox_page() throws Throwable {

		inboxPage = new InboxPage(driver);
		Assert.assertTrue(inboxPage.getSearchMail().isDisplayed());
	}

	@When("^User login into gmail with username (.+) and password (.+)$")
	public void user_login_into_gmail_with_username_and_password(String username, String password) throws Throwable {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(username);
		loginPage.submitEmail().click();

	

		loginPage.getPassword().sendKeys(password);
		loginPage.clickNext();
		inboxPage = loginPage.getDriver();
	}

	@When("^User composes new mail with text for recepient email id (.+)$")
	public void user_composes_new_mail_with_text_for_recepient_email_id(String emailid) throws Throwable {

		inboxPage.composeButton().click();
		inboxPage.enterRecepientEmailId().sendKeys(emailid);
		inboxPage.getSubjectBox().sendKeys("Incubyte test demo");
		inboxPage.getMessageBox().sendKeys("This email contains attachment");
	}

	@Then("^Validate that User lands on inbox$")
	public void validate_that_user_lands_on_inbox() throws Throwable {

		Assert.assertTrue(inboxPage.getSearchMail().isDisplayed());
	}

	@Then("^Validate that Email is sent to recepient$")
	public void validate_that_email_is_sent_to_recepient() throws Throwable {

		Assert.assertTrue(inboxPage.getSentPopUp().isDisplayed());
	}

	@And("^User uploads an attachment$")
	public void user_uploads_an_attachment() throws Throwable {

		String path = base.properties.getProperty("attachmentPath");

		inboxPage.addAttachment(path);
	}

	@And("^User sends email to recepient$")
	public void user_sends_email_to_recepient() throws Throwable {

		inboxPage.sendButton().click();
	}

	@And("^Close browsers$")
	public void close_browsers() throws Throwable {

		driver.close();
	}

}
