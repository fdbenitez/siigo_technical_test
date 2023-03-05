package com.siigo.automation.screenplay.task.regresin;

import com.siigo.automation.model.bodys.SearchBody;
import com.siigo.automation.model.models.users.Users;
import com.siigo.automation.utils.RandomDataHelper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static com.siigo.automation.utils.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PatchUsers implements Task {
    private final String nameService;
    private final int userId;

    public PatchUsers(String nameService, int userId) {
        this.nameService = nameService;
        this.userId = userId;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String job = RandomDataHelper.getJobRandom();
        String name = RandomDataHelper.getNameRandom();
        Users users = new Users(name, job);
        actor.remember(JOB, job);
        actor.remember(NAME, name);
        SearchBody body = new SearchBody(users);
        body.searchBody();
        actor.attemptsTo(
                Patch.to(nameService + userId).with(request -> request.contentType(CONTENT_TYPE).body(body.generateBody()))
        );
    }

    public static PatchUsers request(String nameService, int userId) {
        return instrumented(PatchUsers.class, nameService, userId);
    }

}
