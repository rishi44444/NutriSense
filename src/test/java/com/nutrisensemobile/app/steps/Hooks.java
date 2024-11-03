package com.nutrisensemobile.app.steps;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.nutrisensemobile.app.utility.Appium;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

//	@BeforeAll
//	public static void before_all() throws MalformedURLException, URISyntaxException {
//		Appium app = new Appium();
//		app.ConfigureAppium();
//		System.out.println("before all scenario");
//	}
	
	@Before
	public static void beforeEachScenario() throws MalformedURLException, URISyntaxException {
		Appium app = new Appium();
		app.ConfigureAppium();
		System.out.println("before all scenario");
	}
	
	@After
	public static void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
            // Capture and attach screenshot if the scenario fails
            byte[] screenshot = ((TakesScreenshot) Appium.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
		Appium.driver.quit();
	}
}
