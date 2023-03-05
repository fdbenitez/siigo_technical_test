package com.siigo.automation.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.configuration.SystemPropertiesConfiguration;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.asynchttpclient.request.body.Body;

import java.io.File;
import java.nio.file.Paths;

public class Constants {
    private Constants() {
        super();
    }
    public static final int SUCCESS_CODE = 200;
    public static final int RESOURCE_NOT_FOUNT = 404;
    public static final String SUBTOTAL_VALUE = "subtotal";
    public static final String PRODUCT = "product";
    public static final String VALIDATE_PRICE = "El precio es: ";
    public static final String VALIDATE_PRODUCT = "El producto seleccionado es: ";
    public static final String VALIDATE_PAGE = "Validar page";
    public static final String VALIDATE_USER = "Validar user";
    public static final String VALIDATE_STATUS_CODE = "Validar statusCode";
    public static final String VALIDATE_SUCCEEDED = "Validación exitosa";
    public static final String CONTENT_TYPE = "application/json";
    public static final String PAGE = "page";
    public static final String USER = "user";
    public static final String ID = "data.id";
    private static final SystemPropertiesConfiguration CONFIGURATION = new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
    private static final EnvironmentVariables environmentVariables = CONFIGURATION.getEnvironmentVariables();
    private static final String CONFIG_PATH = Paths.get(new File("").getAbsolutePath(), "src", "test", "resources").toString();
    public static final String USERS_PATH = Paths.get(CONFIG_PATH, EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("users.file")).toString();

    public static final String BASE_URL = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url");
    public static final String BASE_URL_API = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("baseapi.url");
}
