package com.selcuk.pageobjects;

import com.selcuk.actionDriver.Action;
import com.selcuk.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationPage extends BaseClass {
    Action action = new Action();
    @FindBy(xpath = "//h1[text()='Create an account']")
    private WebElement formTitle;

    @FindBy(id = "uniform-id_gender1")
    private WebElement mr;

    @FindBy(id = "id_gender2")
    private WebElement mrs;

    @FindBy(name = "customer_firstname")
    private WebElement firstName;

    @FindBy(name = "customer_lastname")
    private WebElement lastName;

    @FindBy(name = "passwd")
    private WebElement passWord;

    @FindBy(name = "days")
    private WebElement days;

    @FindBy(name = "months")
    private WebElement months;

    @FindBy(name = "years")
    private WebElement years;

    @FindBy(name = "firstname")
    private WebElement customerNirstName;

    @FindBy(name = "lastname")
    private WebElement customerLastName;

    @FindBy(name = "company")
    private WebElement companyName;

    @FindBy(name = "address1")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "id_state")
    private WebElement state;

    @FindBy(name = "postcode")
    private WebElement postCode;

    @FindBy(name = "id_country")
    private WebElement country;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(name = "phone_mobile")
    private WebElement mobile;

    @FindBy(name = "alias")
    private WebElement ref;

    @FindBy(name = "submitAccount")
    private WebElement registerBtn;

    public accountCreationPage() {
        PageFactory.initElements(getDriver(), this);
    }
    public void createAccount(String gender,String fName,String lName,
                              String pswd,String day,String month,String year,
                              String company,String addrs,String cityString,String stateString,
                              String zipCode,String countryName,String mobilePhone) {
        if (gender.equalsIgnoreCase("mr")) {
            action.click(getDriver(), mr);
        } else {
            action.click(getDriver(), mrs);
        }
        action.type(firstName, fName);
        action.type(lastName, lName);
        action.type(passWord, pswd);
        action.selectByValue(days, day);
        action.selectByValue(months, month);
        action.selectByValue(years, year);
        action.type(companyName, company);
        action.type(address, addrs);
        action.type(city,cityString);
        action.selectByVisibleText(stateString,state);
        action.type(postCode, zipCode);
        action.selectByVisibleText(countryName,country);
        action.type(mobile, mobilePhone);
    }
    public Homepage validateRegistration(){
        registerBtn.click();
        return new Homepage();
    }
    public boolean validateAccountCreatePage(){
        return action.isElementDisplayed(getDriver(),formTitle);
    }

}
