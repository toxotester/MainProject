package PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Computers_Page {
	WebDriver driver;

    @FindBy(linkText = "Computers") WebElement computers;
    @FindBy(linkText = "Desktops") WebElement desktops;

    @FindBy(id = "products-orderby") WebElement sort;
    @FindBy(id = "products-pagesize") WebElement display;
    @FindBy(id = "products-viewmode") WebElement view;

    @FindBy(linkText = "Build your own computer") WebElement product;
    @FindBy(id = "add-to-cart-button-1") WebElement addCart;

    public Computers_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openComputers() {
        computers.click();
        desktops.click();
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
