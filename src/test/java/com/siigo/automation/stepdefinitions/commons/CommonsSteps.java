package com.siigo.automation.stepdefinitions.commons;

import com.siigo.automation.model.models.client.Client;
import com.siigo.automation.screenplay.questions.falabella.ValidatePrice;
import com.siigo.automation.screenplay.questions.falabella.ValidateProduct;
import com.siigo.automation.utils.SessionHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.siigo.automation.utils.Constants.*;
import static com.siigo.automation.utils.PropertyHelper.getAClientFromConfig;
import static com.siigo.automation.utils.SessionHelper.getFromSession;
import static com.siigo.automation.utils.SessionHelper.setInSession;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class CommonsSteps {

    @Given("Que {string} es un usuario de las apis de regresin")
    public void usuarioDeLasApisDeRegresin(String user) {
        Client client;
        OnStage.setTheStage(new OnlineCast());
        setInSession(SessionHelper.SessionData.ACTIVE_CLIENT, getAClientFromConfig(user));
        client = getFromSession(SessionHelper.SessionData.ACTIVE_CLIENT);
        theActorCalled(client.getUser().getFullName());
        theActorInTheSpotlight().whoCan(CallAnApi.at(BASE_URL_API));
    }

    @Then("Validara el resumen de su compra")
    public void validaraElResumenDeSuPrueba() {
        String subtotalSaved = theActorInTheSpotlight().recall(SUBTOTAL_VALUE);
        String productSaved = theActorInTheSpotlight().recall(PRODUCT);
        theActorInTheSpotlight().should(
                seeThat(VALIDATE_PRICE, ValidatePrice.orderStatus(), equalTo(subtotalSaved)),
                seeThat(VALIDATE_PRODUCT, ValidateProduct.orderStatus(), equalTo(productSaved))
        );

    }
}
