package com.github.zeldacaldeira.model.jogo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Jogo")
@Table(name = "Jogos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
