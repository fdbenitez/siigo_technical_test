package com.siigo.automation.screenplay.task.regresin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.siigo.automation.utils.Constants.CONTENT_TYPE;
import static com.siigo.automation.utils.Constants.PAGE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPageUser implements Task {
    private final String nameService;
    private final int page;

    public GetPageUser(String nameService, int page) {
        this.nameService = nameService;
        this.page = page;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(PAGE, page);
        actor.attemptsTo(Get.resource(nameService).with(request -> request.contentType(CONTENT_TYPE)
                .param(PAGE, page)));
    }

    public static GetPageUser request(String nameService, int page) {
        return instrumented(GetPageUser.class, nameService, page);
    }

}
