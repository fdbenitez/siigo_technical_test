package com.siigo.automation.screenplay.questions.regresin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.siigo.automation.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ResourceNotFound implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(VALIDATE_STATUS_CODE, response -> response.statusCode(RESOURCE_NOT_FOUNT))
        );
        return VALIDATE_SUCCEEDED;
    }

    public static ResourceNotFound validate() {
        return new ResourceNotFound();
    }
}
