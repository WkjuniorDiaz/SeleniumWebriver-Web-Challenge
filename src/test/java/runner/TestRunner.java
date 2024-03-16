package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/feature",
        glue = {"stepDefinition"},
        monochrome = true,
        tags = "@Checkout",
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:.",
                "rerun:target/failed_scenarios.txt"
        }
)
public class TestRunner {
}
