import java.sql.Driver;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import BASE.BASE;
import PAGE.Books_Page;
import PAGE.Cart_Page;
import PAGE.Computers_Page;
import PAGE.Electronics_Page;
import PAGE.Jewelry_Page;
import PAGE.Login_Page;
import PAGE.Register_Page;

public class Demo_WebShop_Test extends BASE{
	
	String email;
    String password = "Praveen@123";

    @Test(priority = 0)
    public void registerTest() {

        Register_Page rp = new Register_Page(driver);

        email = "test" + System.currentTimeMillis() + "@mail.com";

        rp.register(email);

        Assert.assertTrue(rp.getMessage().contains("completed"), "❌ Registration Failed");
    }
    

    @Test(priority = 1, dependsOnMethods = "registerTest")
    public void loginTest() {

        Login_Page lp = new Login_Page(driver);

        lp.login(email, password);

        Assert.assertTrue(lp.getUser().contains("@"), "❌ Login Failed");
    }
    

    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void booksTest() {

        Books_Page bp = new Books_Page(driver);

        bp.openBooks();
        bp.applyFilters();
        bp.addBook();

        Assert.assertTrue(driver.getPageSource().contains("added"), "❌ Book not added");
    }
    

    @Test(priority = 3, dependsOnMethods = "booksTest")
    public void cartTest() {

        Cart_Page cp = new Cart_Page(driver);

        cp.openCart();

        Assert.assertTrue(cp.getProduct().length() > 0, "❌ Cart is empty");
    }
    

    @Test(priority = 4)
    public void navigationTest() {

        driver.findElement(By.linkText("Books")).click();

        Assert.assertTrue(driver.getTitle().contains("Books"), "❌ Navigation Failed");
    }
    

    @Test(priority = 5)
    public void logoutTest() {

        driver.findElement(By.className("ico-logout")).click();

        Assert.assertTrue(driver.getPageSource().contains("Log in"), "❌ Logout Failed");
    }
    

    @Test(priority = 6)
    public void computersTest() {

        Computers_Page cp = new Computers_Page(driver);

        cp.openComputers();
        cp.applyFilters();
        cp.addProduct();

        Assert.assertTrue(driver.getPageSource().contains("added"), "❌ Computer not added");
    }
    

    @Test(priority = 7)
    public void electronicsTest() {

        Electronics_Page ep = new Electronics_Page(driver);

        ep.openElectronics();
        ep.applyFilters();
        ep.addProduct();

        Assert.assertTrue(driver.getPageSource().contains("added"), "❌ Electronics not added");
    }
    

    @Test(priority = 8)
    public void jewelryTest() {

        Jewelry_Page jp = new Jewelry_Page(driver);

        jp.openJewelry();
        jp.applyFilters();
        jp.addProduct();

        Assert.assertTrue(driver.getPageSource().contains("added"), "❌ Jewelry not added");
    }
    
    @AfterTest
	public void end() {
		driver.quit();
	}
}