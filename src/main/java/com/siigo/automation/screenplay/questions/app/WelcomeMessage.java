/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.siigo.automation.screenplay.questions.app;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.siigo.automation.screenplay.exceptions.ResultNotWaited.WELCOME_MESSAGE;
import static com.siigo.automation.screenplay.ui.app.HomePage.WELCOME;

public class WelcomeMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        try {
            return WELCOME.resolveFor(actor).getText();
        } catch (Exception ex) {
            return WELCOME_MESSAGE;
        }
    }

    public static WelcomeMessage is() {
        return new WelcomeMessage();
    }

}
