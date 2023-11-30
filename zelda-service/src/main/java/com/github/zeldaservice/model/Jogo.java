package com.github.zeldaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Jogo {

    @JsonProperty(value = "name")
    private String nome;
    @JsonProperty(value = "description")
    private String descricao;
    @JsonProperty(value = "developer")
    private String desenvolvedor;
    @JsonProperty(value = "publisher")
    private String editor;
    @JsonProperty(value = "released_date")
    @Column(length = 1000)
    private String dataDeLancamento;
    private String id;
}
