package com.github.zeldacaldeira.model.usuario;

public record CadastroDTO(String login, String senha, Cargo cargo, String nome, int idade) {
}
