## Projeto Zelda-Caldeira

O projeto Zelda-Caldeira é um serviço que consome uma API externa do jogo The Legend of Zelda e oferece funcionalidades relacionadas ao cadastro e gerenciamento de usuários, bem como a interação com informações sobre jogos da franquia.

## Descrição

O sistema conta com recursos de autenticação de usuários, permitindo o cadastro e login, com a geração de tokens de autenticação. Além disso, há funcionalidades para listar, buscar, atualizar e deletar usuários. Os usuários podem favoritar jogos da franquia Zelda, proporcionando uma experiência personalizada.

O projeto utiliza tecnologias como Spring Boot, Spring WebFlux, Spring Security, Spring Cloud Gateway e JWT (JSON Web Tokens), proporcionando uma arquitetura robusta e segura.

## Endpoints da API

### Cadastra Usuário

```http
  POST http://localhost:8081/zeldacaldeira/autenticacao/cadastro
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `cadastroDTO` | `json` | Permite que os usuários se cadastrem fornecendo login, senha, cargo, nome e idade. |

**Exemplo de Requisição:**

```json
POST /zeldacaldeira/autenticacao/cadastro
Content-Type: application/json

{
  "login": "novo_usuario",
  "senha": "senha123",
  "cargo": "USUARIO",
  "nome": "Novo Usuário",
  "idade": 25
}
```

**Exemplo de Resposta (HTTP Status 200 OK):**

```json
HTTP/1.1 200 OK
```

### Login do Usuário

```http
  POST http://localhost:8081/zeldacaldeira/autenticacao/login
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `loginDTO`      | `json` | Permite que os usuários realizem login e recebam um token de autenticação. |

**Exemplo de Requisição:**

```json
POST /zeldacaldeira/autenticacao/login
Content-Type: application/json

{
  "login": "novo_usuario",
  "senha": "senha123"
}
```

**Exemplo de Resposta (HTTP Status 200 OK):**

```json
HTTP/1.1 200 OK
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### Gerenciamento de Usuários

#### Listar Todos Usuários

```http
  GET http://localhost:8081/zeldacaldeira/usuarios
```

| Parâmetro   | Tipo       | Descrição                            |
| :---------- | :--------- | :----------------------------------- |
| `Authorization` | `header` | Token de autenticação do usuário.    |

**Exemplo de Requisição:**

```json
GET /zeldacaldeira/usuarios
Authorization: Bearer SEU_TOKEN
```

**Exemplo de Resposta (HTTP Status 200 OK):**

```json
HTTP/1.1 200 OK
[
  {
    "id": 1,
    "login": "usuario1",
    "cargo": "USUARIO",
    "nome": "Usuário 1",
    "idade": 30
  },
  {
    "id": 2,
    "login": "usuario2",
    "cargo": "ADMINISTRADOR",
    "nome": "Usuário 2",
    "idade": 25
  }
]
```

#### Listar Usuário pelo ID

```http
  GET http://localhost:8081/zeldacaldeira/usuarios/{id}
```

| Parâmetro   | Tipo       | Descrição                            |
| :---------- | :--------- | :----------------------------------- |
| `Authorization` | `header` | Token de autenticação do usuário.    |

**Exemplo de Requisição:**

```json
GET /zeldacaldeira/usuarios/1
Authorization: Bearer SEU_TOKEN
```

**Exemplo de Resposta (HTTP Status 200 OK):**

```json
HTTP/1.1 200 OK
{
  "id": 1,
  "login": "usuario1",
  "cargo": "USUARIO",
  "nome": "Usuário 1",
  "idade": 30
}
```

#### Atualizar Usuário

```http
  PUT http://localhost:8081/zeldacaldeira/usuarios/atualizar/{id}
```

| Parâmetro   | Tipo       | Descrição                            |
| :---------- | :--------- | :----------------------------------- |
| `atualizacaoDoUsuario` | `json` | Dados a serem atualizados do usuário. |
| `Authorization` | `header` | Token de autenticação do usuário.    |

**Exemplo de Requisição:**

```json
PUT /zeldacaldeira/usuarios/atualizar/1
Content-Type: application/json
Authorization: Bearer SEU_TOKEN

{
  "nome": "Novo Nome"
}
```

**Exemplo de Resposta (HTTP Status 200 OK):**

```json
HTTP/1.1 200 OK
{
  "id": 1,
  "login": "usuario1",
  "cargo": "USUARIO",
  "nome": "Novo Nome",
  "idade": 30
}
```

#### Deletar Usuário

```http
  DELETE http://localhost:8081/zeldacaldeira/usuarios/deletar/{id}
