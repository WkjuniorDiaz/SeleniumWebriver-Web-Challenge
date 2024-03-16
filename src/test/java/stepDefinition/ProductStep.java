package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.ProductPage;
import utils.TestContextSetup;

public class ProductStep {

    TestContextSetup testContextSetup;
    protected ProductPage productPage;

    public ProductStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        productPage = testContextSetup.pageObjectManager.getProductPage();
    }

    @Then("the product page should displayed")
    public void the_product_page_should_displayed(){
        productPage.validateProductPage();

        Assert.assertEquals("Failed attempt to log in","Products",productPage.getProductTitle());
    }

    @When("the user adds the product {string} to the cart")
    public void the_user_adds_the_product_to_the_cart(String productName){
        productPage.validateProductPage();
        productPage.addProduct(productName);
    }
    @When("the user navigates to the cart")
    public void the_user_navigates_to_the_cart(){
        productPage.selectCart();
    }
}
