package com.selcuk.pageobjects;

import com.selcuk.actionDriver.Action;
import com.selcuk.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {
    Action action= new Action();

    @FindBy(xpath="//td[@class='cart_unit']/span/span")
    private WebElement unitPrice;

    @FindBy(id="total_price")
    private WebElement totalPrice;

    @FindBy(xpath="//span[text()='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    public OrderPage() {
        PageFactory.initElements(getDriver(), this);
    }

}
