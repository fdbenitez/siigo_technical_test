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

  @GetRequest
  Scenario: Consultar un usuario aleatoriamente
    Given Que "Fray" es un usuario de las apis de regresin
    When consulte un usuario en especifico
    Then Validara los datos del usuario

  @GetRequest
  Scenario: Resultados de la consulta no encontrados
    Given Que "Juan" es un usuario de las apis de regresin
    When consulte un id de usuario no registrado
    Then no se encuentran resultados en la busqueda

  @GetRequest
  Scenario: Consultar lista de recursos
    Given Que "Fray" es un usuario de las apis de regresin
    When consulte una lista de recursos
    Then Validara los datos de la lista de recursos

  @GetRequest
  Scenario: Consultar un recurso aleatoriamente
    Given Que "Fray" es un usuario de las apis de regresin
    When consulte un recurso en especifico
    Then Validara los datos del recurso

  @GetRequest
  Scenario: Resultados de la consulta de recursos no encontrados
    Given Que "Juan" es un usuario de las apis de regresin
    When consulte un id de recurso no registrado
    Then no se encuentran resultados en la busqueda

  @PostRequest
  Scenario: Crear usuario aleatoriamente
    Given Que "Fray" es un usuario de las apis de regresin
    When solicite la creacion del usuario
    Then el servicio responde con los datos de usuario creado

  @PutRequest
  Scenario: Actualizar usuario aleatoriamente
    Given Que "Fray" es un usuario de las apis de regresin
    When solicite la actualizacion del usuario
    Then el servicio responde con los datos de usuario actualizado

  @PatchRequest
  Scenario: Actualizar usuario aleatoriamente con metodo patch
    Given Que "Fray" es un usuario de las apis de regresin
    When solicite la actualizacion del usuario a traves del metodo patch
    Then el servicio responde con los datos de usuario actualizado

  @DeleteRequest
  Scenario: Eliminar usuario aleatoriamente
    Given Que "Fray" es un usuario de las apis de regresin
    When solicite la eliminacion del usuario
    Then el servicio elimina los datos de usuario