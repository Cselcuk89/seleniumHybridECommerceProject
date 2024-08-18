package com.selcuk.pageobjects;

import com.selcuk.actionDriver.Action;
import com.selcuk.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    Action action= new Action();

    @FindBy(id="email")
    private WebElement userName;

    @FindBy(id="passwd")
    private WebElement password;

    @FindBy(id="SubmitLogin")
    private WebElement signInBtn;

    @FindBy(name="email_create")
    private WebElement emailForNewAccount;

    @FindBy(name="SubmitCreate")
    private WebElement createNewAccountBtn;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }
    public Homepage loginMethod(String username,String pswrd) throws InterruptedException {
        action.scrollByVisibilityOfElement(getDriver(),userName);
        action.type(userName,username);
        action.type(password,pswrd);
        action.JSClick(getDriver(),signInBtn);
        Thread.sleep(2000);
        return new Homepage();

    }
    public AddressPage login(String uname,String pswd) throws InterruptedException {
        action.scrollByVisibilityOfElement(getDriver(),userName);
        action.type(userName,uname);
        action.type(password,pswd);
        action.JSClick(getDriver(),signInBtn);
        Thread.sleep(2000);
        return new AddressPage();

    }
    public accountCreationPage createNewAccount(String email) throws InterruptedException {
        action.scrollByVisibilityOfElement(getDriver(),emailForNewAccount);
        action.type(emailForNewAccount,email);
        action.JSClick(getDriver(),createNewAccountBtn);
        Thread.sleep(2000);
        return new accountCreationPage();
    }


}
