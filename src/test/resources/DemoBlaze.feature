Feature: Crear un nuevo usuario en signup

  Background:
    * url 'https://api.demoblaze.com/'
    * def jsonBody = read('archivosJson/users.json').examples

  Scenario Outline: Crear un nuevo usuario en signup
    Given path 'signup'
    And request { username: '#(jsonBody[<index>].user)', password: '#(jsonBody[<index>].pass)' }
    And print { username: jsonBody[<index>].user, password: jsonBody[<index>].pass }
    And header Content-Type = 'application/json;charset=UTF-8'
    When method post
    Then status 200
    And match response != { errorMessage: "This user already exist." }
    Examples:
      | index |
      | 0     |

  Scenario Outline: Intentar crear un usuario existente
    Given path 'signup'
    And request { username: '#(jsonBody[<index>].user)', password: '#(jsonBody[<index>].pass)' }
    And print { username: jsonBody[<index>].user, password: jsonBody[<index>].pass }
    And header Content-Type = 'application/json;charset=UTF-8'
    When method post
    Then status 200
    And match response == { errorMessage: "This user already exist." }
    Examples:
      | index |
      | 1     |

  Scenario Outline: Usuario y password correcto en login
    Given path 'login'
    And request { username: '#(jsonBody[<index>].user)', password: '#(jsonBody[<index>].pass)' }
    And print { username: jsonBody[<index>].user, password: jsonBody[<index>].pass }
    And header Content-Type = 'application/json;charset=UTF-8'
    When method post
    Then status 200
    And print response
    And match response != { errorMessage: "Wrong password." }
    And match response != { errorMessage: "User does not exist." }
    Examples:
      | index |
      | 1     |

  Scenario Outline: Usuario y password incorrecto en login
    Given path 'login'
    And request { username: '#(jsonBody[<index>].user)', password: '#(jsonBody[<index>].pass)' }
    And print { username: jsonBody[<index>].user, password: jsonBody[<index>].pass }
    And header Content-Type = 'application/json;charset=UTF-8'
    When method post
    Then status 200
    And match response == { errorMessage: "Wrong password." }
    Examples:
      | index |
      | 2     |
