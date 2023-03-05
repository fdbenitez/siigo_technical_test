package com.siigo.automation.model.models.enums.endpoints;

public enum EndPoints {

    USERS("/api/users"),
    SINGLE_USERS("/api/users/"),
    UNKNOWN("/api/unknown"),
    SINGLE_UNKNOWN("/api/unknown/");
    private final String path;

    EndPoints(String path) {
        this.path = path;
    }

    public String getUri() {
        return path;
    }
}
