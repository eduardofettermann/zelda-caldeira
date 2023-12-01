CREATE TABLE Jogos (
    IdDbJogo SERIAL NOT NULL PRIMARY KEY,
    usuario_id INTEGER,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    desenvolvedor VARCHAR(100) NOT NULL,
    editor VARCHAR(100) NOT NULL,
    dataDeLancamento VARCHAR(100) NOT NULL,
    id Varchar(100) Not NULL,
    FOREIGN KEY (usuario-id) REFERENCES Usuarios(id)
);