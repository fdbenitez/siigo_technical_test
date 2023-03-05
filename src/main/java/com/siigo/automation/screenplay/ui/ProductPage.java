package com.siigo.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {

    public static final Target CART = Target.the("Agregar a la bolsa").locatedBy("#add-to-cart-button");
    public static final Target SEE_CART = Target.the("Ver bolsa de compras").locatedBy("#linkButton");
    public static final Target INCREASE = Target.the("Incrementar articulo").locatedBy("//button[@class='increase']");
    public static final Target WARRANTY = Target.the("Incluir garantia").locatedBy("//a[@class='fb-warranty-dropdown fb-inline-dropdown__link js-inline-dropdown__link']");
    public static final Target WARRANTY_EXTEND = Target.the("Agregar garantia").locatedBy("//a[contains(text(),'Extendida')]");
    public static final Target GO_PAYMENT = Target.the("Ir a comprar").locatedBy("//button[contains(text(),'Ir a comprar')]");
    public static final Target SUBTOTAL = Target.the("Sub total").locatedBy("//span[@class='fb-order-status__sub-totals__value notranslate undefined']");

}
