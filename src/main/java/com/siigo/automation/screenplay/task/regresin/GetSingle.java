package com.siigo.automation.screenplay.task.regresin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.siigo.automation.utils.Constants.CONTENT_TYPE;
import static com.siigo.automation.utils.Constants.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetSingle implements Task {
    private final String nameService;
    private final int userId;

    public GetSingle(String nameService, int userId) {
        this.nameService = nameService;
        this.userId = userId;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(USER, userId);
        actor.attemptsTo(Get.resource(nameService+userId).with(request -> request.contentType(CONTENT_TYPE)));
    }

    public static GetSingle request(String nameService, int userId) {
        return instrumented(GetSingle.class, nameService, userId);
    }

}
