# Autor: fray.benitez@ficohsa.com
@Fallabella @Regression
Feature: Cliente Falabella
  Compra de un artículo con garantía extendida en el e-commerce de falabella

  @BuyArticle
  Scenario: Compra de un articulo con garantia extendida.
    Given Que "Fray" es un usuario que navega a la pagina web de google
    When Solicita la compra del articulo: "Nevera LG Congelador Inferior No Frost 420 lt Door Cooling GB41WPP" en la tienda de "Falabella"
    Then Validara el resumen de su compra