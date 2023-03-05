package com.siigo.automation.stepdefinitions.falabella;

import com.siigo.automation.screenplay.questions.ValidateProduct;
import com.siigo.automation.screenplay.questions.ValidatePrice;
import io.cucumber.java.en.Then;

import static com.siigo.automation.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class CommonsSteps {

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
