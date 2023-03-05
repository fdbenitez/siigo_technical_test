# Autor: fray.benitez@ficohsa.com
@Fallabella
Feature: Cliente Falabella
  Compra de un artículo con garantía extendida en el e-commerce de falabella

  @BuyArticle
  Scenario: Compra de un articulo con garantia extendida en chrome
    Given Que "Fray" es un usuario que navega a la pagina web de google en su navegador chrome
    When rechaze los anuncios en la tienda de "Falabella"
    When Solicita la compra del articulo: "Televisor JVC 50 Pulgadas LED 4K HDR Smart TV"
    Then Validara el resumen de su compra

  @BuyArticleFirefox
  Scenario: Compra de un articulo con garantia extendida en firefox
    Given Que "Juan" es un usuario que navega a la pagina web de google en su navegador firefox
    When Solicita la compra del articulo: "Televisor JVC 50 Pulgadas LED 4K HDR Smart TV" en la tienda de "Falabella"
    Then Validara el resumen de su compra