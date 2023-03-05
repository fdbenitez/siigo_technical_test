package com.siigo.automation.screenplay.exceptions;

public class ResultNotWaited extends AssertionError {

    private static final long serialVersionUID = 1L;

    public static final String FAILED_PRICE = "No se pudo leer el precio";
    public static final String FAILED_PRODUCT = "El producto no se encontro en la busqueda";
    public static final String WELCOME_MESSAGE = "No se pudo leer el mensaje de bienvenida";

    public ResultNotWaited(String message) {
        super(message);
    }

    public ResultNotWaited(String message, Throwable cause) {
        super(message, cause);
    }
}