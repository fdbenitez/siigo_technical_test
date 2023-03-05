package com.siigo.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ShadowHandler {

    public static void openShadow(WebDriver browser) {
        SearchContext shadow = browser.findElement(By.cssSelector("div.airship-html-prompt-shadow")).getShadowRoot();
        shadow.findElement(By.cssSelector("button.airship-btn-deny")).click();
    }


}
