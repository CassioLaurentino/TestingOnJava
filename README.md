### Ferramentas utilizadas

* Intellij IDE
* Java 17
* Spring Boot
* Maven
* Junit Jupiter
* Mockito
* Google bean-matchers
* Jacoco
* Pitest

Todas as dependencias e versões utilizadas podem ser encontradas no arquivo de configuração do maven **pom.xml**

### Conceitos Básicos:

- **O que são testes?**
    - Testes são verificações sistemáticas de partes específicas (ou do todo) de um software. Seu objetivo é identificar erros, incompatibilidades ou qualquer outra falha que possa surgir durante a execução do software.

- **Diferença entre testes unitários, de mutação e de componente**:
    - **Testes unitários**: Verificam a menor parte testável de um software, geralmente um método ou função, isoladamente.
    - **Testes de mutação**: Avalia a qualidade dos testes unitários, em teoria não há implementação extra.
    - **Testes de componente**: Avalia o comportamento do software como um todo, garantindo que todos os requisitos sejam atendidos e que o software funcione corretamente no ambiente em que será executado.

### Por que testes unitários são importantes:

- **Garantir que o código funciona como esperado**:
    - Testes unitários certificam-se de que cada parte do software funciona corretamente e cumpre o seu propósito.

- **Evitar regressões**:
    - Regressões são erros que surgem após alterações no código. Testes unitários, quando executados regularmente, podem identificar rapidamente quando uma nova mudança no código quebra funcionalidades previamente estabelecidas.

- **Facilitar refatorações**:
    - Quando temos um conjunto abrangente de testes, é mais seguro fazer alterações no código, pois os testes vão alertar se alguma parte do software parou de funcionar corretamente após a refatoração.

### Testes de Mutação:

- **O que são e para que servem?**:
    - Testes de mutação aplica uma técnica que modifica o código-fonte de pequenas maneiras (criando "mutantes") e, em seguida, executa os testes unitários para verificar se eles detectam e "matam" essas mutações.

- **Conceito de "kill mutants"**:
    - "Matar" um mutante significa que os testes detectaram a mudança e falharam, o que é bom. Se os testes passarem mesmo com o código sendo modificado (mutado), isso pode indicar uma deficiência nos testes.

### Conclusão:

Em suma, o objetivo deste workshop é familiarizar os participantes com a importância e a prática de testes unitários e testes de mutação no desenvolvimento de software, proporcionando-lhes as ferramentas e conhecimentos necessários para aplicá-los em seus próprios projetos.