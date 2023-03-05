package com.siigo.automation.stepdefinitions.regresin;

import com.siigo.automation.screenplay.questions.regresin.ValidateGetUsers;
import com.siigo.automation.screenplay.task.regresin.GetRequestService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.siigo.automation.model.models.enums.endpoints.EndPoints.USERS;
import static com.siigo.automation.utils.RandomDataHelper.pageRandom;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegresinSteps {

    @When("consulte una pagina de usuarios aleatoriamente")
    public void usuarioNavegaLaWebDeGoogle() {
        theActorInTheSpotlight().attemptsTo(GetRequestService.requestService(USERS.getUri(), pageRandom()));
    }

    @Then("Validara el estado de la peticion")
    public void validaraElEstadoDeLaPeticion() {
        theActorInTheSpotlight().asksFor(ValidateGetUsers.page());
    }
}
