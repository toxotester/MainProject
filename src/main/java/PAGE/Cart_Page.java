package PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_Page {
	WebDriver driver;

    @FindBy(className = "cart-label") WebElement cart;
    @FindBy(className = "product-name") WebElement product;

    public Cart_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCart() {
        cart.click();
    }

    public String getProduct() {
        return product.getText();
    }

}
