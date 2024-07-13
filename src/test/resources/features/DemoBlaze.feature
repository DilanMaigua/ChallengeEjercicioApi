@PruebasDemoblaze
Feature: Prueba de api DemoBlaze

  @test1
  Scenario Outline: Crear un nuevo usuario en signup
    Given que la aplicación esta funcionando
      And inicializo un post en signup
      And agregar la cabecera key: "Content-Type", y valor: "application/json;charset=UTF-8"
      And creo un nuevo usuario con username "<user>" y password "<pass>"
      And ejecuto la creacion de "signup"
      Then valido que la respuesta es 200
      And valido la creacion del usuario


      Examples:
        | user                     | pass    |
        | DilanMaiguaChallengeApi10 | 1545648 |
        | DilanMaiguaChallengeApi10  | 1545648 |

  @test2
  Scenario Outline: Iniciar sesion de usuario en login
    Given que la aplicación esta funcionando
    And inicializo un post en login
    And agregar la cabecera key: "Content-Type", y valor: "application/json;charset=UTF-8"
    And inicio sesion con el username "<user>" y password "<pass>"
    And ejecuto el "login"
    Then valido que la respuesta es 200
    And valido que el usuario se a logiado
    Examples:
      | user                     | pass       |
      | asd                      | aasdassd   |
      | DilanMaiguaChallengeApi10 | 1545648    |
      | DilanMaigua10            | asd        |



