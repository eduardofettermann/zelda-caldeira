package com.github.zeldacaldeira.service;

import com.github.zeldacaldeira.model.Usuario;
import com.github.zeldacaldeira.model.UsuarioAtualizado;
import com.github.zeldacaldeira.repository.UsuarioInterinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioInterinoRepository usuarioInterinoRepository;

    public Optional<Usuario> getUsuarioById(Long id) {
        if (usuarioInterinoRepository.existsById(id)) {
            return usuarioInterinoRepository.findById(id);
        }
        return Optional.empty();
    }

    public List<Usuario> getUsuarios() {
        return usuarioInterinoRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioInterinoRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, UsuarioAtualizado atualizacaoDoUsuario) {
        if (usuarioInterinoRepository.existsById(id)) {
            Usuario usuario = new Usuario(atualizacaoDoUsuario);
            usuario.setId(id);
            return usuarioInterinoRepository.save(usuario);
        }
        return null;
    }

    public void deletarUsuario(long id) {
        usuarioInterinoRepository.deleteById(id);
    }
}
