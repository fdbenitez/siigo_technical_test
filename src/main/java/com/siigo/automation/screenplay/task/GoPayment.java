package com.siigo.automation.screenplay.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.siigo.automation.screenplay.ui.ProductPage.GO_PAYMENT;
import static com.siigo.automation.screenplay.ui.ProductPage.SUBTOTAL;
import static com.siigo.automation.utils.Constants.SUBTOTAL_VALUE;

public class GoPayment implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SUBTOTAL, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
        );
        actor.remember(SUBTOTAL_VALUE, SUBTOTAL.resolveFor(actor).getText().replace(" ", ""));
        actor.attemptsTo(
                WaitUntil.the(GO_PAYMENT, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(GO_PAYMENT),
                Click.on(GO_PAYMENT)
        );
    }

    public static GoPayment onSite() {
        return Tasks.instrumented(GoPayment.class);
    }
}
