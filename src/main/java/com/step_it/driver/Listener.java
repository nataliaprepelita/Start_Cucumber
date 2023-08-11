package com.step_it.driver;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Listener implements WebDriverListener {
    private static final Logger log = LoggerFactory.getLogger(CustomEventListener.class);

    @Override
    public void beforeClick(WebElement element) {
        log.info("Clicking on {}", getElement(element));
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence[] keyToSend) {
        log.info("Changing value " + Arrays.toString(keyToSend) + " for ", getElement(element));
        System.out.println("Changing value" + Arrays.toString(keyToSend) + "for" + getElement(element));
    }

    private String getElement(WebElement element) {
        String text = element.getText();
        if (!text.isEmpty()) {
            return text;
        }
        if (!element.getAttribute("id").isEmpty()) {
            return element.getAttribute("id");
        }
        if (!element.getAttribute("class").isEmpty()) {
            return element.getAttribute("class");
        }
        return "";
    }
}
