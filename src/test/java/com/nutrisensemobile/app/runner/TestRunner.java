package com.nutrisensemobile.app.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"com.nutrisensemobile.app.steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@rishi"
        
     //   dryRun = true
)

public class TestRunner {

	
}
