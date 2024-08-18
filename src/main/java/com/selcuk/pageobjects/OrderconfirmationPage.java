package com.selcuk.pageobjects;

import com.selcuk.actionDriver.Action;
import com.selcuk.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderconfirmationPage extends BaseClass {
    Action action= new Action();

    @FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
    private WebElement confirmMessag;

    public OrderconfirmationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String validateConfirmMessage() {
        String confirmMsg = confirmMessag.getText();
        return confirmMsg;
    }
}
