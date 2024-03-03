package com.github.zeldacaldeira.model.usuario;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Usuario")
@Table(name = "Usuarios")
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String senha;
    private String nome;
    private Integer idade;

    public Usuario(CadastroDTO cadastroDTO) {
        this.email = cadastroDTO != null ? cadastroDTO.email() : null;
        this.senha = cadastroDTO != null ? cadastroDTO.senha() : null;
        this.nome = cadastroDTO != null ? cadastroDTO.nome() : null;
        this.idade = cadastroDTO != null ? cadastroDTO.idade() : null;
    }


    public void atualizarUsuario(AtualizacaoUsuarioDTO atualizacaoUsuarioDTO) {
        if (atualizacaoUsuarioDTO.nome() != null) {
            this.nome = atualizacaoUsuarioDTO.nome();
        }
        if (atualizacaoUsuarioDTO.idade() != null) {
            this.idade = atualizacaoUsuarioDTO.idade();
        }
        if (atualizacaoUsuarioDTO.email() != null) {
            this.email = atualizacaoUsuarioDTO.email();
        }
    }
}