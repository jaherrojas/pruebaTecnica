Feature: Registro de nuevos usuarios en la página Product Store

  @Caso1
  Scenario: Registrar un nuevo usuario exitosamente
    Given que el usuario esta en la pagina principal de Product Store
    When el usuario hace clic en Sign Up
    And el usuario ingresa sus credenciales
    Then el sistema muestra el mensaje Registro exitoso