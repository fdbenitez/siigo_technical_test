package com.siigo.automation.screenplay.task.falabella;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.siigo.automation.screenplay.ui.web.ProductPage.WARRANTY;

public class AddWarranty implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(WARRANTY),
                Click.on(WARRANTY)
        );
    }

    public static AddWarranty onItem() {
        return Tasks.instrumented(AddWarranty.class);
    }
}
