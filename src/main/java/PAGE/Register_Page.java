package PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Page {
	WebDriver driver;

    @FindBy(className = "ico-register") WebElement registerLink;
    @FindBy(id = "FirstName") WebElement fname;
    @FindBy(id = "LastName") WebElement lname;
    @FindBy(id = "Email") WebElement email;
    @FindBy(id = "Password") WebElement pass;
    @FindBy(id = "ConfirmPassword") WebElement confirm;
    @FindBy(id = "register-button") WebElement registerBtn;
    @FindBy(className = "result") WebElement msg;

    public Register_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void register(String mail) {
        registerLink.click();
        fname.sendKeys("Praveen");
        lname.sendKeys("Test");
        email.sendKeys(mail);
        pass.sendKeys("Praveen@123");
        confirm.sendKeys("Praveen@123");
        registerBtn.click();
    }

    public String getMessage() {
    	return msg.getText();
    	}
    }
        


