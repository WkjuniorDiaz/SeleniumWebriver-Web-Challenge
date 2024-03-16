package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Base;

public class ProductPage extends Base {

    @FindBy(xpath = "//span[@class='title']")
    WebElement productTitle;

    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void validateProductPage(){
        waitVisibilityOf(productTitle);
    }

    public String getProductTitle(){
        return getElementText(productTitle);
    }

}
