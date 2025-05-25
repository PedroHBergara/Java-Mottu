# API REST - Gerenciamento de Filiais e Pátios

##Este projeto foi desenvolvido pelos aluno:

   **Pedro Henrique Bergara RM556639**
   **Henrique Izzi de São José RM555413**
   
Esta API faz parte de um projeto de mapeamento de filiais e patios, a nossa solução tem como ideia principal ter controle das motos sendo assim localizando elas por chegada a filial e separando ele na area dentro do patio.

## 1. Visão Geral do Projeto

O objetivo principal desta API é fornecer endpoints para realizar operações CRUD (Create, Read, Update, Delete) nas entidades `Filial` e `Patio`, considerando o relacionamento entre elas (uma Filial pode ter muitos Pátios).

O desenvolvimento seguiu uma arquitetura em camadas bem definida:

*   **Controller:** Responsável por expor os endpoints REST, receber requisições HTTP, validar dados de entrada e interagir com a camada de Serviço.
*   **Service:** Contém a lógica de negócio principal, orquestrando as operações, utilizando Repositories e Mappers.
*   **Repository:** Interface responsável pela comunicação com o banco de dados, utilizando Spring Data JPA.
*   **Model:** Define as entidades JPA (`Filial`, `Patio`) que representam as tabelas no banco de dados.
*   **DTO (Data Transfer Object):** Objetos utilizados para transferir dados entre as camadas (principalmente entre Controller e Service) e para definir a estrutura dos dados nas requisições e respostas da API. Inclui validações.
*   **Mapper:** Classes utilitárias para converter entre Entidades (Model) e DTOs.
*   **Exception:** Camada para tratamento centralizado de exceções, garantindo respostas de erro padronizadas.

## 2. Tecnologias Utilizadas

*   **Linguagem:** Java 17 (ou superior)
*   **Framework:** Spring Boot 3.x
*   **Módulos Spring:**
    *   Spring Web: Para criação da API REST.
    *   Spring Data JPA: Para persistência de dados.
    *   Spring Validation: Para validação dos dados de entrada (DTOs).
*   **Banco de Dados:** H2 (Banco de dados em memória, ideal para desenvolvimento e testes)
*   **Build Tool:** Maven
*   **Documentação:** SpringDoc OpenAPI (Swagger UI)
*   **Persistência:** JPA / Hibernate

## 3. Funcionalidades Implementadas

*   **CRUD Completo:** Operações de Criar, Ler (individual e lista paginada), Atualizar e Deletar para as entidades `Filial` e `Patio`.
*   **Relacionamento:** Implementado relacionamento One-to-Many entre `Filial` e `Patio`.
*   **Validação:** Validação dos dados de entrada nos DTOs usando Bean Validation (`@Valid`, `@NotBlank`, `@NotNull`, etc.).
*   **Paginação e Ordenação:** Listagem de entidades com suporte a paginação e ordenação via parâmetros na URL (usando `Pageable` do Spring Data).
*   **Busca por Parâmetros:**
    *   Filtragem de Filiais por `nome` (busca case-insensitive e por conteúdo).
    *   Filtragem de Pátios por `filialId`.
*   **Tratamento Centralizado de Erros:** Uso de `@RestControllerAdvice` para capturar exceções (`EntityNotFoundException`, `MethodArgumentNotValidException`, etc.) e retornar respostas de erro padronizadas (HTTP 404, 400, 500).
*   **Utilização de DTOs:** Separação clara entre a representação interna (Entidades) e a externa (DTOs) para a API.
*   **Boas Práticas REST:** Uso correto dos verbos HTTP (GET, POST, PUT, DELETE), códigos de status HTTP (200, 201, 204, 400, 404, 500) e URLs semânticas.
*   **Documentação Interativa:** Geração automática de documentação da API com Swagger UI via SpringDoc OpenAPI.

## 4. Como Executar o Projeto

**Pré-requisitos:**
*   JDK 17 ou superior instalado.
*   Maven instalado.
*   IDE de sua preferência (Eclipse, IntelliJ IDEA, VS Code com extensões Java).

**Passos:**

1.  **Clone o Repositório:**
    ```bash
    git clone <url-do-seu-repositorio>
    cd <diretorio-do-projeto>
    ```

2.  **Compile e Empacote (Opcional, se quiser gerar o JAR):**
    ```bash
    mvn clean package
    ```

3.  **Execute a Aplicação:**
    *   **Via Maven:**
        ```bash
        mvn spring-boot:run
        ```
    *   **Via IDE:** Importe o projeto como um projeto Maven e execute a classe principal que contém a anotação `@SpringBootApplication` (provavelmente `ChallengeMottuApplication.java` ou similar).
    *   **Via JAR (após o passo 2):**
        ```bash
        java -jar target/<nome-do-arquivo>.jar
        ```

A aplicação estará rodando por padrão na porta `8080`.

## 5. Acessando a Documentação da API (Swagger UI)

Com a aplicação rodando, acesse a documentação interativa da API no seu navegador através do seguinte endereço:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

*(Ajuste a porta se você a configurou de forma diferente no `application.properties`)*

A interface do Swagger UI permite visualizar todos os endpoints disponíveis, seus parâmetros, corpos de requisição/resposta esperados e testar a API diretamente pelo navegador.

## 6. Endpoints Principais

Consulte a documentação do Swagger UI para a lista completa e detalhada.

*   **Filiais:**
    *   `GET /filiais`: Lista filiais (paginado, ordenado, filtro por nome).
    *   `POST /filiais`: Cria uma nova filial.
    *   `GET /filiais/{id}`: Busca uma filial por ID.
    *   `PUT /filiais/{id}`: Atualiza uma filial.
    *   `DELETE /filiais/{id}`: Deleta uma filial.
*   **Patios:**
    *   `GET /patios`: Lista pátios (paginado, ordenado, filtro por filialId).
    *   `POST /patios`: Cria um novo pátio.
    *   `GET /patios/{id}`: Busca um pátio por ID.
    *   `PUT /patios/{id}`: Atualiza um pátio.
    *   `DELETE /patios/{id}`: Deleta um pátio.

---
*Este README foi gerado com base na colaboração e desenvolvimento do projeto.*

