package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Base;

public class ProductPage extends Base {

    @FindBy(xpath = "//span[@class='title']")
    WebElement productTitle;
    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void validateProductPage() {
        waitVisibilityOf(productTitle);
    }

    public String getProductTitle() {
        return getElementText(productTitle);
    }

    public void addProduct(String productName) {
        By productElement = By.xpath("//div[.='"+productName+"']/../../../div/button[@class='btn btn_primary btn_small btn_inventory ']");

        waitVisibilityOf(driver.findElement(productElement));
        clickOn(driver.findElement(productElement));
    }

    public void selectCart(){
        clickOn(cartIcon);
    }

}
