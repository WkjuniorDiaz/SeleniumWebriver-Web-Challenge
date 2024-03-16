package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.CheckoutPage;
import utils.TestContextSetup;
import utils.TestDataLoader;

public class CheckoutStep {
    TestContextSetup testContextSetup;
    protected CheckoutPage checkoutPage;
    TestDataLoader testDataLoader;

    public CheckoutStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
        testDataLoader = new TestDataLoader();
    }

    @When("the user fills the checkout information with first name {string}, last name {string} and postal code {string}")
    public void the_user_fill_the_checkout_information(String firstName,String lastName,String postalCode){
        checkoutPage.fillCheckoutForm(firstName,lastName,postalCode);
    }

    @When("the user clicks on the continue button")
    public void the_user_clicks_on_the_continue_button(){
        checkoutPage.selectContinue();
    }

    @When("the user clicks on the finish button to complete the checkout")
    public void the_user_clicks_on_the_finish_button_to_complete_the_checkout(){
        checkoutPage.validateCheckoutOverview();
        checkoutPage.selectFinish();
    }

    @Then("verify that the checkout was successfully and logout")
    public void verify_that_the_checkout_was_successfully_and_logout(){
        checkoutPage.validateCheckoutComplete();
        Assert.assertEquals("Successful checkout message was not displayed","Thank you for your order",checkoutPage.getTextMessage1());
        checkoutPage.logOut();
    }





}
