CREATE TABLE Jogos (
    id SERIAL NOT NULL PRIMARY KEY,
    nome TEXT NOT NULL,
    descricao TEXT NOT NULL,
    desenvolvedor TEXT NOT NULL,
    editor TEXT NOT NULL,
    dataDeLancamento NOT NULL
);