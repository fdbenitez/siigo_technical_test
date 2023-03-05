package com.siigo.automation.stepdefinitions.regresin;

import com.siigo.automation.screenplay.questions.regresin.ValidateGetResource;
import com.siigo.automation.screenplay.questions.regresin.ValidateGetSingle;
import com.siigo.automation.screenplay.questions.regresin.ValidateGetUsers;
import com.siigo.automation.screenplay.task.regresin.GetPageUser;
import com.siigo.automation.screenplay.task.regresin.GetResource;
import com.siigo.automation.screenplay.task.regresin.GetSingle;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.siigo.automation.model.models.enums.endpoints.EndPoints.*;
import static com.siigo.automation.utils.RandomDataHelper.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegresinSteps {

    @When("consulte una pagina de usuarios aleatoriamente")
    public void usuarioNavegaLaWebDeGoogle() {
        theActorInTheSpotlight().attemptsTo(GetPageUser.request(USERS.getUri(), pageRandom()));
    }

    @When("consulte un usuario en especifico")
    public void consulteUnUsuarioEnEspecifico() {
        theActorInTheSpotlight().attemptsTo(GetSingle.request(SINGLE_USERS.getUri(), singleUserRandom()));
    }

    @When("consulte un id de usuario no registrado")
    public void consulteUnIdDeUsuarioNoRegistrado() {
        theActorInTheSpotlight().attemptsTo(GetSingle.request(SINGLE_USERS.getUri(), singleUserIdRandom()));
    }

    @When("consulte una lista de recursos")
    public void consulteUnaListaDeRecursos() {
        theActorInTheSpotlight().attemptsTo(GetResource.request(UNKNOWN.getUri()));
    }

    @When("consulte un recurso en especifico")
    public void consulteUnRecursoEnEspecifico() {
        theActorInTheSpotlight().attemptsTo(GetSingle.request(SINGLE_UNKNOWN.getUri(), singleUserRandom()));
    }

    @When("consulte un id de recurso no registrado")
    public void consulteUnRecursoNoRegistrado() {
        theActorInTheSpotlight().attemptsTo(GetSingle.request(SINGLE_UNKNOWN.getUri(), singleUserIdRandom()));
    }

    @Then("Validara el estado de la peticion")
    public void validaraElEstadoDeLaPeticion() {
        theActorInTheSpotlight().asksFor(ValidateGetUsers.page());
    }

    @Then("Validara los datos del usuario")
    public void validaraLosDatosDelUsuario() {
        theActorInTheSpotlight().asksFor(ValidateGetSingle.user());
    }

    @Then("Validara los datos del recurso")
    public void validaraLosDatosDelRecurso() {
        theActorInTheSpotlight().asksFor(ValidateGetSingle.user());
    }

    @Then("Validara los datos de la lista de recursos")
    public void validaraLosDatosDeLaListaDeRecursos() {
        theActorInTheSpotlight().asksFor(ValidateGetResource.page());
    }
}
