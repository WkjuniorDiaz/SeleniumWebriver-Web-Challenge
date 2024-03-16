package stepDefinition;

import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class searchFlightStep {

    public WebDriver driver;
    TestContextSetup testContextSetup;

    public searchFlightStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;

    }
}
