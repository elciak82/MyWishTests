package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends GenericPage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ("//button[@class='app-tab'][1]"))
    WebElement loginButton;

    @FindBy(xpath = ("//button[@class='app-tab'][2]"))
    WebElement registrationButton;

    @FindBy(css = ("[type='checkbox']"))
    WebElement regulationsCheckbox;

    @FindBy(id = ("Login"))
    WebElement login;

    @FindBy(css = ("[alt='App logo']"))
    WebElement appLogo;

    @FindBy(xpath = ("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/div/form/span[2]/div[2]/div/input"))
    WebElement password;

    @FindBy(css = ("[type='submit']"))
    WebElement submitButton;

    public void loginButtonClick() {
        loginButton.click();
    }

    public void registrationButtonClick() {
        registrationButton.click();
    }

    public LoginPage deselectRegulations() {
        if (regulationsCheckbox.isSelected()) ;
        regulationsCheckbox.click();
        return this;
    }

    public LoginPage selectRegulations() {
        if (!regulationsCheckbox.isSelected()) ;
        regulationsCheckbox.click();
        return this;
    }

    private void inputUserLogin(String userLogin) {
        login.click();
        login.sendKeys(userLogin);
    }

    private void inputUserPassword(String userPassword) {
        password.click();
        password.sendKeys(userPassword);
    }

    private void clickSubmitButton() {
        GenericPage genericPage = new GenericPage(driver);
        genericPage.fluentWaitForElementDisplayed(submitButton);
        submitButton.click();
    }

    public void loggingInToApp (String login, String password) {
        inputUserLogin(login);
        inputUserPassword(password);
        clickSubmitButton();
    }

    public void waitForAppLogo(){
        GenericPage genericPage = new GenericPage(driver);
        genericPage.fluentWaitForElementDisplayed(appLogo);
    }
}