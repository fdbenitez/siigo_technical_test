package com.siigo.automation.model.models.enums.endpoints;

public enum EndPoints {

    USERS("/api/users");
    private final String path;

    EndPoints(String path) {
        this.path = path;
    }

    public String getUri() {
        return path;
    }
}
