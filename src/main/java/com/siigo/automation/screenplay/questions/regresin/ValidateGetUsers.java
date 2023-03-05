package com.siigo.automation.screenplay.questions.regresin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.siigo.automation.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class ValidateGetUsers implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        int pageSaved=actor.recall(PAGE);
        actor.should(
                seeThatResponse(VALIDATE_STATUS_CODE, response -> response.statusCode(SUCCESS_CODE)),
                seeThatResponse(VALIDATE_PAGE, response -> response.body(PAGE, is(equalTo(pageSaved))))
        );
        return VALIDATE_SUCCEEDED;
    }

    public static ValidateGetUsers page() {
        return new ValidateGetUsers();
    }
}
