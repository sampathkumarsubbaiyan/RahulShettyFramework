package org.example.CucumberRunner;

import io.cucumber.core.options.CucumberOptionsAnnotationParser;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/org/example/features/GoogleApi.feature" , glue = {"org/example/stepdefinitions"},plugin = {"json:target/jsonreports/cucumber-report.json"})


public class CucumberRunner {


}
