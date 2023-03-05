package com.siigo.automation.screenplay.task.app;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.siigo.automation.screenplay.ui.app.HomePage.TRIANGLE;

public class NavigateTo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TRIANGLE, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(TRIANGLE)
        );
    }

    public static NavigateTo TrianguleModule() {
        return Tasks.instrumented(NavigateTo.class);
    }
}
