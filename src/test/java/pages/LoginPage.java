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

    @FindBy(id = ("[id='Login']"))
    WebElement loginInput;


    public void loginButtonClick(){
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

    public void inputUserLogin(String userLogin){
        loginInput.sendKeys(userLogin);
    }

//    private void inputUserPassword(String userPassword);
//        passwordInput.sendKeys(userLogin);


}