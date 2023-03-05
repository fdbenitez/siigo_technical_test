package com.siigo.automation.screenplay.task.regresin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.siigo.automation.utils.Constants.CONTENT_TYPE;
import static com.siigo.automation.utils.Constants.PAGE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetRequestService implements Task {
    private final String nameService;
    private final int page;

    public GetRequestService(String nameService, int page) {
        this.nameService = nameService;
        this.page = page;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(PAGE, page);
        actor.attemptsTo(Get.resource(nameService).with(request -> request.contentType(CONTENT_TYPE)
                .param(PAGE, page)));
    }

    public static GetRequestService requestService(String nameService, int page) {
        return instrumented(GetRequestService.class, nameService, page);
    }

}
