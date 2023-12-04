package com.github.zeldacaldeira.service;

import com.github.zeldacaldeira.model.usuario.Usuario;
import com.github.zeldacaldeira.model.usuario.AtualizacaoUsuario;
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

//    public Usuario saveUsuario(AtualizacaoUsuario atualizacaoUsuario) {
//        return usuarioRepository.save(new Usuario(atualizacaoUsuario));
//    }

//    public Usuario updateUsuario(Long id, AtualizacaoUsuario atualizacaoDoUsuario) {
//        if (usuarioRepository.existsById(id)) {
//            Usuario usuario = new Usuario(atualizacaoDoUsuario);
//            usuario.setId(id);
//            return usuarioRepository.save(usuario);
//        }
//        return null;
//    }

    public boolean deletarUsuario(long id) {
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
