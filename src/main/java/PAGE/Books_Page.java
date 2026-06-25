package PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Books_Page {
	WebDriver driver;

    @FindBy(linkText = "Books") WebElement books;
    @FindBy(id = "products-orderby") WebElement sort;
    @FindBy(id = "products-pagesize") WebElement display;
    @FindBy(id = "products-viewmode") WebElement view;
    @FindBy(linkText = "Computing and Internet") WebElement book;
    @FindBy(xpath = "(//input[@type='button' and @value='Add to cart'])[1]") WebElement addCart;
    @FindBy(xpath = "//p[contains(text(),\"The product has been added to your\")]") WebElement prodConf;
   // @FindBy(id = "add-to-cart-button-13") WebElement addCart;

    public Books_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openBooks() {
        books.click();
    }

    public void applyFilters() {
        new Select(sort).selectByVisibleText("Name: A to Z");
        new Select(display).selectByVisibleText("8");
        new Select(view).selectByVisibleText("Grid");
    }

    public void addBook() {
        book.click();
        addCart.click();
        System.out.println("book added successfully");
        prodConf.click();
    }

}
