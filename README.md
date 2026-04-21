# 🔐 API de Autenticação - Spring Boot

## 🚀 Tecnologias
- Java 17
- Spring Boot
- Spring Security
- JPA / Hibernate
- H2 Database
- Swagger (OpenAPI)

## 📘 Documentação
Acesse a documentação interativa:
http://localhost:8080/swagger-ui/index.html

## 🔑 Funcionalidades
- Cadastro de usuário
- Login com senha criptografada (BCrypt)
- Validação de dados
- Tratamento global de exceções

## 📦 Endpoints

### ➕ Criar usuário
POST /users

### 🔐 Login
POST /users/login

### 📄 Listar usuários
GET /users

### 🔍 Buscar usuário por ID
GET /users/{id}

### ❌ Deletar usuário
DELETE /users/{id}
