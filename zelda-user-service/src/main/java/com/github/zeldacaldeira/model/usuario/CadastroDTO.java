package com.github.zeldacaldeira.model.usuario;

import jakarta.annotation.Nullable;

public record CadastroDTO(
        String email,
        String senha,
        @Nullable CargoEnum cargoEnum,
        String nome,
        int idade) {
}
