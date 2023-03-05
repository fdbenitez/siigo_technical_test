package com.siigo.automation.screenplay.questions.regresin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.siigo.automation.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class ValidateGetSingle implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        int userSaved = actor.recall(USER);
        actor.should(
                seeThatResponse(VALIDATE_STATUS_CODE, response -> response.statusCode(SUCCESS_CODE)),
                seeThatResponse(VALIDATE_USER, response -> response.body(ID, is(equalTo(userSaved))))
        );
        return VALIDATE_SUCCEEDED;
    }

    public static ValidateGetSingle user() {
        return new ValidateGetSingle();
    }
}
