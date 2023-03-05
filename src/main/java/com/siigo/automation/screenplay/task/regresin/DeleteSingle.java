package com.siigo.automation.screenplay.task.regresin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static com.siigo.automation.utils.Constants.CONTENT_TYPE;
import static com.siigo.automation.utils.Constants.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteSingle implements Task {
    private final String nameService;
    private final int userId;

    public DeleteSingle(String nameService, int userId) {
        this.nameService = nameService;
        this.userId = userId;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(USER, userId);
        actor.attemptsTo(Delete.from(nameService + userId).with(request -> request.contentType(CONTENT_TYPE)));
    }

    public static DeleteSingle request(String nameService, int userId) {
        return instrumented(DeleteSingle.class, nameService, userId);
    }

}
