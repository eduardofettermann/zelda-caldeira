CREATE TABLE Usuarios (
    id SERIAL NOT NULL PRIMARY KEY,
    email TEXT NOT NULL UNIQUE,
    senha TEXT NOT NULL,
    nome TEXT NOT NULL,
    cargo VARCHAR(255) NOT NULL,
    idade INTEGER NOT NULL
);