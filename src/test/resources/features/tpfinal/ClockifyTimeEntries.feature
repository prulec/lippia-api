#@TPFinal @TimeEntries
#Feature: Time Entries CRUD

#  @Now
#  Scenario Outline: Consulta Workspace resultado exitoso
#    Given Mi cuenta creada en clockify y mi X-Api-Key generada
#    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
#    And se obtuvo el status code <status>
#    Then Obtengo los datos de mi Workspace
#    @Workspace
#    Examples:
#      | operation | entity    | jsonName     | status |
#      | GET       | WORKSPACE | workspace/rq | 200    |
#
#  Scenario Outline: Consulta Workspace resultado erroneo
#    Given X-Api-Key invalido
#    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
#    Then se obtuvo el status code <status>
#    @Workspace
#    Examples:
#      | operation | entity | jsonName     | status |
#      | GET       | ERROR  | workspace/rq | 401    |
#
#  # Ej 4.1
#  @prueba @Projects @Success
#  Scenario Outline: Consulta Projects exitosa
#    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and 'workspaceId:63549dfa28051215c2f08293'
#    Then se obtuvo el status code <status>
#    @Workspace
#    Examples:
#      | operation | entity  | jsonName   | status |
#      | GET       | PROJECT | project/rq | 200    |
#
#  # Ej 4.2
#  @prueba @Projects @Unauthorized
#  Scenario Outline: Consulta Projects no autorizada
#    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and 'workspaceId:63549dfa28051215c2f08293'
#    And se obtuvo el status code <status>
#    Then se obtuvo el response esperado en <entity> con el <response>
#    @Workspace
#    Examples:
#      | operation | entity | jsonName       | response       | status |
#      | GET       | ERROR  | project/rq_401 | project/rs_401 | 401    |
#
#  # Ej 4.3 - Proyecto no existente (400) - el 404 no fue posible obtenerlo
#  @prueba @Project @BadRequest
#  Scenario Outline: Consulta Project por ID exitosa
#    Given Mi cuenta creada en clockify y mi X-Api-Key generada
#    And un workspaceId
#    And un Project ID inexistente
#    And I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
#    Then se obtuvo el status code <status>
#    @Workspace
#    Examples:
#      | operation | entity       | jsonName        | status |
#      | GET       | PROJECT_ITEM | project/rq_byID | 400    |
#
#  # Ej 5.1
#  @prueba @Project @Success
#  Scenario Outline: Consulta Project por ID exitosa
#    Given Mi cuenta creada en clockify y mi X-Api-Key generada
#    And un workspaceId
#    When I perform a '<operation>' to '<entity1>' endpoint with the '<jsonName1>' and ''
#    And se obtuvo un Project ID
#    And I perform a '<operation>' to '<entity2>' endpoint with the '<jsonName2>' and ''
#    Then se obtuvo el status code <status>
#    @Workspace
#    Examples:
#      | operation | entity1 | entity2      | jsonName1  | jsonName2       | status |
#      | GET       | PROJECT | PROJECT_ITEM | project/rq | project/rq_byID | 200    |
#
#  # Ej 5.2
#  @prueba @Project @Update @Success
#  Scenario Outline: Actualizacion del Name de un Project exitosa
#    Given Mi cuenta creada en clockify y mi X-Api-Key generada
#    And un workspaceId
#    And un timestamp del momento actual para concatenar al Name a modificar
#    When I perform a 'GET' to 'PROJECT' endpoint with the 'project/rq' and ''
#    And se obtuvo los datos del Project
#    And I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
#    And se obtuvo el status code <status>
#    And I perform a 'GET' to 'PROJECT_ITEM' endpoint with the 'project/rq_byID' and ''
#    Then se obtuvo el status code 200
#    And se valida que el Name fue modificado correctamente
#    Examples:
#      | operation | entity       | jsonName       | status |
#      | PUT       | PROJECT_ITEM | project/rq_put | 200    |
