package com.siigo.automation.screenplay.questions;

import com.siigo.automation.screenplay.exceptions.ResultNotWaited;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.siigo.automation.screenplay.ui.DeliveryPage.PRODUCT;

public class ValidateProduct implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String product;
        try {
            product=PRODUCT.resolveFor(actor).getText();
            product=product.substring(0,40);
            System.out.println(product);
            return product;
        } catch (ResultNotWaited ex) {
            return ResultNotWaited.FAILED_PRODUCT;
        }
    }

    public static ValidateProduct orderStatus() {
        return new ValidateProduct();
    }
}
