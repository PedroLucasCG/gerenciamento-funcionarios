# API DE GERENCIAMENTO DE FUNCIONARIOS
Essa API conta com endpoints para fazer o CRUD básico na entidade funcionários, segue a lista desses endpoints.

#### A url base da API é a seguinte: localhost:8080/gerenciamento-funcionarios/api/ para os endpoints:
* POST v1/funcionario - cria funcionario novo
* GET v1/funcionario/:idFuncionario - retorna o funcionário passado por id, com erro 404 caso não encontrado
* GET v1/funcionario/todos - retorna todos os funcionários cadastrados
* PATCH v1/funcionario/:idFuncionario - atualiza o funcionário passado por id
* DELETE v1/funcionario/:idFuncionario - deleta o funcionário passado por id

# Sobre a API

- A API foi construída usando Java Spring Boot
- A API foi construída usando a divisão de responsabilidade DDD com a seguinte estrutura de pastas:
```
  src/
  ├── main/
  │   ├── java/
  │   │   └── com/
  │   │       └── wakanda/
  │   │           └── gestao_funcionarios/
  │   │               ├── funcionarios/
  │   │               │   ├── application/
  │   │               │   │   ├── api/
  │   │               │   │   │   ├── FuncionarioAPI.java
  │   │               │   │   │   ├── FuncionarioAtualizarRequest.java
  │   │               │   │   │   ├── FuncionarioRestController.java
  │   │               │   │   │   ├── FuncionarioSalvarRequest.java
  │   │               │   │   │   ├── FuncionarioSalvoResponse.java
  │   │               │   │   │   ├── FuncionarioSimpleResponse.java
  │   │               │   │   │   └── FuncionarioSingleResponse.java
  │   │               │   │   └── service/
  │   │               │   │       ├── FuncionarioApplicationService.java
  │   │               │   │       └── FuncionarioService.java
  │   │               │   ├── domain/
  │   │               │   │   ├── Designacao.java
  │   │               │   │   ├── Endereco.java
  │   │               │   │   └── Funcionario.java
  │   │               │   └── infra/
  │   │               │       ├── FuncionarioHashMapRepository.java
  │   │               │       └── FuncionarioRepository.java
  │   │               ├── handler/
  │   │               │   ├── APIException.java
  │   │               │   ├── ErrorApiResponse.java
  │   │               │   └── RestResponseEntityExceptionHandler.java
  │   │               └── GestaoFuncionariosApplication.java
  │   └── resources/
  ├── test/java/com/funcionarios/wakanda/gestao_funcionarios/
  │   └── application/
  │       └── service/
  │           └── FuncionarioApplicationServiceTest.java
  ├── DataHelper.java
  └── GestaoFuncionariosApplicationTests.java
```
- A API possui testes para todos os métodos do service de funcionário.
- A API não conta com autenticação
- A persistência é feita usando HashMaps

