package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GenericPage;
import pages.LoginPage;

import static helpers.Configuration.getConfiguration;
import static helpers.Driver.initializeWebDriver;

public class LoginPageTests implements LoginPageData {

    private LoginPage loginPage;
    private WebDriver driver;
    private GenericPage genericPage;
    private String suffix;

    @BeforeTest
    public void setUp() {
        driver = initializeWebDriver();
        driver.get(getConfiguration().getSiteURL());
        this.genericPage = new GenericPage(driver);
        this.loginPage = new LoginPage(driver);
        this.suffix = genericPage.generateAlphaNumeric(5);
    }

    @Test
    public void registration_newUser_correctData() {
        String newUserLogin = NEW_USER + suffix;
        String newUserPassword = NEW_PASSWORD + suffix;
    }

    @Test
    public void login_correctData() {
        String correctUserLogin = LoginPageData.CORRECT_USER_NAME;
//        String correctUserPassword = NEW_PASSWORD + suffix;

        loginPage.inputUserLogin(correctUserLogin);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
