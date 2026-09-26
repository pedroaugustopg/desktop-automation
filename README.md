# Automação Desktop com Java, Cucumber e BDD

Projeto de automação desktop desenvolvido em **Java**, utilizando **Maven**, **Cucumber** e a abordagem **BDD (Behavior-Driven Development)**.

O projeto automatiza operações básicas no **Windows Notepad**, utilizando a classe `java.awt.Robot` para simular interações de teclado.

## Objetivo

Automatizar o seguinte fluxo no Notepad:

1. Abrir o Notepad.
2. Digitar um texto definido no cenário BDD.
3. Selecionar todo o conteúdo.
4. Excluir o conteúdo.
5. Fechar o Notepad.

Texto utilizado no cenário:

```text
CT 001 - Teste Desktop
```

## Tecnologias

* Java
* Maven
* Cucumber
* JUnit
* Gherkin
* BDD
* Java AWT Robot
* Windows Notepad

## Estrutura do projeto

```text
src
├── test
│   ├── java
│   │   └── tests
│   │       ├── pages
│   │       │   └── NotepadPageTest.java
│   │       ├── steps
│   │       │   └── NotepadStepsTest.java
│   │       └── runner
│   │           └── RunnerTest.java
│   │
│   └── resources
│       └── features
│           └── notepad.feature
│
└── pom.xml
```

## Abordagem BDD

Os comportamentos são definidos utilizando **Gherkin**, mantendo a especificação do teste separada da implementação.

Exemplo:

```gherkin
Feature: Edição de texto no Notepad

  @smoke
  Scenario: Criar um documento e validar seu conteúdo
    Given que o Notepad está aberto
    When eu digito "CT 001 - Teste Desktop"
    And deleto todo o conteúdo do documento
    Then Fecho o Notepad
```

## Implementação

Os Steps do Cucumber fazem a ligação entre o cenário e os métodos de automação:

```java
@When("eu digito {string}")
public void typeText(String text) {
    notepad.typeText(text);
}
```

A interação com o sistema operacional é realizada através do `Robot`:

```java
public void typeText(String text) {
    for (char character : text.toCharArray()) {
        // Simulação das teclas através do Robot
    }
}
```

A classe `NotepadPageTest` concentra as ações relacionadas ao Notepad, enquanto `NotepadStepsTest` é responsável pela implementação dos passos definidos no cenário.

## Execução

### Pré-requisitos

* Windows
* Java JDK instalado
* Maven instalado
* Notepad disponível no sistema

### Executar os testes

Na raiz do projeto:

```bash
mvn test
```

O Cucumber executará o Runner configurado e iniciará o cenário de automação do Notepad.

## Conceitos praticados

* Automação de aplicações desktop
* BDD
* Cucumber
* Gherkin
* Testes automatizados com Java
* Maven
* JUnit
* Simulação de teclado com `java.awt.Robot`
* Separação entre Steps e camada de automação
* Automação baseada em comportamento

## Observações

Este projeto utiliza `java.awt.Robot`, portanto a execução depende de uma sessão gráfica do Windows ativa.

A automação interage diretamente com a interface do sistema operacional e, por isso, fatores como foco da janela e estado das teclas podem afetar a execução.
