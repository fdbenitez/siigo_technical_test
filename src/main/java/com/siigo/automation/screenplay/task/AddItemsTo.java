package com.siigo.automation.screenplay.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.siigo.automation.screenplay.ui.FalabellaHomePage.INPUT_SEARCH_ARTICLE;

public class AddItemsTo implements Task {
    private final String article;

    public AddItemsTo(String article) {
        this.article = article;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Target.the("Item").located(By.partialLinkText("AGREGAR")))
        );
    }

    public static AddItemsTo cart(String article) {
        return Tasks.instrumented(AddItemsTo.class, article);
    }
}
