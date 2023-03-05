package com.siigo.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GooglePage {
    public static final Target INPUT_SEARCH = Target.the("Buscar").located(By.name("q"));
    public static final Target URL = Target.the("Url").located(By.partialLinkText("https://www.falabella.com.co"));
    public static final Target URL_WEB_SITE = Target.the("Url sitio de falabella").locatedBy("//h3[contains(text(),'falabella.com')]");
}
