# 🛒 API RESTful - Sistema de Estoque de Produtos

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

API RESTful completa para gerenciamento de estoque de produtos, desenvolvida com Spring Boot, JPA/Hibernate e banco de dados H2.

## 📋 Índice

- [Características](#-características)
- [Tecnologias](#-tecnologias)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação](#-instalação)
- [Executando a Aplicação](#-executando-a-aplicação)
- [Endpoints da API](#-endpoints-da-api)
- [Exemplos de Uso](#-exemplos-de-uso)
- [Documentação Swagger](#-documentação-swagger)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Validações](#-validações)
- [Banco de Dados](#-banco-de-dados)
- [Contribuindo](#-contribuindo)
- [Licença](#-licença)

## ✨ Características

- ✅ **CRUD Completo** - Criar, Ler, Atualizar e Deletar produtos
- ✅ **Validação de Dados** - Bean Validation com mensagens personalizadas
- ✅ **Tratamento de Exceções** - Respostas de erro formatadas e consistentes
- ✅ **Documentação Automática** - Swagger UI integrado
- ✅ **Banco H2** - Banco de dados em memória para desenvolvimento
- ✅ **Console H2** - Interface web para visualizar dados
- ✅ **Arquitetura em Camadas** - Controller, Service, Repository
- ✅ **RESTful** - Seguindo as melhores práticas REST

## 🚀 Tecnologias

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **Spring Validation**
- **H2 Database**
- **Lombok**
- **SpringDoc OpenAPI 2.3.0** (Swagger)
- **Maven**

## 📦 Pré-requisitos

Antes de começar, você precisa ter instalado:

- [Java JDK 21+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.6+](https://maven.apache.org/download.cgi) (ou use o Maven Wrapper incluído)
- [Git](https://git-scm.com/) (opcional)

## 🔧 Instalação

1. **Clone o repositório** (ou baixe o ZIP)

```bash
git clone <url-do-repositorio>
cd minha-api
```

2. **Compile o projeto**

```bash
mvn clean install
```

Ou usando o Maven Wrapper (Windows):

```bash
mvnw.cmd clean install
```

## ▶️ Executando a Aplicação

### Opção 1: Usando Maven

```bash
mvn spring-boot:run
```

### Opção 2: Usando Maven Wrapper (Windows)

```bash
mvnw.cmd spring-boot:run
```

### Opção 3: Executando o JAR

```bash
mvn clean package
java -jar target/minha-api-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em: **http://localhost:8080**

## 🌐 Endpoints da API

### Base URL: `/api/produtos`

| Método | Endpoint | Descrição | Status de Resposta |
|--------|----------|-----------|-------------------|
| `GET` | `/api/produtos/` | Teste da API | 200 OK |
| `GET` | `/api/produtos` | Listar todos os produtos | 200 OK |
| `GET` | `/api/produtos/{id}` | Buscar produto por ID | 200 OK / 404 Not Found |
| `POST` | `/api/produtos` | Criar novo produto | 201 Created |
| `PUT` | `/api/produtos/{id}` | Atualizar produto existente | 200 OK / 404 Not Found |
| `DELETE` | `/api/produtos/{id}` | Deletar produto | 204 No Content / 404 Not Found |

## 📝 Exemplos de Uso

### 1. Criar um Produto (POST)

```bash
curl -X POST http://localhost:8080/api/produtos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Notebook Dell",
    "preco": 3500.00,
    "modelo": "Inspiron 15",
    "descricao": "Notebook para uso profissional"
  }'
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "nome": "Notebook Dell",
  "preco": 3500.00,
  "modelo": "Inspiron 15",
  "descricao": "Notebook para uso profissional"
}
```

### 2. Listar Todos os Produtos (GET)

```bash
curl http://localhost:8080/api/produtos
```

**Resposta (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "Notebook Dell",
    "preco": 3500.00,
    "modelo": "Inspiron 15",
    "descricao": "Notebook para uso profissional"
  }
]
```

### 3. Buscar Produto por ID (GET)

```bash
curl http://localhost:8080/api/produtos/1
```

### 4. Atualizar Produto (PUT)

```bash
curl -X PUT http://localhost:8080/api/produtos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Notebook Dell Atualizado",
    "preco": 3200.00,
    "modelo": "Inspiron 15",
    "descricao": "Notebook com desconto"
  }'
```

### 5. Deletar Produto (DELETE)

```bash
curl -X DELETE http://localhost:8080/api/produtos/1
```

**Resposta (204 No Content)** - Sem corpo de resposta

## 📚 Documentação Swagger

A API possui documentação interativa gerada automaticamente com Swagger UI.

**Acesse:** http://localhost:8080/swagger-ui.html

Você pode testar todos os endpoints diretamente pela interface do Swagger!

**API Docs JSON:** http://localhost:8080/api-docs

## 📁 Estrutura do Projeto

```
minha-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/example/minha_api/
│   │   │       ├── controller/
│   │   │       │   └── EstoqueController.java      # Endpoints REST
│   │   │       ├── service/
│   │   │       │   └── ProdutoService.java         # Lógica de negócio
│   │   │       ├── repository/
│   │   │       │   └── ProdutoRepository.java      # Acesso a dados
│   │   │       ├── model/
│   │   │       │   └── ProdutoModelo.java          # Entidade JPA
│   │   │       ├── exception/
│   │   │       │   └── GlobalExceptionHandler.java # Tratamento de erros
│   │   │       └── MinhaApiApplication.java        # Classe principal
│   │   └── resources/
│   │       └── application.properties              # Configurações
│   └── test/
│       └── java/
│           └── br/com/example/minha_api/
│               └── MinhaApiApplicationTests.java
├── pom.xml                                         # Dependências Maven
└── README.md                                       # Este arquivo
```

## ✅ Validações

A API implementa validações automáticas nos campos:

| Campo | Validação | Mensagem de Erro |
|-------|-----------|------------------|
| `nome` | Obrigatório (não vazio) | "Nome é obrigatório" |
| `preco` | Obrigatório e positivo | "Preço é obrigatório" / "Preço deve ser positivo" |
| `modelo` | Opcional | - |
| `descricao` | Opcional | - |

**Exemplo de erro de validação (400 Bad Request):**

```json
{
  "nome": "Nome é obrigatório",
  "preco": "Preço deve ser positivo"
}
```

## 🗄️ Banco de Dados

A aplicação usa **H2 Database** (banco em memória) para desenvolvimento.

### Console H2

Acesse o console web do H2 em: **http://localhost:8080/h2-console**

**Configurações de conexão:**
- **JDBC URL:** `jdbc:h2:mem:produtosdb`
- **Username:** `sa`
- **Password:** *(deixe em branco)*

### Configuração (application.properties)

```properties
spring.datasource.url=jdbc:h2:mem:produtosdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
```

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](../LICENSE) para mais detalhes.

---

## 🎯 Próximos Passos

- [ ] Adicionar testes unitários e de integração
- [ ] Implementar paginação na listagem
- [ ] Adicionar filtros de busca (por nome, preço, etc.)
- [ ] Implementar autenticação e autorização (Spring Security)
- [ ] Migrar para banco de dados persistente (PostgreSQL/MySQL)
- [ ] Adicionar cache (Redis)
- [ ] Implementar versionamento da API

---

<div align="center">

**Desenvolvido com ☕ e Spring Boot**

⭐ Se este projeto foi útil, considere dar uma estrela!

</div>
