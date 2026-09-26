Feature: Edição de texto no Notepad

  @smoke
  Scenario: Criar um documento e validar seu conteúdo
    Given que o Notepad está aberto
    When eu digito "CT 001 - Teste Desktop"
    And deleto todo o conteúdo do documento
    Then Fecho o Notepad