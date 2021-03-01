Feature: Send an email with an attachment

@Login
Scenario Outline: Login to gmail
Given Navigate to gmail login page
When User login into gmail with username <username> and password <password>
Then Validate that User lands on inbox

Examples:

|username					|password		 |
|{Enter sender email here}	|{Enter sender password here}	   |


@ComposeMail
Scenario Outline:: Compose email with attachment and send
Given User is on inbox page
When User composes new mail with text for recepient email id <emailId>
And User uploads an attachment
And User sends email to recepient
Then Validate that Email is sent to recepient
And Close browsers



Examples:

|emailId              |
 |{Enter recipient email here}	|
