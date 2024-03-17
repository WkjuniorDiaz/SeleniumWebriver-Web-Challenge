package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends Base {

    List<Double> cartPagePrice = new ArrayList<>();


    @FindBy(id = "checkout")
    WebElement btnCheckout;
    @FindBys(@FindBy(className = "inventory_item_price"))
    List<WebElement> listPrices;
    @FindBy(className = "title")
    WebElement cartTitle;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void selectCheckout(){
        waitVisibilityOf(btnCheckout);
        clickOn(btnCheckout);
    }

    public void  setCartPrices(){
        waitVisibilityOf(cartTitle);

        List<Double> prices = listPrices.stream()
                .map(WebElement::getText)
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .collect(Collectors.toList());

        cartPagePrice = prices;
    }
}
