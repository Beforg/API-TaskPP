# API Task++

<p align="center">
  <img src="https://github.com/Beforg/assets/blob/main/taskpp/logo.png" alt="Logo" width="100" height="100">
</p>

<h1 align="center">API Task++</h1>

<p align="center">
  <img src="https://img.shields.io/badge/backend-java%20spring-%236DB33F?style=for-the-badge&logo=spring" alt="Backend Badge">
  <img src="https://img.shields.io/badge/database-postgresql-%23336791.svg?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL Badge">
</p>

## 📄 Descrição

API Task++ faz parte do projeto [Task++](https://github.com/Beforg/TaskPP), um gerenciador de tarefas desenvolvido com React no front-end. Esta API foi desenvolvida utilizando **Java com Spring Boot** e banco de dados **PostgreSQL**.

## 🚀 Como Rodar o Projeto

### Clone o repositório

```bash
 git clone https://github.com/Beforg/API-TaskPP.git
```

### Acesse o diretório do projeto

```bash
cd API-TaskPP
```

### Configure o `application.properties`

O arquivo `src/main/resources/application.properties` deve ser configurado com suas credenciais do banco de dados PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/taskpp
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### Crie o banco de dados

Certifique-se de que o banco de dados `taskpp` esteja criado:

1. Acesse o PostgreSQL:
   ```bash
   psql -U seu_usuario
   ```
2. Crie o banco de dados:
   ```sql
   CREATE DATABASE taskpp;
   ```

### Instale as dependências

```bash
./mvnw clean install
```

A API estará disponível em `http://localhost:8080`.

## 💻 Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **PostgreSQL**
- **Maven**

## 📌 Considerações Finais

Esta API foi desenvolvida para complementar o projeto front-end Task++.

---

<p align="center">Feito com ❤ por Beforg</p>
