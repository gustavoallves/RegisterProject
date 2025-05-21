# Register Project

Sistema de cadastro de usuários e departamentos, desenvolvido com Java e Spring Boot. Permite criar, listar, buscar, editar e deletar registros de usuários e departamentos.

## 🔧 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de Dados Relacional (ex: H2, MySQL ou PostgreSQL)
- Maven
- Postman (para testes)
- JSON

## 🧠 Funcionalidades

### 🔹 Usuários (`/user`)
- `POST /add` - Criar usuário
- `GET /all` - Listar todos os usuários
- `GET /find/{id}` - Buscar usuário por ID
- `DELETE /delete/{id}` - Remover usuário
- `GET /welcome` - Página de boas-vindas (teste)

### 🔹 Departamentos (`/department`)
- `POST /add` - Criar departamento
- `GET /all` - Listar todos os departamentos
- `GET /find/{id}` - Buscar departamento por ID
- `PUT /edit/{id}` - Editar departamento
- `DELETE /delete/{id}` - Remover departamento

## 🔄 Relacionamento entre Entidades

- Um `Departamento` possui vários `Usuários` (`@OneToMany`)
- Um `Usuário` pertence a um único `Departamento` (`@ManyToOne`)

## 📸 Prints do Projeto
<img src="https://github.com/user-attachments/assets/e64c379e-3c97-4fd1-8a52-7c036a7329bd"/>
<img src="https://github.com/user-attachments/assets/35339d8a-b832-4bba-a4fd-1d1787eb0016" width=180/>
<img src="https://github.com/user-attachments/assets/732f880f-973d-48fd-b610-36ea75cce739" width=180/>
