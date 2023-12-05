CREATE TABLE JogosUsuarios (
    id_jogo SERIAL REFERENCES Jogos(id),
    id_usuario SERIAL REFERENCES Usuarios(id),
    PRIMARY KEY (id_jogo, id_usuario)
);