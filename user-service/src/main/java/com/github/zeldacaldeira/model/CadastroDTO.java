package com.github.zeldacaldeira.model;

import jakarta.annotation.Nullable;

public record CadastroDTO(
        String email,
        String senha,
        String nome,
        int idade) {
}
