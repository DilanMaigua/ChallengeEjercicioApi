@PruebasDemoblazeApi
Feature: Prueba de api DemoBlaze


  @test1
  Scenario Outline: Crear un nuevo usuario en signup <user> y <pass>
    Given que la aplicación esta funcionando
    And inicializo un post en signup
    And agregar la cabecera key: "Content-Type", y valor: "application/json;charset=UTF-8"
    And creo un nuevo usuario "<jsonBody>"
    And ejecuto la creacion de "signup"
    Then valido que la respuesta es 200
    And valido la creacion del usuario

    Examples:
      | jsonBody                     |
      | {\"user\": \"Dilan\", \"pass\": \"312120\"} |
      | {\"user\": \"DilAnChallengeNttData\", \"pass\": \"312120\"} |



  @test2
  Scenario Outline: Iniciar sesion de usuario en login
    Given que la aplicación esta funcionando
    And inicializo un post en login
    And agregar la cabecera key: "Content-Type", y valor: "application/json;charset=UTF-8"
    And inicio sesion "<jsonBody>"
    And ejecuto el "login"
    Then valido que la respuesta es 200
    And valido que el usuario se a logiado
    Examples:
      | jsonBody                     |
      | {\"user\": \"Dilan\", \"pass\": \"312120\"} |
      | {\"user\": \"DilAnChallengeNttData\", \"pass\": \"312120\"} |
      | {\"user\": \"DilAnChallengeNttDataasdaweqfasdfq\", \"pass\": \"312120\"} |



