package com.siigo.automation.screenplay.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.siigo.automation.screenplay.ui.GooglePage.*;

public class SearchFalabella implements Task {
    private final String ecommerce;

    public SearchFalabella(String ecommerce) {
        this.ecommerce = ecommerce;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(INPUT_SEARCH, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
                Enter.theValue(ecommerce).into(INPUT_SEARCH).thenHit(Keys.ENTER),
                Scroll.to(URL),
                Click.on(URL_WEB_SITE)
        );
    }

    public static SearchFalabella searchFalabella(String ecommerce) {
        return Tasks.instrumented(SearchFalabella.class, ecommerce);
    }
}
