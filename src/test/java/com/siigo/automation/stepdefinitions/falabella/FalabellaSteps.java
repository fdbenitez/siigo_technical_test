package com.siigo.automation.stepdefinitions.falabella;

import com.siigo.automation.model.models.client.Client;
import com.siigo.automation.utils.SessionHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import static com.siigo.automation.utils.Constants.BASE_URL;
import static com.siigo.automation.utils.PropertyHelper.getAClientFromConfig;
import static com.siigo.automation.utils.SessionHelper.getFromSession;
import static com.siigo.automation.utils.SessionHelper.setInSession;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FalabellaSteps {
    private Client client;

    @Given("Que {string} es un usuario que navega a la pagina web de google")
    public void usuarioNavegaLaWebDeGoogle(String user) {
        setInSession(SessionHelper.SessionData.ACTIVE_CLIENT, getAClientFromConfig(user));
        client = getFromSession(SessionHelper.SessionData.ACTIVE_CLIENT);
        theActorCalled(client.getUser().getFullName());
        theActorInTheSpotlight().wasAbleTo(Open.url(BASE_URL));
    }

    @When("Solicita la compra del articulo: {string} en la tienda de {string}")
    public void solicitaLaCompraDelArticulo(String article, String ecommerce) {

    }

    @Then("Validara el resumen de su compra")
    public void validaraElResumenDeSuPrueba() {

    }
}
