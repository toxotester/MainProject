package PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Jewelry_Page {
	WebDriver driver;

    @FindBy(linkText = "Jewelry") WebElement jewelry;

    @FindBy(id = "products-orderby") WebElement sort;
    @FindBy(id = "products-pagesize") WebElement display;
    @FindBy(id = "products-viewmode") WebElement view;

    @FindBy(linkText = "Black & White Diamond Heart") WebElement product;
    @FindBy(id = "add-to-cart-button-14") WebElement addCart;

    public Jewelry_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openJewelry() {
        jewelry.click();
    }

    public void applyFilters() {
        new Select(sort).selectByVisibleText("Name: A to Z");
        new Select(display).selectByVisibleText("8");
        new Select(view).selectByVisibleText("Grid");
    }

    public void addProduct() {
        product.click();
        addCart.click();
    }

}
