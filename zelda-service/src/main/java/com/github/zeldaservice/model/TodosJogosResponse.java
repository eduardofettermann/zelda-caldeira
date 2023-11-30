package com.github.zeldaservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class TodosJogosResponse {
    @JsonProperty(value = "success")
    private boolean sucesso;
    @JsonProperty(value = "count")
    private long contador;
    @JsonProperty(value = "data")
    private List<Jogo> dados;
}
