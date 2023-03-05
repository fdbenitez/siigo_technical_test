package com.siigo.automation.screenplay.questions.regresin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.siigo.automation.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class ValidatePostUsers implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String nameSaved = actor.recall(NAME);
        String jobSaved = actor.recall(JOB);
        actor.should(
                seeThatResponse(VALIDATE_STATUS_CODE, response -> response.statusCode(CREATED_CODE)),
                seeThatResponse(VALIDATE_NAME, response -> response.body(NAME, is(equalTo(nameSaved)))),
                seeThatResponse(VALIDATE_JOB, response -> response.body(JOB, is(equalTo(jobSaved))))
        );
        actor.forget(NAME);
        actor.forget(JOB);
        return VALIDATE_SUCCEEDED;
    }

    public static ValidatePostUsers response() {
        return new ValidatePostUsers();
    }
}
