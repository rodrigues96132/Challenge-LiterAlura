##Desafio LiterAlura - Catálogo de Livros

**Descrição**
O Desafio LiterAlura consiste na construção de um catálogo de livros utilizando Java, Spring, Postgres e a API Gutendex, que oferece dados de mais de 70 mil livros. O objetivo é praticar o consumo de uma API e a persistência de dados em um banco de dados relacional.

Este projeto permite que você interaja com um banco de dados relacional, utilizando o Spring Data JPA para persistir informações sobre livros e autores, e consuma a API Gutendex para buscar dados de livros de domínio público. Ao final, o sistema proporciona diferentes formas de consulta para os usuários.

**Tecnologias Utilizadas**
- Java: Linguagem de programação principal.
-Spring Boot: Framework para desenvolvimento rápido de aplicações Java.
-PostgreSQL: Banco de dados relacional utilizado para persistência dos dados.
-Spring Data JPA: Biblioteca para integração com bancos de dados e manipulação de dados com a JPA (Java Persistence API).
-API Gutendex: API pública que fornece dados sobre livros de domínio público.

**Funcionalidades**
A aplicação oferece cinco opções principais para interação com o usuário:
- Buscar livro pelo título
- Realiza uma consulta na API Gutendex e insere o livro encontrado no banco de dados.
- Listar livros registrados
- Exibe todos os livros que foram inseridos no banco de dados.
- 
Lista nossos autores
- Mostra os autores registrados e seus respectivos livros.

Listar autores em determinado ano
- Retorna autores que estavam vivos em um ano específico.

Listar livros em determinado idioma
- Permite buscar livros por idioma, como português, inglês, francês e espanhol.
