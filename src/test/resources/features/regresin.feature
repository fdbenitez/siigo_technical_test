# Autor: ingfray@gmail.com
@Regresin
Feature: CRUD Regresin
  se requiere realizar el proceso de CRUD para
  usuarios realizando las validaciones de respuesta pertinentes.

  @GetRequest
  Scenario: Consultar una pagina de usuarios
    Given Que "Fray" es un usuario de las apis de regresin
    When consulte una pagina de usuarios aleatoriamente
    Then Validara el estado de la peticion