package com.siigo.automation.stepdefinitions.falabella;

import com.siigo.automation.model.models.client.Client;
import com.siigo.automation.screenplay.task.app.NavigateTo;
import com.siigo.automation.utils.SessionHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static com.siigo.automation.utils.PropertyHelper.getAClientFromConfig;
import static com.siigo.automation.utils.SessionHelper.getFromSession;
import static com.siigo.automation.utils.SessionHelper.setInSession;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SetupAndroidSteps {
    @Managed(driver = "appium")
    private WebDriver driver;


    @Given("Que {string} es un usuario que navega en la app")
    public void usuarioNavegaLaApp(String user) {
        Client client;
        setInSession(SessionHelper.SessionData.ACTIVE_CLIENT, getAClientFromConfig(user));
        client = getFromSession(SessionHelper.SessionData.ACTIVE_CLIENT);
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(client.getUser().getFullName());
    }

    @When("ingreso al modulo triangulo")
    public void solicitaLaCompraDelArticulo() {
        theActorInTheSpotlight().attemptsTo(
                NavigateTo.TrianguleModule()
        );
    }
}
