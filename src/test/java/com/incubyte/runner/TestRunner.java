package com.incubyte.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features"},
tags = {"@Login,@ComposeMail"},
glue = {"com.incubyte.stepdefinitions"})
public class TestRunner extends AbstractTestNGCucumberTests{
	

}
