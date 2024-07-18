@PruebasDemoblazeApi
Feature: Prueba de api DemoBlaze


  @test1
  Scenario Outline: Crear un nuevo usuario en signup
    Given que la aplicación esta funcionando
    And inicializo un post en signup
    And agregar la cabecera key: "Content-Type", y valor: "application/json;charset=UTF-8"
    And creo un nuevo usuario desde el indice <index> del archivo "<jsonBody>"
    And ejecuto la creacion de "signup"
    Then valido que la respuesta es 200
    And valido la creacion del usuario

    Examples:
      | index | jsonBody |
      | 0     | archivosJson/users.json |
      | 1      | archivosJson/users.json |
  @test2
  Scenario Outline: Iniciar sesion de usuario en login
    Given que la aplicación esta funcionando
    And inicializo un post en login
    And agregar la cabecera key: "Content-Type", y valor: "application/json;charset=UTF-8"
    And inicio sesion desde el indice <index> del archivo "<jsonBody>"
    And ejecuto el "login"
    Then valido que la respuesta es 200
    And valido que el usuario se a logiado
    Examples:
      | index | jsonBody                     |
      |   0    | archivosJson/login.json |
      |   1    | archivosJson/login.json|
      |   2    | archivosJson/login.json |



