package com.step_it.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductPage extends BasePage {
    @FindBy(css = ".inventory_item_description")
    private List<WebElement> productDescriptions;
    private By productNameEl = By.className("inventory_item_name");
    private By addRemoveBtn = By.tagName("button");

    public void waitUntilProductsAreDisplayed() {
        getPageLoader().isListVisible(productDescriptions, 0);
    }

    public void addProductToCart(String desiredProductName) {
        getProduct(desiredProductName).findElement(addRemoveBtn).click();
    }

    private WebElement getProduct(String desiredProductName) {
        for (WebElement product : productDescriptions) {
            WebElement productNameEl = product.findElement(this.productNameEl);
            if (desiredProductName.equalsIgnoreCase(productNameEl.getText())) {
                return product;
            }
        }
            throw new NoSuchElementException("Couldn't find element" + desiredProductName);
        }
    }


