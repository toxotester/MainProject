package PAGE;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {
	 WebDriver driver;
	    WebDriverWait wait;

	    @FindBy(id = "Email") WebElement email;
	    @FindBy(id = "Password") WebElement password;
	    @FindBy(css = "input.login-button") WebElement loginBtn;
	    @FindBy(className = "account") WebElement account;

	    public Login_Page(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }

	    public void login(String user, String pass) {
	        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(user);
	        password.sendKeys(pass);
	        loginBtn.click();
	    }

	    public String getUser() {
	        return wait.until(ExpectedConditions.visibilityOf(account)).getText();
	    }


}
