package com.siigo.automation.screenplay.ui.app;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target TRIANGLE= Target.the("Triangulo").locatedBy("#triangle-id");

    public static final Target WELCOME= Target.the("Bienvenido").locatedBy("#bienvenido");
}
