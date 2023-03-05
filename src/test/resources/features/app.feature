# Autor: ingfray@gmail.com
@App
Feature: Reto Siigo
  test simple en una app

  @Triangle
  Scenario: validar login en android
    Given Que "Fray" es un usuario que navega en la app
    When ingreso al modulo triangulo
    Then Se debe mostrar el mensaje de bienvenida