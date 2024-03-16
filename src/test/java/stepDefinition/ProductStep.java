package stepDefinition;

import io.cucumber.java.en.Then;
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
}
