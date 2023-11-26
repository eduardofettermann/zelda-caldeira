package com.github.zeldacaldeira.service;

import com.github.zeldacaldeira.model.Usuario;
import com.github.zeldacaldeira.model.UsuarioDTO;
import com.github.zeldacaldeira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUsuarioById(Long id) {
        if (usuarioRepository.existsById(id)) {
            return usuarioRepository.findById(id);
        }
        return Optional.empty();
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(UsuarioDTO usuarioDTO) {
        return usuarioRepository.save(new Usuario(usuarioDTO));
    }

    public Usuario updateUsuario(Long id, UsuarioDTO atualizacaoDoUsuario) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = new Usuario(atualizacaoDoUsuario);
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void deletarUsuario(long id) {
        usuarioRepository.deleteById(id);
    }
}
