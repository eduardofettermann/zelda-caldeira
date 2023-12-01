package com.github.zeldaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "Jogo")
@Table(name = "Jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdDbJogo;
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

    // estudar relacao entre tabelas em microsservices
}
