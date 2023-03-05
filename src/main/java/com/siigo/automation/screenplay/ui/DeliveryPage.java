package com.siigo.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DeliveryPage {
    public static final Target TOTAL_PRICE = Target.the("Item seleccionado").locatedBy("//span[@class='fbra_text fbra_test_orderSummary__itemsTotalPrice fbra_orderSummary__itemsTotalPrice']");
    public static final Target PRODUCT = Target.the("Product").locatedBy("//*[@id='fbra_checkoutOrderSummary']//li//div//div[1]//span[2]");
}
