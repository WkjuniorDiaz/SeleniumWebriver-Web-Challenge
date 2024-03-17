package stepDefinition;

import io.cucumber.java.en.When;
import pageObject.CartPage;
import utils.TestContextSetup;

public class CartStep {
    TestContextSetup testContextSetup;
    protected CartPage cartPage;

    public CartStep(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        cartPage = testContextSetup.pageObjectManager.getCartPage();
    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        cartPage.setCartPrices();
        cartPage.selectCheckout();
    }
}
