package com.siigo.automation.screenplay.task.regresin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.siigo.automation.utils.Constants.CONTENT_TYPE;
import static com.siigo.automation.utils.Constants.USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetResource implements Task {
    private final String nameService;

    public GetResource(String nameService) {
        this.nameService = nameService;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(nameService).with(request -> request.contentType(CONTENT_TYPE)));
    }

    public static GetResource request(String nameService) {
        return instrumented(GetResource.class, nameService);
    }

}
