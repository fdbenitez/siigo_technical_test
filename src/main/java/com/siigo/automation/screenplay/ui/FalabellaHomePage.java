package com.siigo.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FalabellaHomePage {
    public static final Target INPUT_SEARCH_ARTICLE = Target.the("Que buscas").located(By.cssSelector("#testId-SearchBar-Input"));
    public static final Target ITEM = Target.the("Item").located(By.cssSelector("#testId-SearchBar-Input"));
}
