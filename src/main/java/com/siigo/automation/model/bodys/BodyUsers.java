package com.siigo.automation.model.bodys;
import com.siigo.automation.model.models.users.Users;
import com.siigo.automation.utils.JsonHelper;

import static com.siigo.automation.model.models.enums.endpoints.EndPoints.USERS;

public class BodyUsers extends AbstractCreateBody {

    private final Users users;
    public BodyUsers(Users users) {
        super(USERS.getUri());
        this.users = users;
    }
    @Override
    public String getBody() {
        Users usersBody =
                Users.builder()
                        .name(users.getName())
                        .job(users.getJob())
                        .build();
        return JsonHelper.convertToJSON(usersBody);
    }
}
