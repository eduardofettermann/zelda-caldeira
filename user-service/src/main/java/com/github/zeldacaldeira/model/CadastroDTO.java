package com.github.zeldacaldeira.model;

import jakarta.annotation.Nullable;

public record CadastroDTO(
        String email,
        String senha,
        @Nullable CargoEnum cargoEnum,
        String nome,
        int idade) {
}
