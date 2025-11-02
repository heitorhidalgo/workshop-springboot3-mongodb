# Workshop Spring Boot 3 + MongoDB 🚀

Projeto desenvolvido durante o curso de **Java** ministrado pelo professor **Nélio Alves** na plataforma **Udemy**.  
O objetivo é criar uma **API RESTful** utilizando **Spring Boot** e **MongoDB**, explorando o paradigma **orientado a documentos**, operações **CRUD**, **associações entre objetos** e **consultas personalizadas** com Spring Data.

---

## 📌 Objetivos do Projeto

- Compreender as diferenças entre o paradigma **orientado a documentos** e o **relacional**  
- Implementar **operações CRUD** completas  
- Definir e aplicar **associações entre documentos**:
  - Objetos **aninhados**
  - **Referências** entre coleções  
- Criar **consultas personalizadas** com `MongoRepository` e `@Query`  
- Praticar o uso de **DTOs (Data Transfer Objects)**  
- Tratar **exceções personalizadas** em requisições REST  

---

## 🛠 Tecnologias Utilizadas

- **Java 17+**  
- **Spring Boot 3**  
- **Spring Data MongoDB**  
- **Spring Web**  
- **MongoDB**  
- **MongoDB Compass**  
- **Postman**  
- **Maven**

---

## 📐 Modelo de Domínio

O sistema simula uma **rede social simplificada**, com **usuários, posts e comentários**, modelados em um banco de dados **NoSQL (MongoDB)**.

### Entidades Principais

- **User** → usuário do sistema  
- **Post** → publicação feita por um usuário  
- **CommentDTO** → comentários associados aos posts  
- **AuthorDTO** → projeção dos dados do autor dentro de um post  

### Estrutura de Relacionamentos

- Um **User** pode ter vários **Posts**  
- Cada **Post** possui um **AuthorDTO** (usuário aninhado)  
- Cada **Post** contém uma lista de **CommentDTO**, com informações do autor e data do comentário  

---

## 🚀 Como Executar o Projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/heitorhidalgo/workshop-springboot3-mongodb.git
cd workshop-springboot3-mongodb
```

### 2️⃣ Verificar dependências

Certifique-se de ter instalado:

- **Java 17+**
- **Maven**
- **MongoDB**

### 3️⃣ Subir o servidor do MongoDB

```bash
mongod
```

Por padrão, o projeto conecta-se ao banco:

```
mongodb://localhost:27017/workshop_mongo
```

### 4️⃣ Executar o projeto

```bash
mvn spring-boot:run
```

### 5️⃣ Acessar a aplicação

- **API:** [http://localhost:8080](http://localhost:8080)

---

## 📡 Endpoints Principais (API REST)

### 👤 Usuários

| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| GET | `/users` | Lista todos os usuários |
| GET | `/users/{id}` | Busca usuário por ID |
| POST | `/users` | Cria novo usuário |
| PUT | `/users/{id}` | Atualiza usuário existente |
| DELETE | `/users/{id}` | Remove usuário |
| GET | `/users/{id}/posts` | Lista os posts de um usuário |

#### Exemplo de JSON para POST `/users`
```json
{
  "name": "Maria Brown",
  "email": "maria@gmail.com"
}
```

---

### 📝 Posts

| Método | Endpoint | Descrição |
|--------|-----------|-----------|
| GET | `/posts/{id}` | Retorna um post por ID |
| GET | `/posts/titlesearch?text={texto}` | Busca posts contendo texto no título |
| GET | `/posts/fullsearch?text={texto}&minDate={data1}&maxDate={data2}` | Busca posts por texto e intervalo de datas |

#### Exemplo de JSON de um Post
```json
{
  "id": "5010",
  "date": "2025-11-02",
  "title": "Bom dia!",
  "body": "Acordei feliz hoje!",
  "author": {
    "id": "1001",
    "name": "Maria Brown"
  },
  "comments": [
    {
      "text": "Tenha um ótimo dia!",
      "date": "2025-11-02",
      "author": {
        "id": "1002",
        "name": "Alex Green"
      }
    }
  ]
}
```

---

## ⚙️ Estrutura do Projeto

- `domain/` → classes de domínio (`User`, `Post`)  
- `dto/` → objetos de transferência de dados (`UserDTO`, `AuthorDTO`, `CommentDTO`)  
- `repository/` → interfaces que estendem `MongoRepository`  
- `services/` → camada de regras de negócio  
- `resources/` → controladores REST  
- `config/` → configuração e povoamento inicial do banco  
- `resources/exception/` → tratamento de erros personalizados  

---

## ⚠️ Tratamento de Exceções

| Exceção | Código HTTP | Descrição |
|----------|--------------|------------|
| `ObjectNotFoundException` | 404 | Documento não encontrado |
| `DatabaseException` | 400 | Erro de integridade no banco |

#### Exemplo de resposta JSON:
```json
{
  "timestamp": "2025-11-02T15:21:22Z",
  "status": 404,
  "error": "Object not found",
  "message": "Id not found 507f1f77bcf86cd799439011",
  "path": "/users/507f1f77bcf86cd799439011"
}
```

---

## 🔍 Consultas Avançadas

- **Query Methods:** busca posts contendo determinado texto no título  
- **@Query:** consulta personalizada com expressões regulares (`$regex`)  
- **Consulta com múltiplos critérios:** busca posts contendo um texto em qualquer parte (título, corpo ou comentários) dentro de um intervalo de datas

---

## 👨‍💻 Autor

**Heitor Hidalgo**  
📎 [GitHub](https://github.com/heitorhidalgo)  
💼 [LinkedIn](https://www.linkedin.com/in/heitorhidalgo)

---

## 🙏 Agradecimentos

Agradecimento especial ao professor **Nélio Alves** pela excelente didática no curso.  
📚 Curso disponível na Udemy: [Java COMPLETO – Nélio Alves](https://www.udemy.com/course/java-curso-completo/)

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License**.
