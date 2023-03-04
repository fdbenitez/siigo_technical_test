package com.siigo.automation.screenplay.questions;

import com.siigo.automation.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.siigo.automation.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Slf4j
public class ValidateSucceeded implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(VALIDATE_STATUS_CODE, response -> response.statusCode(Constants.SUCCESS_CODE)),
                seeThatResponse(VALIDATE_SUCCEEDED, response -> response.body(SUCCEEDED, is(equalTo(true)))));
        return VALIDATE_SUCCESS_FULL;
    }

    public static ValidateSucceeded validateSucceeded() {
        return new ValidateSucceeded();
    }
}
