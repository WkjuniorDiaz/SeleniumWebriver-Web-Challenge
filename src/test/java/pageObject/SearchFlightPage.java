package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchFlightPage {
    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "country-suggestion-dialog-title")
    WebElement suggestionModal;

    @FindBy(id = "country-suggestion-dialog-close")
    WebElement suggestionClose;

    @FindBy(xpath = "//button[@class='sc-cOoQYZ epQUAu']")
    WebElement roundTripBtn;

    @FindBy(id = "lstSearchBoxTripType")
    WebElement listSearchTripType;

    @FindBys(@FindBy(xpath = "//button[@class='sc-jrOYZv eIhUsC']"))
    List<WebElement> listTripTypeOptions;

    @FindBy(id = "btnCabinTypeCTA" )
    WebElement typeCabinOption;

    @FindBy(id = "lstSearchBoxCabinType")
    WebElement listSearchCabinType;

    @FindBys(@FindBy(xpath = "//button[@class='sc-jBoNkH gMiDp']"))
    List<WebElement> listCabinTypeOptions;

    @FindBy(id = "txtInputOrigin_field")
    WebElement originField;

    @FindBy(id = "listAutoComplete")
    WebElement listAutomcomplete;

    @FindBys(@FindBy(xpath = "//button[contains(@id,'btnItemAutoComplete')]"))
    List<WebElement> listAutocompleteOptions;

    @FindBy(id = "txtInputDestination_field")
    WebElement destinationField;

    @FindBy(id = "departureDate")
    WebElement departureField;

    @FindBys(@FindBy(xpath = "//td[contains(@class,'CalendarDay')]"))
    List<WebElement> listDateOption;

    @FindBy(id = "btnSearchCTA")
    WebElement searchBtn;

    @FindBy(id = "titleSelectFlightDesktop")
    WebElement flightOffersTitle;

    @FindBy(id   = "WrapperCardFlight0")
    WebElement listAvailableFlights;

    @FindBy(id = "progress-icon")
    WebElement progress;



    public SearchFlightPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void closeSwitchModal(){
        wait.until(ExpectedConditions.visibilityOf(suggestionModal));
        suggestionClose.click();
    }

}
