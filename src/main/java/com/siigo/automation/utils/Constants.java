package com.siigo.automation.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.configuration.SystemPropertiesConfiguration;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

import java.io.File;
import java.nio.file.Paths;

public class Constants {
    private Constants() {
        super();
    }
    public static final int SUCCESS_CODE = 200;
    public static final String SUCCEEDED = "succeeded";
    public static final String VALIDATE_STATUS_CODE = "Validate statusCode";
    public static final String VALIDATE_SUCCEEDED = "Validate succeeded";
    public static final String VALIDATE_SUCCESS_FULL = "Validación exitosa";
    private static final SystemPropertiesConfiguration CONFIGURATION = new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
    private static final EnvironmentVariables environmentVariables = CONFIGURATION.getEnvironmentVariables();
    private static final String CONFIG_PATH = Paths.get(new File("").getAbsolutePath(), "src", "test", "resources").toString();
    public static final String USERS_PATH = Paths.get(CONFIG_PATH, EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("users.file")).toString();

    public static final String BASE_URL = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url");
}
