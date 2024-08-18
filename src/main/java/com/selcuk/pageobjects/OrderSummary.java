package com.selcuk.pageobjects;

import com.selcuk.actionDriver.Action;
import com.selcuk.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends BaseClass {
    Action action= new Action();

    @FindBy(xpath="//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrderBtn;

    public OrderSummary() {
        PageFactory.initElements(getDriver(), this);
    }

    public OrderconfirmationPage clickOnconfirmOrderBtn() throws Throwable {
        action.click(getDriver(), confirmOrderBtn);
        return new OrderconfirmationPage();
    }
}
