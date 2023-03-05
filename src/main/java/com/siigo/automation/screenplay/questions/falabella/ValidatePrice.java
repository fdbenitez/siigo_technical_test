package com.siigo.automation.screenplay.questions.falabella;

import com.siigo.automation.screenplay.exceptions.ResultNotWaited;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.siigo.automation.screenplay.ui.web.DeliveryPage.TOTAL_PRICE;

public class ValidatePrice implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        try {
            return TOTAL_PRICE.resolveFor(actor).getText();

        } catch (ResultNotWaited ex) {
            return ResultNotWaited.FAILED_PRICE;
        }
    }

    public static ValidatePrice orderStatus() {
        return new ValidatePrice();
    }
}
