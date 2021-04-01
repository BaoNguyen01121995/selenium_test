package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BMIPage extends BasePage{
    By xpath_age = By.xpath("//input[@id='cage']");
    By xpath_metricUnits = By.xpath("//div[@class='leftinput']/div[@id='topmenu']/ul/li[2]");
    By xpath_gender_male = By.xpath("//input[@id='csex1']");
    By xpath_gender_female = By.xpath("//input[@id='csex2']");
    By xpath_height = By.xpath("//input[@id='cheightmeter']");
    By xpath_weight = By.xpath("//input[@id='ckg']");
    By xpath_clearbtn = By.xpath("//img[@class='clearbtn']");
    By result = By.xpath("//div[@class='rightresult']/div[@class='bigtext']/font/b");
    public BMIPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    public void fillForm(String age, String gender, String height, String weight){
        driver.findElement(xpath_clearbtn).click();
        driver.findElement(xpath_age).sendKeys(age);
        if(gender.equalsIgnoreCase("male"))
        {
            driver.findElement(xpath_gender_male).click();
        }else{
            driver.findElement(xpath_gender_female).click();
        }
        driver.findElement(xpath_height).sendKeys(height);
        driver.findElement(xpath_weight).sendKeys(weight);
    }

    public void openMetricUnitsTab(){
        driver.findElement(xpath_metricUnits).click();
    }

    public String getResult(){
        return driver.findElement(result).getText();
    }
}
