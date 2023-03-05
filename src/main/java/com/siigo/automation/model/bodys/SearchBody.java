package com.siigo.automation.model.bodys;

import com.siigo.automation.model.models.users.Users;
import com.siigo.automation.utils.SessionHelper;


public class SearchBody {
    private final Users users;

    private AbstractCreateBody createBody;

    public SearchBody(Users users) {
        this.users = users;
    }

    public void searchBody() {
        createBody = new BodyUsers(users);
    }

    public String generateBody() {
        SessionHelper.setInSession(SessionHelper.SessionData.BODY, createBody.getBody());
        return SessionHelper.getFromSession(SessionHelper.SessionData.BODY);
    }
}