```

| Parâmetro   | Tipo       | Descrição                            |
| :---------- | :--------- | :----------------------------------- |
| `Authorization` | `header` | Token de autenticação do usuário (Administrador). |

**Exemplo de Requisição:**

```json
DELETE /zeldacaldeira/usuarios/deletar/1
Authorization: Bearer SEU_TOKEN
```

**Exemplo de Resposta (HTTP Status 200 OK):**

```json
HTTP/1.1 200 OK
```

#### Favoritar Jogo

```http
  POST http://localhost:8081/zeldacaldeira/usuarios/{idDoUsuario}/favoritar/{idDoJogo}
```

| Parâmetro   | Tipo       | Descrição                            |
| :---------- | :--------- | :----------------------------------- |
| `Authorization` | `header` | Token de autenticação do usuário.    |

**Exemplo de Requisição:**

```json
POST /zeldacaldeira/usuarios/1/favoritar/5f6ce9d805615a85623ec2ba
Authorization: Bearer SEU_TOKEN
```

**Exemplo de Resposta (HTTP Status 200 OK):**

```

json
HTTP/1.1 200 OK
{
  "id": 1,
  "login": "usuario1",
  "cargo": "USUARIO",
  "nome": "Usuário 1",
  "idade": 30,
  "jogosFavoritos": [
    {
      "id": "5f6ce9d805615a85623ec2ba",
      "nome": "The Legend of Zelda: Ocarina of Time",
      "descricao": "Um clássico da Nintendo 64",
      "desenvolvedor": "Nintendo",
      "editor": "Nintendo",
      "dataDeLancamento": "21/11/1998"
    }
  ]
}
```

#### Listar Jogos do Zelda

```http
  GET http://localhost:8081/zeldacaldeira/jogos
```

| Parâmetro   | Tipo       | Descrição                            |
| :---------- | :--------- | :----------------------------------- |
| `Authorization` | `header` | Token de autenticação do usuário.    |

**Exemplo de Requisição:**

```json
GET /zeldacaldeira/jogos
Authorization: Bearer SEU_TOKEN
```

**Exemplo de Resposta (HTTP Status 200 OK):**

```json
HTTP/1.1 200 OK
{
  "success": true,
  "count": 20,
  "data": [
    {
      "id": "5f6ce9d805615a85623ec2b7",
      "name": "The Legend of Zelda",
      "description": "The Legend of Zelda is the first installment of the Zelda series. It centers its plot around a boy named Link, who becomes the central protagonist throughout the series. It came out as early as 1986 for the Famicom in Japan, and was later released in the western world, including Europe and the US in 1987. It has since then been re-released several times, for the Nintendo GameCube as well as the Game Boy Advance. The Japanese version of the game on the Famicom is known as The Hyrule Fantasy: The Legend of Zelda. ",
      "developer": "Nintendo R&D 4",
      "publisher": "Nintendo",
      "released_date": " February 21, 1986"
    },
    // Outros jogos...
  ]
}
```

#### Buscar Jogo do Zelda por ID

```http
  GET http://localhost:8081/zeldacaldeira/jogos/{id}
```

| Parâmetro   | Tipo       | Descrição                            |
| :---------- | :--------- | :----------------------------------- |
| `Authorization` | `header` | Token de autenticação do usuário.    |

**Exemplo de Requisição:**

```json
GET /zeldacaldeira/jogos/1
Authorization: Bearer SEU_TOKEN
```

**Exemplo de Resposta (HTTP Status 200 OK):**

```json
HTTP/1.1 200 OK
{
  "id": "5f6ce9d805615a85623ec2b7",
  "name": "The Legend of Zelda",
  "description": "The Legend of Zelda is the first installment of the Zelda series. It centers its plot around a boy named Link, who becomes the central protagonist throughout the series. It came out as early as 1986 for the Famicom in Japan, and was later released in the western world, including Europe and the US in 1987. It has since then been re-released several times, for the Nintendo GameCube as well as the Game Boy Advance. The Japanese version of the game on the Famicom is known as The Hyrule Fantasy: The Legend of Zelda. ",
  "developer": "Nintendo R&D 4",
  "publisher": "Nintendo",
  "released_date": " February 21, 1986"
}
```

## Nota de Segurança

Ao buscar informações de usuários, a senha é retornada criptografada por motivos de segurança.

## Tecnologias Utilizadas

- Spring Boot
- Spring WebFlux
- Spring Security
- Spring Cloud Gateway
- JWT (JSON Web Tokens)
- Gradle
- PostgreSQL
- Postman