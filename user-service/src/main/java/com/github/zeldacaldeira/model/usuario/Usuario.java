package com.github.zeldacaldeira.model.usuario;

import com.github.zeldacaldeira.model.jogo.Jogo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Usuario")
@Table(name = "Usuarios")
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String senha;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    private String nome;
    private int idade;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Usuarios_Jogos_Favoritos",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "jogo_id")
    )
    private List<Jogo> jogosFavoritos;

    public Usuario(CadastroDTO cadastroDTO) {
        this.login = cadastroDTO.login();
        this.senha = cadastroDTO.senha();
        this.cargo = cadastroDTO.cargo();
        this.nome = cadastroDTO.nome();
        this.idade = cadastroDTO.idade();
    }


    public Usuario(String nome, int idade, String login, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.cargo == Cargo.ADMINISTRADOR) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"),
                    new SimpleGrantedAuthority("ROLE_USUARIO"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}