package modules;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    @DataProvider(name = "test_data_tc01")
    Object [][] Credentials(){
        return new Object[][]{
          new Object[]{"tomsmith","SuperSecretPassword!","/secure"},
          new Object[] {"tomsmith","SuperSecretPassword","/login"},
          new Object[] {"tomsmith1","SuperSecretPassword!","/login"}
        };
    }
    @Test(dataProvider = "test_data_tc01")
    public void tc01(String username, String password, String url){
        LoginPage page = new LoginPage(driver);
        page.open();
        page.fillForm(username, password);
        page.checkValidUrl(url);
    }
}
