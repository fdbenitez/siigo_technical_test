package com.siigo.automation.utils;

import net.serenitybdd.core.Serenity;

public class SessionHelper {

    public static <T> T getFromSession(SessionData key) {
        return Serenity.sessionVariableCalled(key.value);
    }

    public static <T> void setInSession(SessionData key, T value) {
        Serenity.setSessionVariable(key.value).to(value);
    }

    public enum SessionData {
        ACTIVE_CLIENT("activeClient"),
        BODY("bodyRequest");

        private final String value;

        SessionData(String value) {
            this.value = value;
        }
    }
}

