package com.selcuk.pageobjects;

import com.selcuk.actionDriver.Action;
import com.selcuk.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {
    Action action= new Action();

    @FindBy(id="quantity_wanted")
    private WebElement quantity;

    @FindBy(name="group_1")
    private WebElement size;

    @FindBy(xpath="//span[text()='Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
    private WebElement addToCartMessag;

    @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public AddToCartPage() {
        PageFactory.initElements(getDriver(), this);
    }
    public void enterQuantity(String qty){
        action.type(quantity,qty);
    }
    public void selectSize(String sizeValue){
        action.selectByVisibleText(sizeValue,size);
    }
    public void clickOnAddToCart(){
        action.click(getDriver(),addToCartBtn);
    }
    public boolean validateAddToCart(){
        action.fluentWait(getDriver(),addToCartMessag,10);
        return action.isElementDisplayed(getDriver(),addToCartMessag);
    }
    public OrderPage clickOnProceedToCheckOut(){
        action.fluentWait(getDriver(),proceedToCheckOutBtn,10);
        action.JSClick(getDriver(),proceedToCheckOutBtn);
        return new OrderPage();
    }

}
