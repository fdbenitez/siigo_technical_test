package com.siigo.automation.stepdefinitions.falabella;

import com.siigo.automation.model.models.client.Client;
import com.siigo.automation.screenplay.task.AddItemsTo;
import com.siigo.automation.screenplay.task.SearchArticle;
import com.siigo.automation.screenplay.task.SearchFalabella;
import com.siigo.automation.utils.SessionHelper;
import com.siigo.automation.utils.ShadowHandler;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static com.siigo.automation.utils.Constants.BASE_URL;
import static com.siigo.automation.utils.PropertyHelper.getAClientFromConfig;
import static com.siigo.automation.utils.SessionHelper.getFromSession;
import static com.siigo.automation.utils.SessionHelper.setInSession;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FalabellaSteps {
    @Managed(driver = "chrome")
    private WebDriver driver;

    @Before
    public void config() {
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(driver)));
    }

    @Given("Que {string} es un usuario que navega a la pagina web de google")
    public void usuarioNavegaLaWebDeGoogle(String user) {
        Client client;
        setInSession(SessionHelper.SessionData.ACTIVE_CLIENT, getAClientFromConfig(user));
        client = getFromSession(SessionHelper.SessionData.ACTIVE_CLIENT);
        theActorCalled(client.getUser().getFullName());
        theActorInTheSpotlight().wasAbleTo(Open.url(BASE_URL));
    }

    @When("Solicita la compra del articulo: {string} en la tienda de {string}")
    public void solicitaLaCompraDelArticulo(String article, String ecommerce) {
        theActorInTheSpotlight().attemptsTo(SearchFalabella.searchFalabella(ecommerce));
        ShadowHandler.openShadow(driver);
        theActorInTheSpotlight().attemptsTo(
                SearchArticle.inSite(article),
                AddItemsTo.cart(article)
        );
    }

    @Then("Validara el resumen de su compra")
    public void validaraElResumenDeSuPrueba() {

    }
}
