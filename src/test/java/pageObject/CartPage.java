package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

public class CartPage extends Base {

    @FindBy(id = "checkout")
    WebElement btnCheckout;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void selectCheckout(){
        waitVisibilityOf(btnCheckout);
        clickOn(btnCheckout);
    }
}
