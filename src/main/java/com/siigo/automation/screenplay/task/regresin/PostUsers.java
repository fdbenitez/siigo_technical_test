package com.siigo.automation.screenplay.task.regresin;

import com.siigo.automation.model.bodys.SearchBody;
import com.siigo.automation.model.models.users.Users;
import com.siigo.automation.utils.RandomDataHelper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.siigo.automation.utils.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostUsers implements Task {
    private final String nameService;

    public PostUsers(String nameService) {
        this.nameService = nameService;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String job= RandomDataHelper.getJobRandom();
        String name= RandomDataHelper.getNameRandom();
        Users users = new Users(name, job);
        actor.remember(JOB, job);
        actor.remember(NAME, name);
        SearchBody body = new SearchBody(users);
        body.searchBody();
        actor.attemptsTo(
                Post.to(nameService).with(request -> request.contentType(CONTENT_TYPE).body(body.generateBody()))
        );
    }

    public static PostUsers request(String nameService) {
        return instrumented(PostUsers.class, nameService);
    }

}
