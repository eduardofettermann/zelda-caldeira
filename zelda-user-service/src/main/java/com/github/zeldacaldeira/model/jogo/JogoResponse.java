package com.github.zeldacaldeira.model.jogo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class JogoResponse {
    @JsonProperty(value = "success")
    private boolean sucesso;
    @JsonProperty(value = "data")
    private Jogo jogoEncontrado;

}
