package com.siigo.automation.screenplay.questions.regresin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.siigo.automation.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class ValidateGetResource implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(VALIDATE_STATUS_CODE, response -> response.statusCode(SUCCESS_CODE))
        );
        return VALIDATE_SUCCEEDED;
    }

    public static ValidateGetResource page() {
        return new ValidateGetResource();
    }
}
