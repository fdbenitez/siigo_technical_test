package com.siigo.automation.screenplay.task.falabella;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.siigo.automation.screenplay.ui.ProductPage.INCREASE;
import static com.siigo.automation.screenplay.ui.ProductPage.SEE_CART;
import static com.siigo.automation.utils.RandomDataHelper.increaseRandom;

public class IncreaseItems implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SEE_CART, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SEE_CART),
                WaitUntil.the(INCREASE, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(INCREASE, WebElementStateMatchers.isClickable()).forNoMoreThan(5).seconds()
        );
        for (int i = 0; i < increaseRandom(); i++) {
            actor.attemptsTo(
                    Click.on(INCREASE),
                    WaitUntil.the(INCREASE, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds());

        }
    }

    public static IncreaseItems onCart() {
        return Tasks.instrumented(IncreaseItems.class);
    }
}
