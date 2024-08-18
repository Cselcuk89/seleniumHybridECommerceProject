package com.selcuk.pageobjects;

import com.selcuk.actionDriver.Action;
import com.selcuk.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BaseClass {
    Action action = new Action();
    @FindBy(xpath="//span[text()='My wishlists']")
    private WebElement myWishList;

    @FindBy(xpath = "//span[text()='Order history and details']")
    private WebElement orderHistory;

    public Homepage() {
        PageFactory.initElements(getDriver(), this);
    }
    public boolean validateMyWishList(){
        return action.isElementDisplayed(getDriver(), myWishList);

    }
    public boolean validateOrderHistory(){
        return action.isElementDisplayed(getDriver(), orderHistory);
    }
    public String getURL(){
        return action.getCurrentURL(getDriver());
    }


}
