package com.siigo.automation.screenplay.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.siigo.automation.screenplay.ui.FalabellaHomePage.INPUT_SEARCH_ARTICLE;

public class SearchArticle implements Task {
    private final String article;

    public SearchArticle(String article) {
        this.article = article;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(article).into(INPUT_SEARCH_ARTICLE).thenHit(Keys.ENTER)
        );
    }

    public static SearchArticle inSite(String article) {
        return Tasks.instrumented(SearchArticle.class, article);
    }
}
