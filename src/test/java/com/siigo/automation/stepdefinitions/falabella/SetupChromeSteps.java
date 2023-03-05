package com.siigo.automation.stepdefinitions.falabella;

import com.siigo.automation.model.models.client.Client;
import com.siigo.automation.screenplay.task.falabella.*;
import com.siigo.automation.utils.SessionHelper;
import com.siigo.automation.utils.ShadowHandler;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static com.siigo.automation.utils.Constants.*;
import static com.siigo.automation.utils.PropertyHelper.getAClientFromConfig;
import static com.siigo.automation.utils.SessionHelper.getFromSession;
import static com.siigo.automation.utils.SessionHelper.setInSession;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SetupChromeSteps {
    @Managed(driver = "chrome")
    private WebDriver driver;

    @Given("Que {string} es un usuario que navega a la pagina web de google en su navegador chrome")
    public void usuarioNavegaLaWebDeGoogle(String user) {
        Client client;
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(driver)));
        setInSession(SessionHelper.SessionData.ACTIVE_CLIENT, getAClientFromConfig(user));
        client = getFromSession(SessionHelper.SessionData.ACTIVE_CLIENT);
        theActorCalled(client.getUser().getFullName());
        theActorInTheSpotlight().wasAbleTo(Open.url(BASE_URL));
    }


    @When("rechaze los anuncios en la tienda de {string}")
    public void rechaceLosAnuncios(String ecommerce) {
        theActorInTheSpotlight().attemptsTo(SearchFalabella.searchFalabella(ecommerce));
        ShadowHandler.openShadow(driver);
    }

    @When("Solicita la compra del articulo: {string}")
    public void solicitaLaCompraDelArticulo(String article) {
        theActorInTheSpotlight().attemptsTo(
                SearchArticle.inSite(article),
                AddItemsTo.cart(),
                IncreaseItems.onCart(),
                AddWarranty.onItem(),
                GoPayment.onSite()
        );
    }
}
