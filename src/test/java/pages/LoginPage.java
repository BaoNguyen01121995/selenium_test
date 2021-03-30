package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{

    By xpath_username = By.xpath("//input[@id='username']");
    By xpath_password = By.xpath("//input[@id='password']");
    By xpath_submit = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("http://the-internet.herokuapp.com/login");
    }

    public void fillForm(String username, String pass){
        driver.findElement(xpath_username).sendKeys(username);
        driver.findElement(xpath_password).sendKeys(pass);
        driver.findElement(xpath_submit).click();
    }

    public void checkValidUrl(String url){
        if(url.equalsIgnoreCase("/secure")){
            Assert.assertEquals(url,"/secure");
        }else{
            Assert.assertEquals(url,"/login");
        }
    }
}
