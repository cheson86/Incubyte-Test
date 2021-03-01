package com.incubyte.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.Before;

public class Base {

	private static boolean initialized = false;
	public WebDriver driver;
	public static Properties properties;

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver initializeDriver() throws IOException {
		properties = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\incubyte\\resources\\data.properties");

		properties.load(fis);

		String browser = properties.getProperty("browser");

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chromePath"));

			ChromeOptions options = new ChromeOptions();
		

			if (browser.contains("headless")) {
				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);

		} 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenShotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
