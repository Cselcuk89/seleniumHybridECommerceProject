package com.selcuk.pageobjects;

import com.selcuk.actionDriver.Action;
import com.selcuk.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {
    Action action= new Action();

    @FindBy(xpath="//*[@id=\"center_column\"]//img")
    private WebElement productResult;
    public SearchResultPage() {
        PageFactory.initElements(getDriver(), this);
    }
    public boolean isProductAvailable(){
        return action.isElementDisplayed(getDriver(),productResult);
    }
    public AddToCartPage clickOnProduct(){
        action.click(getDriver(),productResult);
        return new AddToCartPage();
    }

}
