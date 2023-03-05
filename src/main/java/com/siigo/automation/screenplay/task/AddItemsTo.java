package com.siigo.automation.screenplay.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.siigo.automation.screenplay.ui.FalabellaHomePage.ITEM;
import static com.siigo.automation.screenplay.ui.ProductPage.CART;

public class AddItemsTo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ITEM, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ITEM),
                WaitUntil.the(CART, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CART)
        );
    }

    public static AddItemsTo cart() {
        return Tasks.instrumented(AddItemsTo.class);
    }
}
