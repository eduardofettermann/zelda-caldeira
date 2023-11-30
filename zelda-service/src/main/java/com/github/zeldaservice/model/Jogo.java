package com.github.zeldaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity(name = "Jogo")
@Table(name = "Jogos")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Jogo {

    @JsonProperty(value = "name")
    @Column(length = 1000)
    private String nome;
    @JsonProperty(value = "description")
    @Column(length = 1000)
    private String descricao;
    @JsonProperty(value = "developer")
    @Column(length = 1000)
    private String desenvolvedor;
    @JsonProperty(value = "publisher")
    @Column(length = 1000)
    private String editor;
    @JsonProperty(value = "released_date")
    @Column(length = 1000)
    private String dataDeLancamento;
    @Id
    private String id;
}
