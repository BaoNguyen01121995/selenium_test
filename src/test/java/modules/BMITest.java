package modules;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BMIPage;

public class BMITest extends BaseTest{
    @Test
    public void tc(){
        BMIPage page = new BMIPage(driver);
        page.open();
        page.openMetricUnitsTab();
        page.fillForm("25","male","180","65");
        Assert.assertEquals(page.getResult(),"Normal");
    }
}
