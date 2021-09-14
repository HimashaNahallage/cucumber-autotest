package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //private BY locator, constructor, public page actions and use encapsulation
    private WebDriver driver;

    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPwdLink = By.linkText("Forgot your password?");

    //constructor of the page class
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //page actions
    /*public void getLoginPageTitle(){
        driver.getTitle();
    }*/
    public String getLoginPageTitle(){
       return driver.getTitle();
    }

   /* public void idForgotPwdLinkExist(){
         return driver.findElement(forgotPwdLink).isDisplayed();
    }*/
    public boolean idForgotPwdLinkExist(){
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }

    //Responsible for return the object of AccountsPage
    public AccountsPage doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountsPage(driver);
    }
}
