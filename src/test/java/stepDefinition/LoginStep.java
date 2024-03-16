package stepDefinition;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.LoginPage;
import utils.TestContextSetup;
import utils.TestDataLoader;

public class LoginStep {
    TestContextSetup testContextSetup;
    protected LoginPage loginPage;
    TestDataLoader testDataLoader;

    public LoginStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        loginPage = testContextSetup.pageObjectManager.getLoginPage();
        testDataLoader = new TestDataLoader();
    }

    @When("user login with valid credentials {string}")
    public void user_login_with_username_and_password(String testCase){
        JsonObject testData = testDataLoader.getTestDataForTestCase(testCase);
        String username = testData.get("username").getAsString();
        String password = testData.get("password").getAsString();

        loginPage.login(username,password);
    }

    @Then("the locked out error message {string} should displayed")
    public void the_locked_out_error_message_should_displayed(String expectedErrorMessage){
        loginPage.isErrorMessageDisplayed();

        Assert.assertEquals("Failed attempt to log in",expectedErrorMessage,loginPage.getErrorMessageText());
    }


}
