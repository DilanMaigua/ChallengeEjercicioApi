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
        | user              | pass |
        | Dil544addas5Maa | 1545648 |
        | Dil544addas5Maa | 1545648 |





