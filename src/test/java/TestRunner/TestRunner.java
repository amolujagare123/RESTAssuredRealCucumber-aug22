package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features"
        ,glue = "stepdefinition"
        , plugin = {"pretty","html:target/report.html"}
        , tags = "@ChatCreateUser"
       // , dryRun = true
)
public class TestRunner {
}
